package com.tieguo.personal.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.tieguo.personal.R;
import com.tieguo.personal.sdk.fragment.BaseCompatFragment;

/**
 * Created by wj on 2018/8/14 0014.
 */

public class NoteFragment extends BaseCompatFragment {

    public static NoteFragment newInstance() {
        Bundle args = new Bundle();
        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note;
    }

    @Override
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
