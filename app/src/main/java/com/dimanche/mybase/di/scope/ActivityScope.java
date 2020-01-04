package com.dimanche.mybase.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * @author Dimanche
 * @description:局部单例，让Component和activity的生命周期一样
 * @date : 2020/1/4 14:05
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
