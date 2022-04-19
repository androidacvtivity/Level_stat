package com.bancusoft.levelstat.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseModelCl_cocm {

    @SerializedName("resultcu")
    List<Cl_cocm> cl_cocm;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Cl_cocm> getResultCl_cocm () {return  cl_cocm;}

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}

}
