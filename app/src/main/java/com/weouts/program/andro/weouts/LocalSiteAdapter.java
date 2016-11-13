package com.weouts.program.andro.weouts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by mochadwi on 11/11/16.
 */

public class LocalSiteAdapter extends RecyclerView.Adapter<LocalSiteAdapter.LocalSitesViewHolder> {

    private Context mContext;
    private List<LocalSite> localSiteList;

    public class LocalSitesViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public ImageView thumbnail;

        public LocalSitesViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_title);
            description = (TextView) view.findViewById(R.id.txt_desc);
            thumbnail = (ImageView) view.findViewById(R.id.img_location);
        }
    }

    public LocalSiteAdapter(Context mContext, List<LocalSite> localSiteList) {
        this.mContext = mContext;
        this.localSiteList = localSiteList;
    }

    @Override
    public LocalSitesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.localsite_card, parent, false);

        return new LocalSitesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LocalSitesViewHolder holder, int position) {
        LocalSite localSite = localSiteList.get(position);
        holder.title.setText(localSite.getTitle());
        holder.description.setText(localSite.getDescription());

        // Load Images
        Glide.with(mContext).load(localSite.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return localSiteList.size();
    }
}
