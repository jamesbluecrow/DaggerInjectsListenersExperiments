package com.trov.daggerinjectslisteners.di;

import com.trov.daggerinjectslisteners.MainFragment;
import dagger.Subcomponent;

@ScreenScope
@Subcomponent(modules = ScreenModule.class)
public interface ScreenComponent {
    void inject(MainFragment fragment);
}
