package com.denr.solidwaste.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BindingUtil {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions();
        options.fitCenter();

        Context context = imageView.getContext();
        Glide.with(context).load(url).apply(options).into(imageView);
    }
}
