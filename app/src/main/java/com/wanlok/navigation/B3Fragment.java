package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class B3Fragment extends Fragment {
    private static final String TAG = B3Fragment.class.getName();
    private B3Presenter presenter;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_b3, null);
        presenter = new B3Presenter();
        textView = root.findViewById(R.id.textView);
        textView.setText("B3");
        return root;
    }
}