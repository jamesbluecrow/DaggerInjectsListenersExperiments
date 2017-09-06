package com.trov.daggerinjectslisteners;

import android.app.Application;
import com.trov.daggerinjectslisteners.di.AppComponent;
import com.trov.daggerinjectslisteners.di.AppModule;
import com.trov.daggerinjectslisteners.di.DaggerAppComponent;
import com.trov.daggerinjectslisteners.di.MyCustomFlowComponent;
import com.trov.daggerinjectslisteners.di.MyCustomFlowModule;

public class BaseApplication extends Application {
    private static BaseApplication instance;

    private AppComponent appComponent;
    private MyCustomFlowComponent myCustomFlowComponent;

    public static BaseApplication get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public MyCustomFlowComponent createMyCustomFlowComponent(MainActivity activity) {
        myCustomFlowComponent = appComponent.plus(new MyCustomFlowModule(activity));
        return myCustomFlowComponent;
    }

    public void releaseMyCustomFlowComponent() {
        myCustomFlowComponent = null;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public MyCustomFlowComponent getUserComponent() {
        return myCustomFlowComponent;
    }
}
