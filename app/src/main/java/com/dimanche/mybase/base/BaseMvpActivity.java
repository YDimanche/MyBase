package com.dimanche.mybase.base;

import android.view.ViewGroup;

import com.dimanche.mybase.app.App;
import com.dimanche.mybase.di.component.ActivityComponent;
import com.dimanche.mybase.di.component.DaggerActivityComponent;
import com.dimanche.mybase.di.module.ActivityModule;
import com.dimanche.mybase.utils.SnackbarUtils;

import javax.inject.Inject;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/1 20:52
 */
public abstract class BaseMvpActivity<T extends BaseMvpPresenter> extends BaseActivity implements BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();

    }

    protected abstract void initInject();


    @Override
    public void showError( String msg) {
        SnackbarUtils.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

}
