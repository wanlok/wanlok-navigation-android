package com.wanlok.navigation;

import android.os.Bundle;

public class B3Presenter {
    private String hello;

    public B3Presenter(Bundle bundle) {
        hello = bundle.getString("hello");
    }

    public String getHello() {
        return hello;
    }
}
