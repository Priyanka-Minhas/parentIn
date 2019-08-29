package com.sdei.parentIn.customViews;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatRadioButton;

import com.sdei.parentIn.R;


public class CustomRadioButton extends AppCompatRadioButton {


    public CustomRadioButton(Context context) {
        super(context);
        init(null);
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        if (attrs != null) {
            Typeface typeface = Typeface.createFromAsset(getContext()
                    .getAssets(), "Poppins_Regular.ttf");
            setTypeface(typeface);
        }

    }
}
