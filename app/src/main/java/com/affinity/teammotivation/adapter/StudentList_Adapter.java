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
import com.affinity.teammotivation.activity.InsightActivity;

public class StudentList_Adapter extends RecyclerView.Adapter<StudentList_Adapter.CustomViewHolder> {
    Context context;

    private final int[] images;
    private final String[] catname;
    private final String[] sno;
    private final String[] percentage;


    public StudentList_Adapter(Context context, int[] images, String[] catname,String[] sno,String[] percentage) {

        this.context = context;
        this.images = images;
        this.catname = catname;
        this.sno = sno;
        this.percentage = percentage;

    }

    @Override
    public StudentList_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stdnt_list_row, parent, false);

        return new StudentList_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(StudentList_Adapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.name.setText(catname[position]);
        holder.sno.setText(sno[position]);
        holder.percentage.setText(percentage[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InsightActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public RelativeLayout header;
        TextView name,sno,percentage;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.image);
            header = (RelativeLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);
            sno = (TextView) itView.findViewById(R.id.sno);
            percentage = (TextView) itView.findViewById(R.id.percentage);

        }
    }
}