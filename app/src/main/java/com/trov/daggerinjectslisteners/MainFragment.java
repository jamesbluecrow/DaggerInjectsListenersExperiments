package com.trov.daggerinjectslisteners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trov.daggerinjectslisteners.di.ScreenModule;
import javax.inject.Inject;

public class MainFragment extends Fragment {

    @Inject MainFragmentPresenter presenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseApplication.get().getUserComponent().plus(new ScreenModule(getActivity())).inject(this);

        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clicked();
            }
        });
    }

    public interface Listener {
        void clicked();
    }
}
