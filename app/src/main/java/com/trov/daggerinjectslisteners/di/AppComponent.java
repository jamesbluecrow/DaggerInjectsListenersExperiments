package com.trov.daggerinjectslisteners.di;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {
    MyCustomFlowComponent plus(MyCustomFlowModule myCustomFlowModule);
}
