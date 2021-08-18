
package com.peasx.app.droidglobal.ui.util;

import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;


public class ETextValue {
    
       public static String getString(EditText tf){
            return tf.getText().toString();
       }
    
       public static double getDouble(EditText tf){
            return tf.getText().toString().isEmpty() ? 0 : Double.parseDouble(tf.getText().toString());
       }
       
       public static int getInt(EditText tf){
            return tf.getText().toString().isEmpty() ? 0 : Integer.parseInt(tf.getText().toString());
       }
       
       public static BigDecimal getBigDecimal(EditText tf){
            return tf.getText().toString().isEmpty() ? BigDecimal.ZERO : new BigDecimal(tf.getText().toString());
       }
       
}
