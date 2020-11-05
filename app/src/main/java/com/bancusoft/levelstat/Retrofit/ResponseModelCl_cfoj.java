package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class ResponseModelCl_cfoj {


    @SerializedName("resultcu")
    List<Cl_cfoj> cl_cfoj;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Cl_cfoj> getResultCl_cfoj () {return  cl_cfoj;}

    public void setResultCl_cfoj (List<Cl_cfoj> cl_cfoj) {

        this.cl_cfoj = cl_cfoj;
    }

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}

}
