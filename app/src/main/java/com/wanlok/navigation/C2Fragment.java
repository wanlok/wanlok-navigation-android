package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class C2Fragment extends NavigationFragment {
    private static final String TAG = C2Fragment.class.getName();
    private C2Presenter presenter;
    private TextView textView;
    private Button button;

    @Override
    public String getTitle() {
        return "C2";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_c2, null);

        presenter = new C2Presenter();

        textView = root.findViewById(R.id.textView);
        button = root.findViewById(R.id.button);

        textView.setText("C2");

        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(new C3Fragment(), button);
            }
        });

        return root;
    }
}
