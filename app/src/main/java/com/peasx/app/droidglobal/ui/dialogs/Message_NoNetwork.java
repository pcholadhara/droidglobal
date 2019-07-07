package com.peasx.app.droidglobal.ui.dialogs;

import android.content.Context;

public class Message_NoNetwork {

    public static void show(Context context){
        if(dialog ==null){
            dialog = new MessageDialog(context);
            dialog.setTitle("Network Error");
            dialog.setBody("No internet connection detected in your device. Make sure your wifi or data connection is active");
            dialog.build("OK");
        }
        dialog.show();
    }

    private static MessageDialog dialog;

}
