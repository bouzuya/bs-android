package net.bouzuya.bs.android;

import dagger.Component;

@Component(modules = {BsApplicationModule.class})
interface BsApplicationComponent {
    void inject(MainActivity activity);
}
