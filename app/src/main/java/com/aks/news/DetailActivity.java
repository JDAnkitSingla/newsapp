package com.aks.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by admin on 8/4/2016.
 */

public class DetailActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        webView = (WebView) findViewById(R.id.activity_detail_webview);

        String url = getIntent().getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }
}
