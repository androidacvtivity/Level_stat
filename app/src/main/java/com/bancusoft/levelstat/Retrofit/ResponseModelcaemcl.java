package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseModelcaemcl {

    @SerializedName("resultcu")
    List<Cl_caem> cl_caem;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Cl_caem> getResultcaemcl () {return  cl_caem;}

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}
}
