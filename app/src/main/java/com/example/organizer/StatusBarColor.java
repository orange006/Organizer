package com.example.organizer;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

class StatusBarColor {
    void changeStatusBarColor(Window window){
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(Color.parseColor("blue"));
        }
    }
}