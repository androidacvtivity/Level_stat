package com.bancusoft.levelstat.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModelvw {


    @SerializedName("resultvw")
    List<Scientistvw> scientistsvw;

    @SerializedName("codevw")
    private final String codevw;

    @SerializedName("messagevw")
    private final String messagevw;

    public ResponseModelvw(String codevw, String messagevw) {
        this.codevw = codevw;
        this.messagevw = messagevw;
    }


    public List<Scientistvw> getResultvw() {return  scientistsvw;}

    public String getCodevw () {return  codevw;}


    public String getMessagevw() {return messagevw;}


}
