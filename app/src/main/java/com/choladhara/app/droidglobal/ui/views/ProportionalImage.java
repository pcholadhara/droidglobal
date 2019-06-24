package com.choladhara.app.droidglobal.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by Pranjal on 11/5/15.
 */
public class ProportionalImage extends android.support.v7.widget.AppCompatImageView {

    public ProportionalImage(Context context) {
        super(context);
    }

    public ProportionalImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProportionalImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getDrawable();
        if (d != null) {
            int w = MeasureSpec.getSize(widthMeasureSpec);
            int h = w * d.getIntrinsicHeight() / d.getIntrinsicWidth();
            setMeasuredDimension(w, h);
        }
        else super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}