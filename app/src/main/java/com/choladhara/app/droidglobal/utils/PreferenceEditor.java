package com.choladhara.app.droidglobal.utils;


import android.content.Context;
import android.content.SharedPreferences;


public class PreferenceEditor {
    public PreferenceEditor(Context context, String fileName){
        this.context = context;
        this.PREFERENCE_FILE = fileName;
    }

    public PreferenceEditor(Context context){
        this.context = context;
    }

    Context context;
    String PREFERENCE_FILE = "USER_DATA";

    public String getStringValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        String str = sharedPreferences.getString(key, "");
        return str;
    }

    public long getLongValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        long l = sharedPreferences.getLong(key, 0);
        return l;
    }


    public int getIntValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        int i = sharedPreferences.getInt(key, 0);
        return i;
    }

    public double getFloatValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        Float f = sharedPreferences.getFloat(key, 0);
        return f;
    }


    public void setStringValue(String key, String Value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(key, Value);
        editor.commit();
    }

    public void setLongValue(String key, long Value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putLong(key, Value);
        editor.commit();
    }

    public void setIntValue(String key, int Value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putInt(key, Value);
        editor.commit();
    }


    public void setFloatValue(String key, Float Value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putFloat(key, Value);
        editor.commit();
    }


}
