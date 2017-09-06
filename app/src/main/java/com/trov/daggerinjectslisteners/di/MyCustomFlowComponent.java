package com.trov.daggerinjectslisteners.di;

import dagger.Subcomponent;

@MyCustomFlowScope
@Subcomponent(modules = {
        MyCustomFlowModule.class
})
public interface MyCustomFlowComponent {
    ScreenComponent plus(ScreenModule module);
}
