package net.bouzuya.bs.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.bouzuya.bs.R;
import net.bouzuya.bs.model.presenter.BsPresenterFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    BsPresenterFactory bsPresenterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BsApplication) getApplication()).getComponent().inject(this);
    }
}
