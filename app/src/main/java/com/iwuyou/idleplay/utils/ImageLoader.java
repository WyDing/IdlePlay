package com.iwuyou.idleplay.utils;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.iwuyou.idleplay.R;

/**
 * Created by duanding on 16/11/24.
 */

public class ImageLoader {

    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).centerCrop().placeholder(R.drawable.ic_on_loading_img)
                .error(R.drawable.ic_picture_loadfailed).into(view);
    }

    /**
     * 加载图片
     *
     * @param view
     * @param url
     * @param targetWidth
     */
    public static void loadImage(ImageView view, String url, final int targetWidth) {
        Glide.with(view.getContext())
                .load(url)
                .into(new ImageViewTarget<GlideDrawable>(view) {
                    @Override
                    protected void setResource(GlideDrawable resource) {
                        autoFit(view, targetWidth, resource.getIntrinsicWidth(), resource.getIntrinsicHeight());
                        view.setImageDrawable(resource);
                    }
                });
    }

    public static void autoFit(ImageView imageView, int targetWidth, int photoWidth, int photoHeight) {
        float ratio = (targetWidth + 0f) / photoWidth;
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(targetWidth, (int) (photoHeight * ratio));
        } else {
            params.width = targetWidth;
            params.height = (int) (photoHeight * ratio);
        }
        imageView.setLayoutParams(params);
    }


}
