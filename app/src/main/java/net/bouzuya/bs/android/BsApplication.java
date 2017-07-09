package net.bouzuya.bs.android;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class BsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }
}
