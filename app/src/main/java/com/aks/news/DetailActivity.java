package com.aks.news;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aks.news.object.Article;
import com.aks.news.object.NewsObject;

/**
 * Created by admin on 8/4/2016.
 */

public class DetailActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;
    private static String KEY_POSITION = "position";
    private static int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        webView = (WebView) findViewById(R.id.activity_detail_webview);
        progressBar = (ProgressBar) findViewById(R.id.activity_detail_progress);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Article news = Article.getArticle(getIntent().getIntExtra(KEY_POSITION, DEFAULT_POSITION));
        loadDetails(news);
    }


    /**
     *
     * @param news
     */
    private void loadDetails(Article news) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.loadUrl(news.getUrl());
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                //Write your logic here
//                Intent intent = new Intent(this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    /**
     *
     * @param context
     * @param position
     */
    public static void start(Context context, int position) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY_POSITION, position);
        context.startActivity(intent);
    }
}
