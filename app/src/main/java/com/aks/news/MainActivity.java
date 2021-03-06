package com.aks.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aks.news.object.NewsObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newsitems);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);
        progressBar.setVisibility(View.VISIBLE);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager m = new LinearLayoutManager(this);
//        m.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(m);
        recyclerView.setAdapter(new NewsAdapter(NewsObject.getNewsObjectList()));

        progressBar.setVisibility(View.GONE);
      /*  TextView title = (TextView) findViewById(R.id.activity_main_title);
        TextView time = (TextView) findViewById(R.id.activity_main_time);
        TextView desc = (TextView) findViewById(R.id.activity_main_description);

        title.setText("My Title");
        time.setText(new Date().toString());
        desc.setText("uihduishdwdnfuwfhoigjoeirnmngvioenvoiuenuierbhuigjkbguyfguyflkfjhvgyuk,vgcfecyfbeycyuwywebfbyebfgjdasgfuig");*/

    }


}
