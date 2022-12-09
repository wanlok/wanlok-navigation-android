package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class C1Fragment extends Fragment {
    private static final String TAG = C1Fragment.class.getName();
    private C1Presenter presenter;
    private TextView textView;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_c1, null);
        presenter = new C1Presenter();
        textView = root.findViewById(R.id.textView);
        button = root.findViewById(R.id.button);
        textView.setText("C1");
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.open(new C2Fragment(), button);
            }
        });
        return root;
    }
}
