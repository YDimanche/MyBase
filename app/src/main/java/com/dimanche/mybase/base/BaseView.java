package com.dimanche.mybase.base;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/2 21:35
 */
public interface BaseView {

    /**
     * 错误
     * @param msg 错误信息
     */
    void showError(String msg);

    /**
     * 是否正在加载
     */
    void isLoading();




}
