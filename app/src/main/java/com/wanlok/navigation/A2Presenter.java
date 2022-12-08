package com.wanlok.navigation;

import android.os.Bundle;

public class A2Presenter {
    private String dummy;

    public A2Presenter(Bundle bundle) {
        dummy = bundle.getString("dummy");
    }

    public String getDummy() {
        return dummy;
    }
}
