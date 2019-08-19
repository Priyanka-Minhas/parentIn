package com.sdei.parentIn.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class RegularTextView extends AppCompatTextView {

    public RegularTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public RegularTextView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegularTextView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface typeface = Typeface.createFromAsset(getContext()
                    .getAssets(), "Poppins_Regular.ttf");
            setTypeface(typeface);
        }
    }
}
