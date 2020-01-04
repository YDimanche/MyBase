package com.dimanche.mybase.base;

import javax.inject.Inject;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 22:10
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    @Inject
    protected T mPresenter;


}
