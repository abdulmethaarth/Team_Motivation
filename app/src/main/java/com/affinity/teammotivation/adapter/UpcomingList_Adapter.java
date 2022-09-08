package com.affinity.teammotivation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.activity.TestActivity;

public class UpcomingList_Adapter extends RecyclerView.Adapter<UpcomingList_Adapter.CustomViewHolder> {
    Context context;

    private final String[] time;


    public UpcomingList_Adapter(Context context, String[] time) {

        this.context = context;
        this.time = time;


    }

    @Override
    public UpcomingList_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_list_row, parent, false);

        return new UpcomingList_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(UpcomingList_Adapter.CustomViewHolder holder, int position) {
        holder.time.setText(time[position]);

        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return time.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout header;
        TextView time;


        public CustomViewHolder(View itView) {
            super(itView);
            header = (RelativeLayout) itView.findViewById(R.id.header);
            time = (TextView) itView.findViewById(R.id.time);


        }
    }
}
