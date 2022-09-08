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
import com.affinity.teammotivation.activity.IntroductionActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class SyllabusList_Adapter extends RecyclerView.Adapter<SyllabusList_Adapter.CustomViewHolder> {
    Context context;
    private final int[] images;
    private final String[] catname;
    private final String[] sno;


    public SyllabusList_Adapter(Context context, String[] catname, String[] sno,int[] images) {

        this.context = context;
        this.catname = catname;
        this.sno = sno;
        this.images = images;

    }

    @Override
    public SyllabusList_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.syllabus_list_row, parent, false);

        return new SyllabusList_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(SyllabusList_Adapter.CustomViewHolder holder, int position) {
        holder.name.setText(catname[position]);
        holder.icon.setImageResource(images[position]);
        holder.sno.setText(sno[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IntroductionActivity.class);
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
        public CircleImageView icon;


        public CustomViewHolder(View itView) {
            super(itView);
            header = (RelativeLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);
            sno = (TextView) itView.findViewById(R.id.sno);
            icon = (CircleImageView) itView.findViewById(R.id.icon);

        }
    }
}