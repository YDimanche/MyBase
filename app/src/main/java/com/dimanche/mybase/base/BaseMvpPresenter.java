package com.dimanche.mybase.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/2 23:08
 */
public class BaseMvpPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    //使用CompositeDisposable管理订阅的生命周期
    protected CompositeDisposable mCompositeDisposable;

    /**
     * 注销订阅
     */
    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    /**
     * 1、在UI层创建的时候，实例化CompositeDisposable
     * 2、把subscribe订阅返回的Disposabled对象加入管理器
     * 3、在UI销毁时，清空订阅对象
     *
     * @param disposable
     */
    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;

    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
