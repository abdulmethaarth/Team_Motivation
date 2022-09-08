package com.affinity.teammotivation;

import com.affinity.teammotivation.models.BaseResponse;
import com.affinity.teammotivation.models.HomeList;
import com.affinity.teammotivation.models.QuestionList;
import com.affinity.teammotivation.models.SliderList;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("ac-logincrt.php")
    Call<BaseResponse> createProfile(@Field("email") String email,
                                       @Field("password") String password,
                                       @Field("username") String username,
                                       @Field("phone") String phone,
                                       @Field("university") String university,
                                       @Field("type") String type,
                                       @Field("batchname") String batchname
    );

    @POST("ac-login.php")
    @FormUrlEncoded
    Call<BaseResponse> getUser(@Field("email") String email,
                               @Field("password") String password);

    @GET("question-list.php")
    Call<QuestionList> getQuestions(@Header("user_id") String user_id);

    @GET("sliderimg.php")
    Call<SliderList> getSliderList();


    @GET("home.php")
    Call<HomeList> getHomeList(@Header("email") String user_id);

}
