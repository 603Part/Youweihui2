package com.youweihui.tourismstore.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youweihui.tourismstore.application.Application;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;


public class RetrofitUtil {

    private final static String TAG = "RetrofitUtil";

    private static ApiInterface apiInterface;

    public static final String baseUrl = "http://47.99.115.8:8184/travel_api/";

    private Gson gson;

    File cacheFile;

    Retrofit.Builder clientBuilder;

    Retrofit client;

    OkHttpClient okClient;

    private RetrofitUtil() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("RetrofitLog","retrofitBack = "+message);
            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (apiInterface == null) {
            cacheFile = new File(Environment.getExternalStorageDirectory(), "HttpCache");
            okhttp3.Cache cache = new okhttp3.Cache(cacheFile, 1024 * 1024 * 100);
            okClient = new OkHttpClient.Builder()
                    .addInterceptor(new LogInterceptor()) //打包注掉
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .cache(cache)
                    .build();

            gson = new GsonBuilder()
                    .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                    .serializeNulls().create();

            clientBuilder = new Retrofit.Builder();

            client = clientBuilder
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(new StringConverterFactory())
                    .build();
            apiInterface = client.create(ApiInterface.class);
        }
    }

    private static class SingletonHolder {
        private static final RetrofitUtil INSTANCE = new RetrofitUtil();
    }

    public static ApiInterface getInstance() {
        return SingletonHolder.INSTANCE.apiInterface;
    }

    private static class LogInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.v(TAG, "request:" + request.toString());
            long t1 = System.nanoTime();
            long t2 = System.nanoTime();
            Response response = chain.proceed(request);
            Log.v(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Log.i(TAG, "response body:" + content);
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    }

    private static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            int maxAge = 60 * 60; // 有网络时 设置缓存超时时间1个小时
            int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周

            if (!isNetworkReachable(Application.getInstance())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            } else {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            }

            Response response = chain.proceed(request);
            if (isNetworkReachable(Application.getInstance())) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    }

    public static void cleanCache() {
        if (SingletonHolder.INSTANCE.cacheFile.exists()) {
            SingletonHolder.INSTANCE.cacheFile.delete();
        }
    }

    public static Boolean isNetworkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }

    public class StringConverterFactory extends Converter.Factory {

        private StringConverterFactory() {

        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                                Retrofit retrofit) {
            return new StringResponseBodyConverter();
        }

        @Override
        public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                              Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
            return new StringRequestBodyConverter();
        }
    }


    public static class StringRequestBodyConverter implements Converter<String, RequestBody> {

        private final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

        private final Charset UTF_8 = Charset.forName("UTF-8");

        StringRequestBodyConverter() {

        }

        @Override
        public RequestBody convert(String value) throws IOException {
            Buffer buffer = new Buffer();
            Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
            writer.write(value);
            writer.close();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        }
    }

    public static class StringResponseBodyConverter implements Converter<ResponseBody, String> {
        @Override
        public String convert(ResponseBody value) throws IOException {
            try {
                return value.string();
            } finally {
                value.close();
            }
        }
    }
}
