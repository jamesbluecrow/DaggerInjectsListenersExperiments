package com.trov.daggerinjectslisteners.di;

import android.app.Activity;
import com.trov.daggerinjectslisteners.MainFragment;
import com.trov.daggerinjectslisteners.MainFragmentPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Miroslaw Stanek on 23.06.15.
 */
@Module
public class ScreenModule {

    private Activity activity;

    public ScreenModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ScreenScope
    MainFragmentPresenter provideMainFragmentPresenter(MainFragment.Listener listener) {
        return new MainFragmentPresenter(listener);
    }
}
