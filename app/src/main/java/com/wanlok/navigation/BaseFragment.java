package com.wanlok.navigation;

import android.view.View;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getName();

    public void open(BaseFragment fragment, View view) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        baseActivity.open(fragment, view);
    }

    public abstract String getTitle();
}
