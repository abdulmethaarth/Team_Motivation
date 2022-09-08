package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.affinity.teammotivation.Api;
import com.affinity.teammotivation.R;
import com.affinity.teammotivation.RetrofitClient;
import com.affinity.teammotivation.models.BaseResponse;
import com.affinity.teammotivation.models.Constants;
import com.affinity.teammotivation.models.SliderList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginOptionActivity extends AppCompatActivity {

    TextView btn_continue,ggle;
    EditText edt_email,edt_pass;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_option);

        progress = new ProgressDialog(this);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_pass = (EditText) findViewById(R.id.edt_pass);
        btn_continue = (TextView)findViewById(R.id.btn_continue);
        ggle = (TextView)findViewById(R.id.ggle);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_email.getText().toString().isEmpty()){
                    Toast.makeText(LoginOptionActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }else if(edt_pass.getText().toString().isEmpty()){
                    Toast.makeText(LoginOptionActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else{
                    progress.setMessage("Please Wait.. :)");
                    progress.show();
                   /* JsonObject gsonObject = new JsonObject();
                    try {

                        JSONObject jsonObj_ = new JSONObject();
                        jsonObj_.put("email", edt_email.getText().toString());
                        jsonObj_.put("password", edt_pass.getText().toString());

                        JsonParser jsonParser = new JsonParser();
                        gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());
                        Log.e("MY gson.JSON:  ", "AS PARAMETER  " + gsonObject);
                        // Toast.makeText(this, "result"+gsonObject, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                    String email = edt_email.getText().toString();
                    String pass = edt_pass.getText().toString();
                    Call<BaseResponse> call = RetrofitClient.getApiService().getUser(email,pass);
                    call.enqueue(new Callback<BaseResponse>() {
                        @Override
                        public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                            BaseResponse users = response.body();

                            if (users.status.equalsIgnoreCase("true")) {
                                SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString(Constants.user_id, users.getId());
                                editor.putString(Constants.firstname, users.getName());
                                editor.putBoolean(Constants.KEY_OTP_LOGGED_IN,true);
                                editor.apply();
                                progress.cancel();
                                Intent intent = new Intent(LoginOptionActivity.this,MainActivity.class);
                                startActivity(intent);

                            } else {
                                progress.cancel();
                                Toast.makeText(LoginOptionActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<BaseResponse> call, Throwable t) {
                            progress.cancel();
                            Toast.makeText(LoginOptionActivity.this, "Check your internet connection...", Toast.LENGTH_SHORT).show();

                        }
                    });


                /*    Api api = RetrofitClient.getApiService();
                    Call<SliderList> call = api.getVoucherList();

                    call.enqueue(new Callback<SliderList>() {
                        @Override
                        public void onResponse(Call<SliderList> call, retrofit2.Response<SliderList> response) {
                            SliderList res = response.body();
                            if (res.status.equalsIgnoreCase("true")) {
                                Toast.makeText(LoginOptionActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(LoginOptionActivity.this, "failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<SliderList> call, Throwable t) {
                            Toast.makeText(LoginOptionActivity.this, "Server connection failed", Toast.LENGTH_SHORT).show();
                        }
                    });*/
                }
            }
        });


        ggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginOptionActivity.this,SignUpMailActivity.class));
                finish();
            }
        });
    }
}