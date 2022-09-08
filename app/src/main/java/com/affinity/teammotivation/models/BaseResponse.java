package com.affinity.teammotivation.models;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("id")
    public String id;

    @SerializedName("status")
    public String status;

    @SerializedName("name")
    public String name;

    @SerializedName("uniqueID")
    public String uniqueID;

     @SerializedName("title")
    public String title;

     @SerializedName("time")
    public String time;

     @SerializedName("totalQuestion")
    public String totalQuestion;

     @SerializedName("lastQuestion")
    public String lastQuestion;

     @SerializedName("testID")
    public String testID;

     @SerializedName("instruction")
    public String instruction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(String totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public String getLastQuestion() {
        return lastQuestion;
    }

    public void setLastQuestion(String lastQuestion) {
        this.lastQuestion = lastQuestion;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
