package com.aks.news.network;

import com.aks.news.object.NewsArticleResponse;
import com.aks.news.object.NewsSourceResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 8/5/2016.
 */

public class NewsApi {

    private static final String API_KEY = "06beb04826ac4bef85baa6375ae5d8b5";
    private static final String BASE_URL = "https://newsapi.org/v1/";

    private static NewsApiInterface newsApi;

    /**
     *
     * @return
     */
    public static NewsApiInterface getNewsApi() {
        if(newsApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsApi = retrofit.create(NewsApiInterface.class);
        }
        return newsApi;
    }


    /**
     *
     */
    public interface NewsApiInterface {

        @GET("sources")
        Call<NewsSourceResponse> getSources();

        @GET("articles?apiKey=" + API_KEY)
        Call<NewsArticleResponse> getArticles(@Query("source") String source, @Query("sortBy") String sortBy);
    }
}
