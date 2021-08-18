
package com.peasx.app.droidglobal.ui.util;


import android.graphics.Color;
import android.widget.TextView;

public class TViewSetter {

    public TViewSetter(TextView label){
        this.label = label;
    }
    
    public void setInfoText(String text){
        label.setTextColor(Color.BLACK);
        label.setText(text);
    }

    public void setSuccessText(String text){
        label.setTextColor(Color.rgb(0, 102, 102));
        label.setText(text);
    }
    
    public void setErrText(String text){
        label.setTextColor(Color.RED);
        label.setText(text);
    }


    TextView label;
}
