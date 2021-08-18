
package com.peasx.app.droidglobal.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Decimals {
    public static String get2(double value){
           return df2.format(value);
    }

    public static String get2(BigDecimal value){
           return  String.valueOf(value.setScale(2, RoundingMode.HALF_EVEN));
    }
    
    public static String get3(double value){
           return df3.format(value);
    }
    
    public static String get3(BigDecimal value){
           return  String.valueOf(value.setScale(3, RoundingMode.HALF_EVEN));
    }
    
    public static String get5(double value){
           return df5.format(value);
    }
        
    public static String get5(BigDecimal value){
           return String.valueOf(value.setScale(5, RoundingMode.HALF_EVEN));
    }
    
    public static String get6(double value){
           return df6.format(value);
    }
        
    public static String get6(BigDecimal value){
           return String.valueOf(value.setScale(6, RoundingMode.HALF_EVEN));
    }
    
    private static DecimalFormat df2 = new DecimalFormat("0.00");
    private static DecimalFormat df3 = new DecimalFormat("0.000");
    private static DecimalFormat df5 = new DecimalFormat("0.00000");
    private static DecimalFormat df6 = new DecimalFormat("0.000000");
}
