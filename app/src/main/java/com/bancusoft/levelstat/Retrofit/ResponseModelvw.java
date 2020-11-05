package com.bancusoft.levelstat.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModelvw {


    @SerializedName("resultvw")
    List<Scientistvw> scientistsvw;

    @SerializedName("codevw")
    private String codevw;

    @SerializedName("messagevw")
    private String messagevw;


    public List<Scientistvw> getResultvw() {return  scientistsvw;}

    public void  setResultvw (List<Scientistvw> scientistsvw) {

        this.scientistsvw = scientistsvw;
    }

    public String getCodevw () {return  codevw;}

    public void setCodevw( String codevw) {this.codevw = codevw;}


    public String getMessagevw() {return messagevw;}

    public void setMessagevw(String messagevw) {this.messagevw = messagevw;}


}
