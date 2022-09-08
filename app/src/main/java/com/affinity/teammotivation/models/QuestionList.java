package com.affinity.teammotivation.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuestionList extends BaseResponse{

    @SerializedName("quiz")
    @Expose
    private ArrayList<QuestionListDtls> questionListDtls;

    public ArrayList<QuestionListDtls> getQuestionListDtls() {
        return questionListDtls;
    }

    public void setQuestionListDtls(ArrayList<QuestionListDtls> questionListDtls) {
        this.questionListDtls = questionListDtls;
    }
}
