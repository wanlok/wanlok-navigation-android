package com.wanlok.navigation;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class A1Presenter {
    private String name;
    private Double dummy;

    public A1Presenter(Bundle bundle) {
        name = bundle.getString("name");
        dummy = bundle.getDouble("dummy");
    }

    public String getName() {
        return name;
    }

    public Double getDummy() {
        return dummy;
    }
}
