
package com.peasx.app.droidglobal.ui.util;

import android.widget.TextView;

import java.math.BigDecimal;


public class TViewValue {
    
       public static String getString(TextView tf){
            return tf.getText().toString();
       }
    
       public static double getDouble(TextView tf){
            return tf.getText().toString().isEmpty() ? 0 : Double.parseDouble(tf.getText().toString());
       }
       
       public static int getInt(TextView tf){
            return tf.getText().toString().isEmpty() ? 0 : Integer.parseInt(tf.getText().toString());
       }
       
       public static BigDecimal getBigDecimal(TextView tf){
            return tf.getText().toString().isEmpty() ? BigDecimal.ZERO : new BigDecimal(tf.getText().toString());
       }
       
}
