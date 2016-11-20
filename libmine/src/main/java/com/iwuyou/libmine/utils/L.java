package com.iwuyou.libmine.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * cn.creditease.framework.utils.L
 * 日志工具类
 * Created by shengy on 2015/8/25
 */
public class L {
    public static boolean DEBUG = true;
    public static final String DEFAULT_TAG = "creditease";

    public static void setLogLevel(boolean logLevel) {
        if (!logLevel) {
            DEBUG = false;
        } else {
            DEBUG = true;
        }
    }

    public static void v(String text) {
        print("", text, Log.VERBOSE);
    }

    public static void v(String tag, String text) {
        print(tag, text, Log.VERBOSE);
    }

    public static void d(String text) {
        print("", text, Log.DEBUG);
    }

    public static void d(String tag, String text) {
        print(tag, text, Log.DEBUG);
    }

    public static void i(String text) {
        print("", text, Log.INFO);
    }

    public static void i(String tag, String text) {
        print(tag, text, Log.INFO);
    }

    public static void w(String text) {
        print("", text, Log.WARN);
    }

    public static void w(String tag, String text) {
        print(tag, text, Log.WARN);
    }

    public static void e(String text) {
        print("", text, Log.ERROR);
    }

    public static void e(String tag, String text) {
        print(tag, text, Log.ERROR);
    }

    public static void e(String text, Throwable throwable) {
        print("", text + "#message:" + throwable.getMessage(), Log.ERROR);
        StackTraceElement[] elements = throwable.getStackTrace();
        for (StackTraceElement e : elements) {
            print("", e.toString(), Log.ERROR);
        }
    }

    public static void e(String tag, String text, Throwable throwable) {
        print(tag, text + "#message:" + throwable.getMessage(), Log.ERROR);
        StackTraceElement[] elements = throwable.getStackTrace();
        for (StackTraceElement e : elements) {
            print(tag, e.toString(), Log.ERROR);
        }
    }

    private static synchronized void print(String tag, final String msg, final int level) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (TextUtils.isEmpty(tag)) {
            tag = DEFAULT_TAG;
        }
        if (DEBUG) {
            switch (level) {
                case Log.VERBOSE:
                    Log.v(tag, msg);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg);
                    break;
                case Log.INFO:
                    Log.i(tag, msg);
                    break;
                case Log.WARN:
                    Log.w(tag, msg);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg);
                    break;
            }
        }

    }


}
