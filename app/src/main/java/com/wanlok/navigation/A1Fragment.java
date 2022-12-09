package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class A1Fragment extends BaseFragment {
    private static final String TAG = A1Fragment.class.getName();
    private A1Presenter presenter;
    private TextView textView;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_a1, null);
        presenter = new A1Presenter(getArguments());
        textView = root.findViewById(R.id.textView);
        button = root.findViewById(R.id.button);
        textView.setText(presenter.getName());
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("dummy", "ABCD");
                Fragment fragment = new A2Fragment();
                fragment.setArguments(bundle);
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.open(fragment, button);
            }
        });
        return root;
    }
}
