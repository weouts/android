package com.weouts.program.andro.weouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mochadwi on 11/3/16.
 */

public class DashboardActivity extends AppCompatActivity {
    private List<LocalSite> localSiteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LocalSiteAdapter localSiteAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recv_dashboard);

        localSiteAdapter = new LocalSiteAdapter(localSiteList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LocalSite localSite = localSiteList.get(position);
                Toast.makeText(getApplicationContext(), localSite.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setAdapter(localSiteAdapter);

        prepareLocalSiteData();
    }

    private void prepareLocalSiteData() {
        LocalSite localSite = new LocalSite("Gedung Sate", "Ini adalah Deskripsi Gedung Sate", "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Gede Bage", "Ini adalah Deskripsi Gede Bage", "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Lembang", "Ini adalah Deskripsi Lembang", "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Tebing Keraton", "Ini adalah Deskripsi Tebing Keraton", "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Monumen Perjuangan", "Ini adalah Deskripsi Monumen Perjuangan", "");
        localSiteList.add(localSite);

        localSiteAdapter.notifyDataSetChanged();
    }
}
