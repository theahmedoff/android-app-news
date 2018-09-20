package com.example.akmedoff.newsdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    Toolbar toolbar;

    RecyclerView rvCategpry;
    RecyclerView rvBanner;
    RecyclerView rvNews;

    private ArrayList<String> mCategory = new ArrayList<>();
    private ArrayList<Integer> mBannerImg = new ArrayList<>();
    private List<News> mData = new ArrayList<>();
    private List<News> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rvNews = (RecyclerView) findViewById(R.id.rv_news_id);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutmanager = layoutManager;
        rvNews.setLayoutManager(rvLayoutmanager);

        getCategory();
        initRecyclerViewCcategory();
        getBannerImage();
        initRecyclerViewBanner();
        getNewsList();
        initRecyclerViewNews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = " ";
        switch (item.getItemId()){
            case R.id.search_btn:
                msg = "Search";
            break;
        }
        Toast.makeText(this, msg + " Checked", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    private void getCategory(){
        mCategory.add("Latest");
        mCategory.add("Sport");
        mCategory.add("Tech");
        mCategory.add("Opinion");
        mCategory.add("Media");
        mCategory.add("Marketing");
    }

    private void initRecyclerViewCcategory(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycview_category_id);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewCategory adapter = new RecyclerViewCategory(mCategory, this);
        recyclerView.setAdapter(adapter);
    }

    private void getBannerImage(){
        mBannerImg.add(R.drawable.game);
        mBannerImg.add(R.drawable.tech);
        mBannerImg.add(R.drawable.fotos);
    }

    private void initRecyclerViewBanner(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycview_banner_id);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewBanner adapter = new RecyclerViewBanner(mBannerImg, this);
        recyclerView.setAdapter(adapter);
    }

    private void getNewsList(){

        data.add(new News(R.drawable.game, "Android Police - Android news", "Game", "2534"));
        data.add(new News(R.drawable.tech, "Tech Companies Who Own Other", "Tech", "980"));
        data.add(new News(R.drawable.fotos, "Tech Companies Who Own Other", "Tech", "234"));
        data.add(new News(R.drawable.news, "Tech Companies Who Own Other", "Tech", "675"));
        data.add(new News(R.drawable.game, "Tech Companies Who Own Other", "Tech", "854"));
    }

    private void initRecyclerViewNews(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.rv_news_id);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewNews adapter = new RecyclerViewNews(data, this);
        recyclerView.setAdapter(adapter);
    }
}




















