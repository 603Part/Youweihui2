package com.youweihui.tourismstore.net.client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class BaseClient {

    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor httpLoggingInterceptor;

    protected OkHttpClient getOkHttpClient(){
        okHttpClient = new OkHttpClient();
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(30000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }
}
