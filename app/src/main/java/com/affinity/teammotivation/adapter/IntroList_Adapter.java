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

import de.hdodenhof.circleimageview.CircleImageView;

public class IntroList_Adapter extends RecyclerView.Adapter<IntroList_Adapter.CustomViewHolder> {
    Context context;

    private final int[] sub_img;
    private final String[] sno;
    private final String[] testQues;
    private final String[] test_name;



    public IntroList_Adapter(Context context,  String[] sno,  String[] testQues,  String[] test_name,int[] sub_img) {

        this.context = context;
        this.sub_img = sub_img;
        this.sno = sno;
        this.test_name = test_name;
        this.testQues = testQues;

    }

    @Override
    public IntroList_Adapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.intro_list_row, parent, false);

        return new IntroList_Adapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(IntroList_Adapter.CustomViewHolder holder, int position) {
        holder.sno.setText(sno[position]);
        holder.testQues.setText(testQues[position]);
        holder.sub_img.setImageResource(sub_img[position]);
        holder.test_name.setText(test_name[position]);
        holder.btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(context, TestActivity.class);
                context.startActivity(intent);
            }
        });
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

        /*holder.btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return testQues.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout header;
        TextView sname, sno,btn_continue,testQues,test_name;
        RelativeLayout sub_list;
      //  ImageView btn_video;
        CircleImageView sub_img;


        public CustomViewHolder(View itView) {
            super(itView);
            header = (RelativeLayout) itView.findViewById(R.id.header);
            sname = (TextView) itView.findViewById(R.id.name);
            sno = (TextView) itView.findViewById(R.id.sno);
            sub_img = (CircleImageView) itView.findViewById(R.id.sub);
            testQues = (TextView) itView.findViewById(R.id.total_ques);
            test_name = (TextView) itView.findViewById(R.id.test_name);
            btn_continue = (TextView) itView.findViewById(R.id.btn_continue);
           // btn_video = (ImageView) itView.findViewById(R.id.btn_video);
            sub_list = (RelativeLayout) itView.findViewById(R.id.sub_list);
        }
    }
}