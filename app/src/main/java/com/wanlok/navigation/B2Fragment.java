package com.wanlok.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class B2Fragment extends BaseFragment {
    private static final String TAG = B2Fragment.class.getName();
    private B2Presenter presenter;
    private EditText editText;
    private Button button;

    @Override
    public String getTitle() {
        return "B2";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_b2, null);

        presenter = new B2Presenter();

        editText = root.findViewById(R.id.editText);
        button = root.findViewById(R.id.button);

        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("hello", editText.getText().toString());

                B3Fragment fragment = new B3Fragment();
                fragment.setArguments(bundle);

                open(fragment, button);
            }
        });

        return root;
    }
}

