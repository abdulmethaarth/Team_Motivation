package com.affinity.teammotivation.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomelistDtls {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("isStatus")
    @Expose
    private String isStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus;
    }
}
