package net.bouzuya.bs.android;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class BsApplication extends Application {
    private BsApplicationComponent component;

    public BsApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        component = DaggerBsApplicationComponent.builder().build();
    }
}
