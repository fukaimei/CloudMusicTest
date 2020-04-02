package net.fkm.cloudmusictest.utils;

import android.util.Log;

/**
 * Log日志封装类
 */
public class L {

    //开关
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "CloudMusicTest";

    //五个等级  DIWE

    public static void d(String text) {
        if (DEBUG) {
            Log.d(TAG, text);
        }
    }

    public static void i(String text) {
        if (DEBUG) {
            Log.i(TAG, text);
        }
    }

    public static void w(String text) {
        if (DEBUG) {
            Log.w(TAG, text);
        }
    }

    public static void e(String text) {
        if (DEBUG) {
            Log.e(TAG, text);
        }
    }

    public static void log_i(String text) {  //信息太长,分段打印

        if (DEBUG) {
            //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
            //  把4*1024的MAX字节打印长度改为2001字符数
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (text.length() > max_str_length) {
                Log.i(TAG, text.substring(0, max_str_length));
                text = text.substring(max_str_length);
            }
            //剩余部分
            Log.i(TAG, text);
        }
    }

}
