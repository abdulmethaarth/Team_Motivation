package com.affinity.teammotivation.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SliderList extends BaseResponse{

    @SerializedName("data")
    @Expose
    private ArrayList<SlidedlistDtls> slidedlistDtls;

    public ArrayList<SlidedlistDtls> getSlidedlistDtls() {
        return slidedlistDtls;
    }

    public void setSlidedlistDtls(ArrayList<SlidedlistDtls> slidedlistDtls) {
        this.slidedlistDtls = slidedlistDtls;
    }
}

