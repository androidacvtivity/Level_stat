package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ResponseModelcfp {


    @SerializedName("resultcu")
    List<Scientistscfp> scientistscfp;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Scientistscfp> getResultcfp () {return  scientistscfp;}

    public void setResultcfp (List<Scientistscfp> scientistscfp) {

        this.scientistscfp = scientistscfp;
    }

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}
}
