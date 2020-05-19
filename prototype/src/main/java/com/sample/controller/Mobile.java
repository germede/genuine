package com.sample.controller;

import android.webkit.WebView;
import org.fluentness.controller.AbstractMobile;
import org.fluentness.controller.MobileTemplate;

public class Mobile extends AbstractMobile {

    WebView webView;

    @Override
    public MobileTemplate getTemplate() {
        return activity(
            webView = webView()
        );
    }
}