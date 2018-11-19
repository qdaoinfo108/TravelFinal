package com.traveltotal.ltmobile.travelfinal;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class detail_location extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private TextView twCity,twAdress,twRate,twContent;
    private ImageView imageView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);

        setToolbar();
        setView();
    }

    private void setView(){
        twAdress = findViewById(R.id.dlAdress);
        twCity = findViewById(R.id.dlCity);
        twContent = findViewById(R.id.dlContent);
        imageView = findViewById(R.id.dlImage);
        twRate = findViewById(R.id.dlrate);

        collapsingToolbarLayout = findViewById(R.id.collapsing);
        String title = getIntent().getStringExtra("TITLE");
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorBlack)); //Color of your title


        String adress = getIntent().getStringExtra("ADRESS");
        String city = getIntent().getStringExtra("CITY");
        String content = getIntent().getStringExtra("CONTENT");
        String image = getIntent().getStringExtra("HINHANH");
        double rate = getIntent().getIntExtra("DANHGIA",0);

        twAdress.setText(adress);
        twCity.setText(city);
        twContent.setText(content);
        twRate.setText(rate/2+"");
        Picasso.with(context).load(image).into(imageView);

    }
    private void setToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
