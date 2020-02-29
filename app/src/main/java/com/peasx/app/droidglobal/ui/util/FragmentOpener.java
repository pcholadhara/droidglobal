package com.peasx.app.droidglobal.ui.util;

import android.content.Context;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
