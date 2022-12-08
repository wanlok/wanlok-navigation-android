package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class B2Fragment extends Fragment {
    private static final String TAG = B2Fragment.class.getName();
    private B2Presenter presenter;
    private TextView textView;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = new B2Presenter();
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_b2, null);
        textView = root.findViewById(R.id.textView);
        button = root.findViewById(R.id.button);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        textView.setText("B2");
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.open(new B3Fragment(), R.id.b);
            }
        });
    }
}

