package com.sdei.parentIn;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.multidex.MultiDexApplication;
import com.sdei.parentIn.utils.LocaleHelper;

import static com.sdei.parentIn.utils.ConstantsKt.LOCALE_KEY;

public class AppApplication extends MultiDexApplication {

    public static final String TAG = AppApplication.class.getSimpleName();

    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
      //  Fabric.with(this, new Crashlytics());
        instance = this;

    }

    public static boolean hasNetwork() {
        return instance.checkIfHasNetwork();
    }

    public boolean checkIfHasNetwork() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.setLocale(base,LOCALE_KEY));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleHelper.setLocale(this);
    }
}
