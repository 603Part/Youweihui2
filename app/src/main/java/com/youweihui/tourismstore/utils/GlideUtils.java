package com.youweihui.tourismstore.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.youweihui.tourismstore.view.CustomImageView;

/**
 * Created by ${范泽宁} on 2018/12/13.
 */

public class GlideUtils {

    public static void showToImageView(Context mContext, ImageView imageView, String target) {
        Glide.with(mContext).load(target).into(imageView);
    }

    public static void showToImageView(Context mContext, CustomImageView imageView, String target) {
        Glide.with(mContext).load(target).into(imageView);
    }

    public static void showToCircleImageView(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imageView);
    }
}
