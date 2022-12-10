package com.wanlok.navigation;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getName();
    public abstract String getTitle();
}
