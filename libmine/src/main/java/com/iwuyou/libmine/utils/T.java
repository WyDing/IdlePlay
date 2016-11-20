package com.iwuyou.libmine.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.iwuyou.libmine.R;


public class T {
    private static Toast sToast;

    private T() {

    }

    public static void shortT(Context context, String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        show(context, message, 0, Toast.LENGTH_SHORT);
//        showCustomToast(context, message, Toast.LENGTH_SHORT);
    }

    public static void shortT(Context context, int resId) {
        if (resId == 0) {
            return;
        }
        show(context, "", resId, Toast.LENGTH_SHORT);
//        showCustomToast(context, resId, Toast.LENGTH_SHORT);
    }

    public static void longT(Context context, int resId) {
        if (resId == 0) {
            return;
        }
        show(context, "", resId, Toast.LENGTH_LONG);
//        showCustomToast(context, resId, Toast.LENGTH_LONG);
    }

    public static void longT(Context context, String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        show(context, message, 0, Toast.LENGTH_LONG);
//        showCustomToast(context, message, Toast.LENGTH_LONG);
    }

    private static void show(Context context, String message, int resId, int duration) {
        if (sToast == null) {
            if (TextUtils.isEmpty(message)) {
                sToast = Toast.makeText(context.getApplicationContext(), resId, duration);
            } else {
                sToast = Toast.makeText(context.getApplicationContext(), message, duration);
            }
            sToast.setGravity(Gravity.CENTER, 0, 0);
            sToast.show();
        } else {
            if (TextUtils.isEmpty(message)) {
                sToast.setText(resId);
            } else {
                sToast.setText(message);
            }
            sToast.setGravity(Gravity.CENTER, 0, 0);
            sToast.setDuration(duration);
            sToast.show();
        }
    }

    /**
     * 自定义Toast
     */
    private static void showCustomToast(Context context, String message, int duration) {
        TextView customTextView = getCustomTextView(context);
        customTextView.setText(message);
        if (sToast == null) {
            sToast = new Toast(context);
        }
        sToast.setDuration(duration);
        sToast.setView(customTextView);
        sToast.setGravity(Gravity.CENTER, 0, 0);
        sToast.setDuration(duration);
        sToast.show();
    }

    /**
     * 自定义Toast
     */
    private static void showCustomToast(Context context, int resId, int duration) {
        TextView customTextView = getCustomTextView(context);
        customTextView.setText(resId);
        if (sToast == null) {
            sToast = new Toast(context);
            sToast.setDuration(duration);
            sToast.setGravity(Gravity.CENTER, 0, 0);
        }
        sToast.setView(customTextView);
        sToast.setDuration(duration);
        sToast.show();
    }

    /**
     * 自定义Toast显示的TextView
     *
     * @param context
     * @return
     */
    private static TextView getCustomTextView(Context context) {
        TextView customToastView = new TextView(context);
        int toastMinWidth = context.getResources().getDimensionPixelSize(R.dimen.toast_min_width);
        int toastMaxWidth = context.getResources().getDimensionPixelSize(R.dimen.toast_max_width);
        int toastMinHeight = context.getResources().getDimensionPixelSize(R.dimen.toast_min_height);
//        int toastMaxHeight = context.getResources().getDimensionPixelSize(R.dimen.toast_max_height);
        int toastPaddingVertical = context.getResources().getDimensionPixelSize(R.dimen.toast_padding_vertical);
        int toastPaddingHorizontal = context.getResources().getDimensionPixelSize(R.dimen.toast_padding_horizontal);
        customToastView.setTextSize(18);
        customToastView.setTextColor(Color.WHITE);
        customToastView.setGravity(Gravity.CENTER);
        customToastView.setMaxWidth(toastMaxWidth);
        customToastView.setMinWidth(toastMinWidth);
        customToastView.setMinHeight(toastMinHeight);
//        customToastView.setMaxHeight(toastMaxHeight);
        customToastView.setBackgroundResource(R.drawable.toast_background_shape);
        customToastView.setPadding(toastPaddingHorizontal, toastPaddingVertical, toastPaddingHorizontal, toastPaddingVertical);
        return customToastView;
    }
}
