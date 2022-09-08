package com.affinity.teammotivation.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeList extends BaseResponse{

    @SerializedName("data")
    @Expose
    private ArrayList<HomelistDtls> homelistDtls;

    public ArrayList<HomelistDtls> getHomelistDtls() {
        return homelistDtls;
    }

    public void setHomelistDtls(ArrayList<HomelistDtls> homelistDtls) {
        this.homelistDtls = homelistDtls;
    }
}
