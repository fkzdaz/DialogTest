package com.example.fang.dialogtest;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Fkz on 2017/4/25.
 */

public class ToastUtil {
    private static Toast toast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
