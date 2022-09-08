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

public class VideList_Adapter extends RecyclerView.Adapter<VideList_Adapter.CustomViewHolder> {
    Context context;


    private final String[] sno;
    private final String[] testQues;
    private final String[] test_name;



    public VideList_Adapter(Context context,  String[] sno,  String[] testQues,  String[] test_name) {

        this.context = context;
        this.sno = sno;
        this.test_name = test_name;
        this.testQues = testQues;

    }

    @Override
    public VideList_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_list_row, parent, false);

        return new VideList_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(VideList_Adapter.CustomViewHolder holder, int position) {
        holder.sno.setText(sno[position]);
      //  holder.testQues.setText(testQues[position]);
        holder.test_name.setText(test_name[position]);
       /* holder.btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestActivity.class);
                context.startActivity(intent);
            }
        });*/
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( holder.sub_list.getVisibility() == View.GONE){
                    holder.sub_list.setVisibility(View.VISIBLE);
                }else {
                    holder.sub_list.setVisibility(View.GONE);
                }

            }
        });

        holder.btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoDtlsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sno.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout header;
        TextView sname, sno,testQues,test_name;
        RelativeLayout sub_list;
        ImageView btn_video;


        public CustomViewHolder(View itView) {
            super(itView);
            header = (RelativeLayout) itView.findViewById(R.id.header);
            sname = (TextView) itView.findViewById(R.id.name);
            sno = (TextView) itView.findViewById(R.id.sno);
          //  testQues = (TextView) itView.findViewById(R.id.total_ques);
            test_name = (TextView) itView.findViewById(R.id.test_name);
           // btn_continue = (TextView) itView.findViewById(R.id.btn_continue);
            btn_video = (ImageView) itView.findViewById(R.id.btn_video);
            sub_list = (RelativeLayout) itView.findViewById(R.id.sub_list);
        }
    }
}
