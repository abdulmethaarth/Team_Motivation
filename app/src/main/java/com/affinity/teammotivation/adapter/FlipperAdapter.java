package com.affinity.teammotivation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.models.SlidedlistDtls;
import com.affinity.teammotivation.models.SliderList;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FlipperAdapter extends BaseAdapter {

    private Context mCtx;
    private ArrayList<SlidedlistDtls> banners;


    public FlipperAdapter(Context mCtx, ArrayList<SlidedlistDtls> banners) {
        this.mCtx = mCtx;
        this.banners = banners;
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SlidedlistDtls banner = banners.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.flipper_items, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.get().load(banner.getName()).fit().centerCrop()
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(imageView);
        return view;
    }
}
