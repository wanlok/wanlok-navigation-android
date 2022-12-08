package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class A3Fragment extends Fragment {
    private static final String TAG = A3Fragment.class.getName();
    private A3Presenter presenter;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = new A3Presenter();
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_a3, null);
        textView = root.findViewById(R.id.textView);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        textView.setText("A3");
    }
}
