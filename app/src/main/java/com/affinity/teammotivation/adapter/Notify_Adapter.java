package com.affinity.teammotivation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.teammotivation.R;

public class Notify_Adapter extends RecyclerView.Adapter<Notify_Adapter.CustomViewHolder> {
    Context context;

    private final int[] images;
    private final String[] catname;


    public Notify_Adapter(Context context, int[] images, String[] catname) {

        this.context = context;
        this.images = images;
        this.catname = catname;

    }

    @Override
    public Notify_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new Notify_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(Notify_Adapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.name.setText(catname[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(context, CategoryActivity.class);
                context.startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public LinearLayout header;
        TextView name;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.image);
            header = (LinearLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);

        }
    }
}