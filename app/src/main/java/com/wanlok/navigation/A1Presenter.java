package com.wanlok.navigation;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class A1Presenter {
    private String name;

    public A1Presenter(Bundle bundle) {
        name = bundle.getString("name");
    }

    public String getName() {
        return name;
    }
}
