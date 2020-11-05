package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class ResponseModelcuatm {

    @SerializedName("resultcu")
    List<Cl_cuatm_all> cl_cuatm_all;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Cl_cuatm_all> getResultcuatm () {return  cl_cuatm_all;}

    public void setResultcuatm (List<Cl_cuatm_all> cl_cuatm_all) {

        this.cl_cuatm_all = cl_cuatm_all;
    }

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}



}
