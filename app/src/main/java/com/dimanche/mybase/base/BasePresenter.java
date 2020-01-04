package com.dimanche.mybase.base;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/2 22:06
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

}
