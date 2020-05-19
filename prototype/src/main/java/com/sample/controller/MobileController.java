package com.sample.controller;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.Log;

public class MobileController extends AbstractMobileController<Mobile> {

    private final Log log;

    public MobileController(Mobile mobile, Log log) {
        super(mobile);
        this.log = log;

        mobile.webView.setWebViewClient(new MyWebViewClient());
        mobile.webView.getSettings().setLoadsImagesAutomatically(true);
        mobile.webView.getSettings().setJavaScriptEnabled(true);
        mobile.webView.loadUrl("http://localhost:8000/");
    }

    public void test(View view) {
        log.error("TEST");
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }


    }
}
