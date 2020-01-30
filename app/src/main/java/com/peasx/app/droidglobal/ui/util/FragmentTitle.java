package com.peasx.app.droidglobal.ui.util;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.peasx.app.droidglobal.R;

public class FragmentTitle {

    public static void change(Context context, String title){
        activity = (AppCompatActivity)context;
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
    }

    public static void changeToHome(Context context, String title){
        activity = (AppCompatActivity)context;
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer_menu);
    }

    static AppCompatActivity activity;
}
