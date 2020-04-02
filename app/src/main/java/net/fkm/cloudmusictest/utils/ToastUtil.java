package net.fkm.cloudmusictest.utils;

import android.annotation.SuppressLint;
import android.widget.Toast;

import net.fkm.cloudmusictest.CloudMusicApplication;

import me.drakeet.support.toast.ToastCompat;

/**
 * 单例Toast
 * An Android library to hook and fix Toast BadTokenException
 */
public class ToastUtil {

    private static ToastCompat mToast;

    @SuppressLint("ShowToast")
    public static void showToast(String text) {
        if (mToast == null) {
            mToast = ToastCompat.makeText(CloudMusicApplication.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.cancel();
            mToast = ToastCompat.makeText(CloudMusicApplication.getInstance(), text, Toast.LENGTH_SHORT);
        }
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setText(text);
        mToast.show();
    }

    @SuppressLint("ShowToast")
    public static void showToastLong(String text) {
        if (mToast == null) {
            mToast = ToastCompat.makeText(CloudMusicApplication.getInstance(), text, Toast.LENGTH_LONG);
        } else {
            mToast.cancel();
            mToast = ToastCompat.makeText(CloudMusicApplication.getInstance(), text, Toast.LENGTH_LONG);
        }
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.setText(text);
        mToast.show();
    }

}
