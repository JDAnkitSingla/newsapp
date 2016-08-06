package com.aks.news.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aks.news.DetailActivity;
import com.aks.news.R;
import com.aks.news.object.Article;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by admin on 8/4/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<Article> objectList;

    public NewsAdapter(List<Article> objectList) {
        this.objectList = objectList;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, final int position) {
        if(objectList == null)
            return;
        final Article news = objectList.get(position);
        Glide.with(holder.imageView.getContext()).load(news.getUrlToImage()).into(holder.imageView);
        holder.title.setText(news.getTitle());
        holder.date.setText(news.getPublishedAt());
        holder.description.setText(news.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Position : " + position, Toast.LENGTH_SHORT).show();
                DetailActivity.start(view.getContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectList != null ? objectList.size() : 0;
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView imageView;
        public TextView title;
        public TextView date;
        public TextView description;

        public NewsHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.item_news_card);
            imageView = (ImageView) itemView.findViewById(R.id.item_news_image);
            title = (TextView) itemView.findViewById(R.id.item_news_title);
            date = (TextView) itemView.findViewById(R.id.item_news_time);
            description = (TextView) itemView.findViewById(R.id.item_news_description);
        }
    }
}
