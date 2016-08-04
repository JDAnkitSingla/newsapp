package com.aks.news;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aks.news.object.NewsObject;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by admin on 8/4/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<NewsObject> objectList;

    public NewsAdapter(List<NewsObject> objectList) {
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
        final NewsObject news = objectList.get(position);
        Glide.with(holder.imageView.getContext()).load(news.getImageUrl()).into(holder.imageView);
        holder.title.setText(news.getTitle());
        holder.date.setText(news.getDate());
        holder.description.setText(news.getDesc());
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
