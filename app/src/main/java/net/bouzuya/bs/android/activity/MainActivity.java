package net.bouzuya.bs.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.bouzuya.bs.R;
import net.bouzuya.bs.android.BsApplication;
import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.presenter.BsPresenter;
import net.bouzuya.bs.model.presenter.BsPresenterFactory;
import net.bouzuya.bs.model.view.BsView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements BsView {
    @Inject
    BsPresenterFactory bsPresenterFactory;
    private BsPresenter bsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BsApplication) getApplication()).getComponent().inject(this);
        bsPresenter = bsPresenterFactory.create(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bsPresenter = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        bsPresenter.start();
    }

    @Override
    public void showBsList(BsList bsList) {
        // TODO
    }

    @Override
    public void showLoadException(Throwable throwable) {
        // TODO
    }
}
