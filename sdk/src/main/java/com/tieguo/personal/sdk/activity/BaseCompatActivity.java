package com.tieguo.personal.sdk.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tieguo.personal.sdk.utils.StatusBarUtil;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by wj on 2018/8/14 0014.
 */

public abstract class BaseCompatActivity extends SupportActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(this);
        initData();
        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected void initData(){

    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);



}
