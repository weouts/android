package com.weouts.program.andro.weouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mochadwi on 11/3/16.
 */

public class DashboardActivity extends Fragment {
    private List<LocalSite> localSiteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LocalSiteAdapter localSiteAdapter;
    private CoordinatorLayout coordinatorLayout;
    private FragmentActivity fragmentActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentActivity = super.getActivity();
        coordinatorLayout = (CoordinatorLayout) inflater.inflate(R.layout.activity_dashboard, container,
                false);

        recyclerView = (RecyclerView) coordinatorLayout.findViewById(R.id.recv_dashboard);

        localSiteAdapter = new LocalSiteAdapter(fragmentActivity, localSiteList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(fragmentActivity.getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(fragmentActivity.getApplicationContext(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LocalSite localSite = localSiteList.get(position);
                Toast.makeText(fragmentActivity.getApplicationContext(),
                        localSite.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setAdapter(localSiteAdapter);

        prepareLocalSiteData();

        try {
            Glide.with(this).load(R.drawable.kawah_putih)
                    .into((ImageView) coordinatorLayout.findViewById(R.id.img_location));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return coordinatorLayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        localSiteAdapter = new LocalSiteAdapter(this, localSiteList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                LocalSite localSite = localSiteList.get(position);
//                Toast.makeText(getApplicationContext(), localSite.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
//        recyclerView.setAdapter(localSiteAdapter);
//
//        prepareLocalSiteData();
//
//        try {
//            Glide.with(this).load(R.drawable.kawah_putih)
//                    .into((ImageView) findViewById(R.id.img_location));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void prepareLocalSiteData() {
        int[] thumbnail = new int[]{
                R.drawable.gedung_sate,
                R.drawable.kawah_putih,
                R.drawable.ranca_upas,
                R.drawable.situ_patenggang,
                R.drawable.taman_pasupati
        };

        LocalSite localSite = new LocalSite("Gedung Sate", "Ini adalah Deskripsi Gedung Sate",
                thumbnail[0], "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Kawah Putih", "Ini adalah Deskripsi Kawah Putih",
                thumbnail[1], "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Ranca Upas", "Ini adalah Deskripsi Ranca Upas",
                thumbnail[2], "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Situ Patenggang", "Ini adalah Deskripsi Situ Patenggang",
                thumbnail[3], "");
        localSiteList.add(localSite);

        localSite = new LocalSite("Taman Pasupati", "Ini adalah Deskripsi Taman Pasupati",
                thumbnail[4], "");
        localSiteList.add(localSite);

        localSiteAdapter.notifyDataSetChanged();
    }
}
