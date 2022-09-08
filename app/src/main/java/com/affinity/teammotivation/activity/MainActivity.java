package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.affinity.teammotivation.adapter.FlipperAdapter;
import com.affinity.teammotivation.RetrofitClient;
import com.affinity.teammotivation.adapter.Home_CatAdapter;
import com.affinity.teammotivation.R;
import com.affinity.teammotivation.models.Constants;
import com.affinity.teammotivation.models.SlidedlistDtls;
import com.affinity.teammotivation.models.SliderList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView profile;
    int[] first_list_images = {R.drawable.user_profile, R.drawable.user_profile, R.drawable.user_profile, R.drawable.user_profile,R.drawable.user_profile};
    String [] catname = {"Dr. Asutosh Aggarwal" ,"Dr. Niha Aggarwal" ,"Dr. Dinesh Yadav" ,"Dr. Dinesh Yadav" ,"Dr. Dinesh Yadav"};
    String [] dept = {"Director and Professor","Ophthalmology","Pharmacology","Pharmacology", "Pharmacology"};
    RecyclerView first_listlView;
    Home_CatAdapter first_listlAdapter;
    String UserName;
    LinearLayout study,bank,image,series_;
    TextView userName;
    AdapterViewFlipper adapterViewFlipping;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE);
        UserName = prefs.getString(Constants.firstname, "");

        progress = new ProgressDialog(this);
        adapterViewFlipping = (AdapterViewFlipper)findViewById(R.id.banner);
        adapterViewFlipping.setVisibility(View.VISIBLE);
        getBanners();
        
        userName = (TextView) findViewById(R.id.userName);
        userName.setText(UserName);

        study = (LinearLayout) findViewById(R.id.study);
        bank = (LinearLayout)findViewById(R.id.bank);
        image = (LinearLayout)findViewById(R.id.image);
        series_ = (LinearLayout)findViewById(R.id.series_);

        profile = (ImageView)findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new Home_CatAdapter(MainActivity.this, first_list_images,catname,dept);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);

        series_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   startActivity(new Intent(MainActivity.this,VideoActivity.class));
                finish();*/
            }
        });
    }

    private void getBanners() {
        progress.setMessage("Please Wait.. :)");
        progress.show();
        Call<SliderList> call = RetrofitClient.getApiService().getSliderList();
        call.enqueue(new Callback<SliderList>() {
            @Override
            public void onResponse(Call<SliderList> call, Response<SliderList> response) {
                SliderList res =response.body();
                if(res.status.equalsIgnoreCase("true")){

                    progress.cancel();
                    ArrayList<SlidedlistDtls> banners = response.body().getSlidedlistDtls();
                    FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), banners);

                    adapterViewFlipping.setAdapter(adapter);
                    adapterViewFlipping.setFlipInterval(2000);
                    adapterViewFlipping.startFlipping();

                }
                else{
                    progress.cancel();
                    Toast.makeText(getApplicationContext(), "Slider false", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<SliderList> call, Throwable t) {
                progress.cancel();
                Toast.makeText(getApplicationContext(), t.getMessage()+"Server error, check your internet", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void nextActivity() {
      /*  startActivity(new Intent(MainActivity.this,SyllabusActivity.class));
        finish();*/
    }
}