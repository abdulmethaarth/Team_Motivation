package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.RetrofitClient;
import com.affinity.teammotivation.models.BaseResponse;
import com.affinity.teammotivation.models.Constants;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.gotev.uploadservice.MultipartUploadRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpMailActivity extends AppCompatActivity {

    TextView btn_continue;
    ProgressDialog progress;
    EditText batch, pass, email, university, name, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_mail);

        progress = new ProgressDialog(this);
        batch = (EditText) findViewById(R.id.batch);
        pass = (EditText) findViewById(R.id.pass);
        email = (EditText) findViewById(R.id.email);
        university = (EditText) findViewById(R.id.university);
        mobile = (EditText) findViewById(R.id.mob);
        name = (EditText) findViewById(R.id.name);
        btn_continue = (TextView) findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().isEmpty()){
                    Toast.makeText(SignUpMailActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }else if(pass.getText().toString().isEmpty()){
                    Toast.makeText(SignUpMailActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else if(name.getText().toString().isEmpty()){
                    Toast.makeText(SignUpMailActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else if(mobile.getText().toString().isEmpty()){
                    Toast.makeText(SignUpMailActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else if(university.getText().toString().isEmpty()){
                    Toast.makeText(SignUpMailActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else if(batch.getText().toString().isEmpty()){
                    Toast.makeText(SignUpMailActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else {
                    progress.setMessage("Please Wait.. :)");
                    progress.show();

                    String mail = email.getText().toString();
                    String password = pass.getText().toString();
                    String username = name.getText().toString();
                    String phone = mobile.getText().toString();
                    String univerSity = university.getText().toString();
                    String batchName = batch.getText().toString();
                    Call<BaseResponse> call = RetrofitClient.getApiService().createProfile(mail,password,username,phone,univerSity,"1",batchName);
                    call.enqueue(new Callback<BaseResponse>() {
                        @Override
                        public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                            BaseResponse users = response.body();

                            if (users.status.equalsIgnoreCase("true")) {
                                Toast.makeText(SignUpMailActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                progress.cancel();
                                Intent intent = new Intent(SignUpMailActivity.this, LoginOptionActivity.class);
                                startActivity(intent);

                            } else {
                                progress.cancel();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponse> call, Throwable t) {
                            progress.cancel();
                            Toast.makeText(SignUpMailActivity.this, "Check your internet connection...", Toast.LENGTH_SHORT).show();
                        }
                    });
                  /*
                    JsonObject gsonObject = new JsonObject();
                    try {

                        JSONObject jsonObj_ = new JSONObject();
                        jsonObj_.put("email", email.getText().toString());
                        jsonObj_.put("password", pass.getText().toString());
                        jsonObj_.put("username", name.getText().toString());
                        jsonObj_.put("phone", mobile.getText().toString());
                        jsonObj_.put("university", university.getText().toString());
                        jsonObj_.put("type", 1);
                        jsonObj_.put("batchname", batch.getText().toString());

                        JsonParser jsonParser = new JsonParser();
                        gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());
                        Log.e("MY gson.JSON:  ", "AS PARAMETER  " + gsonObject);
                        // Toast.makeText(this, "result"+gsonObject, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Call<BaseResponse> call = RetrofitClient.getApiService().regUser(gsonObject);
                    call.enqueue(new Callback<BaseResponse>() {
                        @Override
                        public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                            BaseResponse users = response.body();

                            if (users.status.equalsIgnoreCase("true")) {
                                progress.cancel();
                                Intent intent = new Intent(SignUpMailActivity.this, LoginOptionActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(SignUpMailActivity.this, "", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponse> call, Throwable t) {
                            progress.cancel();
                            Toast.makeText(SignUpMailActivity.this, "Check your internet connection...", Toast.LENGTH_SHORT).show();

                        }
                    });*/
                }
            }
        });
    }
}