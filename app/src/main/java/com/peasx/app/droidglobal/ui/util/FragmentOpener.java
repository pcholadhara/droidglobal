package com.peasx.app.droidglobal.ui.util;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.peasx.app.droidglobal.R;

public class FragmentOpener  {
    Context context;
    public FragmentOpener(Context context){
        this.context = context;
    }

    public void Open(Fragment fragment){
        String back_stack = fragment.getClass().getName().toString().toUpperCase();
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment, back_stack);
        ft.addToBackStack("A_"+back_stack);
        ft.commit();
    }


    public void Open(Fragment fragment, Bundle args){
        fragment.setArguments(args);
        String back_stack = fragment.getClass().getName().toString().toUpperCase();
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment, back_stack);
        ft.addToBackStack("A_"+back_stack);
        ft.commit();
    }


    public void Open(int View_Id, Fragment fragment, Bundle args){
        fragment.setArguments(args);
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(View_Id, fragment);
        ft.commit();
    }

    public void Replace(Fragment fragment){
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.commit();
    }

    public void Replace(int View_Id, Fragment fragment){
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(View_Id, fragment);
        ft.commit();
    }

    public void OpenDialog(DialogFragment fragment){
        fragment.setCancelable(false);
        String tag = fragment.getClass().getName().toString().toUpperCase();
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        fragment.show(fm, tag);
    }

    public void OpenDialog(DialogFragment fragment, Bundle args){
        fragment.setArguments(args);
        fragment.setCancelable(false);
        String tag = fragment.getClass().getName().toString().toUpperCase();
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        fragment.show(fm, tag);
    }


}
