package net.bouzuya.bs.android;

import net.bouzuya.bs.android.activity.MainActivity;

import dagger.Component;

@Component(modules = {BsApplicationModule.class})
public interface BsApplicationComponent {
    void inject(MainActivity activity);
}
