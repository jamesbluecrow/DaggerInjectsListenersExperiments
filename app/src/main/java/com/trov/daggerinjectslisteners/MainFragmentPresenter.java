package com.trov.daggerinjectslisteners;

import javax.inject.Inject;

public class MainFragmentPresenter {
    private final MainFragment.Listener listener;

    @Inject
    public MainFragmentPresenter(MainFragment.Listener listener) {
        this.listener = listener;
    }

    public void clicked() {
        listener.clicked();
    }
}
