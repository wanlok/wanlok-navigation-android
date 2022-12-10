package com.wanlok.navigation;

import android.view.View;

import androidx.fragment.app.Fragment;

public abstract class NavigationFragment extends Fragment {
    private static final String TAG = NavigationFragment.class.getName();

    public void open(NavigationFragment fragment, View view) {
        NavigationActivity baseActivity = (NavigationActivity) getActivity();
        baseActivity.open(fragment, view);
    }

    public abstract String getTitle();
}
