package com.aks.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aks.news.MainActivity;
import com.aks.news.R;
import com.aks.news.object.Source;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by admin on 8/5/2016.
 */

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.SourceViewHolder> {

    private List<Source> sourceList;
    MainActivity activity;

    public SourceAdapter(List<Source> sourceList, MainActivity activity) {
        this.sourceList = sourceList;
        this.activity = activity;
    }

    @Override
    public SourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_source, parent, false);
        return new SourceViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return sourceList != null ? sourceList.size() : 0;
    }

    @Override
    public void onBindViewHolder(SourceViewHolder holder, int position) {
        if(sourceList == null)
            return;
        final Source source = sourceList.get(position);
        Glide.with(holder.sourceImage.getContext()).load(source.getUrlsToLogos().getSmall()).into(holder.sourceImage);

        holder.sourceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getArticles(source.getId());
            }
        });
    }

    public static class SourceViewHolder extends RecyclerView.ViewHolder {

        ImageView sourceImage;

        public SourceViewHolder(View itemView) {
            super(itemView);
            sourceImage = (ImageView) itemView.findViewById(R.id.item_source_image);
        }
    }
}
