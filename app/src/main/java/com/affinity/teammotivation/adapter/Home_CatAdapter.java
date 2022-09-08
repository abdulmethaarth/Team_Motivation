package com.affinity.teammotivation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.activity.SyllabusActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home_CatAdapter extends RecyclerView.Adapter<Home_CatAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;
    private final String[] catname;
    private final String[] dept;


    public Home_CatAdapter(Context context, int[] images, String[] catname, String[] dept) {

        this.context = context;
        this.images = images;
        this.catname = catname;
        this.dept = dept;

    }

    @Override
    public Home_CatAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_list_row, parent, false);

        return new Home_CatAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(Home_CatAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.name.setText(catname[position]);
        holder.dept.setText(dept[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(context, SyllabusActivity.class);
                context.startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView icon;
        public LinearLayout header;
        TextView name,dept;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (CircleImageView) itView.findViewById(R.id.image);
            header = (LinearLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);
            dept = (TextView) itView.findViewById(R.id.dept);


        }
    }
}