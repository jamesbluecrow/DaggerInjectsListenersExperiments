package com.trov.daggerinjectslisteners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseApplication.get().createMyCustomFlowComponent(this);
        //BaseApplication.get().getUserComponent().plus(new ScreenModule(this)); //TODO(david) Inject dependencies

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, MainFragment.newInstance())
                .commit();
    }

    @Override
    protected void onDestroy() {
        BaseApplication.get().releaseMyCustomFlowComponent();
        super.onDestroy();
    }

    @Override
    public void clicked() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
