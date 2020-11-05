package com.bancusoft.levelstat.Retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Our json response will be mapped to this class.
 */
public class ResponseModel {
    /**
     * Our ResponseModel attributes
     */
    @SerializedName("result")
    List<Scientist> scientists;

    /**
     * Our ResponseModel attributes
     * index_view.php
     */

//    @SerializedName("resultvw")
//    List<Scientistvw> scientistsvw;


    @SerializedName("code")
    private String code;



//    @SerializedName("codevw")
//    private String codevw;



    @SerializedName("message")
    private String message;

//    @SerializedName("messagevw")
//    private String messagevw;


    /**
     * Generate Getter and Setters
     */
    public List<Scientist> getResult() {
        return scientists;
    }


    public void setResult(List<Scientist> scientists) {
        this.scientists = scientists;
    }



//    public List<Scientistvw> getResultvw() {return  scientistsvw;}
//
//    public void setsetResultvw (List<Scientistvw> scientistsvw) {
//
//        this.scientistsvw = scientistsvw;
//    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



//    public String getCodevw () {return  codevw;}
//
//    public void setCodevw( String codevw) {this.codevw = codevw;}
//
//
//    public String getMessagevw() {return messagevw;}
//
//    public void setMessagevw(String messagevw) {this.messagevw = messagevw;}




    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
//end
