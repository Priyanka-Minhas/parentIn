package com.sdei.parentIn.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class HeavyTextView  extends AppCompatTextView {

    public HeavyTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public HeavyTextView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeavyTextView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface typeface = Typeface.createFromAsset(getContext()
                    .getAssets(), "Avenir_Heavy.ttf");
            setTypeface(typeface);
        }
    }
}