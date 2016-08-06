package com.aks.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aks.news.adapter.NewsAdapter;
import com.aks.news.adapter.SourceAdapter;
import com.aks.news.network.NewsApi;
import com.aks.news.object.Article;
import com.aks.news.object.NewsArticleResponse;
import com.aks.news.object.NewsSourceResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView articleView;
    RecyclerView sourceView;
    ProgressBar progressBar;
    MainActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articleView = (RecyclerView) findViewById(R.id.activity_main_newsitems);
        sourceView = (RecyclerView) findViewById(R.id.activity_main_sourceview);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);
        activity = this;
        LinearLayoutManager articleLayoutmManager = new LinearLayoutManager(this);
        articleLayoutmManager.setOrientation(LinearLayoutManager.VERTICAL);

        LinearLayoutManager sourceLayoutmManager = new LinearLayoutManager(this);
        sourceLayoutmManager.setOrientation(LinearLayoutManager.VERTICAL);
        articleView.setLayoutManager(articleLayoutmManager);
        sourceView.setLayoutManager(sourceLayoutmManager);


        getSources();

        getArticles("techcrunch");

    }


    /**
     *
     * @param source
     */
    public  void getArticles(String source) {
        NewsApi.getNewsApi().getArticles(source, "top").enqueue(new Callback<NewsArticleResponse>() {
            @Override
            public void onResponse(Call<NewsArticleResponse> call, Response<NewsArticleResponse> response) {
                NewsArticleResponse resp = response.body();
                Article.articleList = resp.getArticles();
                articleView.setAdapter(new NewsAdapter(Article.articleList));
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<NewsArticleResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    /**
     *
     */
    private void getSources() {
        progressBar.setVisibility(View.VISIBLE);
        NewsApi.getNewsApi().getSources().enqueue(new Callback<NewsSourceResponse>() {
            @Override
            public void onResponse(Call<NewsSourceResponse> call, Response<NewsSourceResponse> response) {

                NewsSourceResponse resp = response.body();
                sourceView.setAdapter(new SourceAdapter(resp.getSources(), activity));
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<NewsSourceResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }


}
