package com.peasx.app.droidglobal.textdraw;

import android.widget.ImageView;


public class TextDrawables {
       private TextDrawables(){}

       public static TextDrawables roundRect(){
           if(textDrawables == null){
               textDrawables    = new TextDrawables();
               drawableBuilder  = TextDrawable.builder().roundRect(10);
           }
           return  textDrawables;
       }

       public static TextDrawables round(){
           if(textDrawables == null){
               textDrawables    = new TextDrawables();
               drawableBuilder  = TextDrawable.builder().round();
           }
           return  textDrawables;
       }

       public void draw(ImageView imageView, String str){
               String txt = String.valueOf(str.charAt(0));
               TextDrawable drawable  = drawableBuilder.build(txt, ColorGenerator.MATERIAL.getRandomColor());
               imageView.setImageDrawable(drawable);
       }

       private static TextDrawable.IBuilder drawableBuilder;
       private static TextDrawables textDrawables;
}
