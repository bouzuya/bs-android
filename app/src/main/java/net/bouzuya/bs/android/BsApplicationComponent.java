package net.bouzuya.bs.android;

import net.bouzuya.bs.android.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BsApplicationModule.class})
public interface BsApplicationComponent {
    void inject(MainActivity activity);
}
