package com.affinity.teammotivation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.activity.VideoDtlsActivity;

public class RelatedVideoList_Adapter extends RecyclerView.Adapter<RelatedVideoList_Adapter.CustomViewHolder> {
    Context context;
    private final String[] catname;


    public RelatedVideoList_Adapter(Context context, String[] catname) {

        this.context = context;
        this.catname = catname;

    }

    @Override
    public RelatedVideoList_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.relatedvideo_list_row, parent, false);

        return new RelatedVideoList_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(RelatedVideoList_Adapter.CustomViewHolder holder, int position) {
        holder.name.setText(catname[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoDtlsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return catname.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout header;
        TextView name, sno, percentage;
        public ImageView icon;


        public CustomViewHolder(View itView) {
            super(itView);
            header = (RelativeLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);

        }
    }
}
