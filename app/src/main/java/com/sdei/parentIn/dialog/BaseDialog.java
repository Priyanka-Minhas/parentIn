package com.sdei.parentIn.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.sdei.parentIn.R;

abstract public class BaseDialog extends Dialog {
    Snackbar mSnackbar;
    private Context context;
    private int mWidth, mHeight;

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public BaseDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams wmlp = this.getWindow().getAttributes();
        setContentView(getContentView());
        context = getContext();
        getDefaults();
        onCreateStuff();
        wmlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wmlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(wmlp);
    }

    protected abstract void onCreateStuff();

    public abstract int getContentView();

    void getDefaults() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        mWidth = displayMetrics.widthPixels;
        mHeight = displayMetrics.heightPixels;
        Log.e("Height = ", mHeight + " width " + mWidth);
    }

    protected void showInternetAlert(View view) {
        mSnackbar = Snackbar.make(view, R.string.errorInternet, Snackbar.LENGTH_SHORT);
        mSnackbar.show();
    }

}
