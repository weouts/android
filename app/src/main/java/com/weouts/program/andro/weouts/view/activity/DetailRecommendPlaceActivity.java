package com.weouts.program.andro.weouts.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weouts.program.andro.weouts.R;

public class DetailRecommendPlaceActivity extends AppCompatActivity {
    private TextView txtTitle, txtLocation, txtDescription;
    private ImageView thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recommend_place);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

        txtTitle.setText(getIntent().getStringExtra("judul"));
        txtLocation.setText(getIntent().getStringExtra("lokasi"));
        txtDescription.setText(getIntent().getStringExtra("deskripsi"));
        try {
            Glide.with(this).load(getIntent().getStringExtra("foto"))
                    .into(thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        txtTitle = (TextView) findViewById(R.id.txt_caption_title);
        txtLocation = (TextView) findViewById(R.id.txt_location);
        txtDescription = (TextView) findViewById(R.id.txt_description);
        thumbnail = (ImageView) findViewById(R.id.backdrop_dashboard);
    }


}
