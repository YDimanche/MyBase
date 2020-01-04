package com.dimanche.mybase.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.dimanche.mybase.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author Dimanche
 * @description:
 * @date : 2019/12/30 23:58
 */
public abstract class BaseActivity extends SupportActivity {

    private Activity mContext;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定Unbinder
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        getLayout();
        init();
        getData();

    }

    protected void onViewCreated() {

    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        //左上角图标的左边加一个返回的图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //左上角图标是否显示，如果设置成false则没有图标只有一个标题
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }

    /**
     * 加载布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化工作
     */
    protected abstract void init();

    /**
     * 加载数据
     */
    protected abstract void getData();



}

