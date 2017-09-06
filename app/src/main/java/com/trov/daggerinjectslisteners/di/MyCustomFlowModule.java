package com.trov.daggerinjectslisteners.di;

import com.trov.daggerinjectslisteners.MainActivity;
import com.trov.daggerinjectslisteners.MainFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class MyCustomFlowModule {

    private MainActivity activity;

    public MyCustomFlowModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @MyCustomFlowScope
    MainFragment.Listener provideMainFragmentListener() {
        return activity;
    }

}
