package com.peasx.app.droidglobal.ui.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ConfirmDialog {

    public ConfirmDialog(Context context) {
        this.context = context;
    }

    public ConfirmDialog setTitle(String title){
        this.title = title;
        return this;
    }

    public ConfirmDialog setBody(String body){
        this.text = body;
        return this;
    }


    public ConfirmDialog build(String okBtn, final OnPressOK okPress){
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(text);
        builder.setCancelable(false);

        builder.setPositiveButton(okBtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                  okPress.run();
                  dialog.dismiss();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return this;
    }


    public void show(){
            builder.show();
    }


    String title = "Message";
    String text  = "";
    AlertDialog.Builder builder;
    Context context;
}
