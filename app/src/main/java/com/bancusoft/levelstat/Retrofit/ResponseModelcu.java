package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ResponseModelcu {

    @SerializedName("resultcu")
    List<Scientistscu> scientistscu;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Scientistscu> getResultcu () {return  scientistscu;}

    public void setResultcu (List<Scientistscu> scientistscu) {

        this.scientistscu = scientistscu;
    }

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}
}
