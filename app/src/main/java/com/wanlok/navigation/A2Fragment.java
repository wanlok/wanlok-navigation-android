package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class A2Fragment extends BaseFragment {
    private static final String TAG = A2Fragment.class.getName();
    private A2Presenter presenter;
    private TextView textView;
    private Button button;

    @Override
    public String getTitle() {
        return "A2";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_a2, null);

        presenter = new A2Presenter(getArguments());

        textView = root.findViewById(R.id.textView);
        button = root.findViewById(R.id.button);

        textView.setText(presenter.getDummy());

        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(new A3Fragment(), button);
            }
        });

        return root;
    }
}
