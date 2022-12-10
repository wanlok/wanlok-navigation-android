package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class A3Fragment extends NavigationFragment {
    private static final String TAG = A3Fragment.class.getName();
    private A3Presenter presenter;
    private TextView textView;

    @Override
    public String getTitle() {
        return "A3";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_a3, null);

        presenter = new A3Presenter();

        textView = root.findViewById(R.id.textView);

        textView.setText("A3");

        return root;
    }
}
