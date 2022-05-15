package com.bancusoft.levelstat.Retrofit;
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Cl_prodmold implements Serializable{

    @SerializedName("id")
    private String mId;

    @SerializedName("CODUL")
    private final String CODUL;

    @SerializedName("DENUMIRE")
    private String DENUMIRE;

    @SerializedName("UM")
    private final String UM;

    public Cl_prodmold(String codul, String um) {
        CODUL = codul;
        UM = um;
    }


    /**
     * Let's now come define our getter and setter methods.
     */

    public String getmId() {
        return mId;
    }

    public void setmId(String id) {
        mId = id;
    }



    public  String getCODUL () {

        return CODUL;
    }


    public  String getDENUMIRE () {

        return DENUMIRE;
    }

    public void setDENUMIRE(String DENUMIRE) {
        this.DENUMIRE =  DENUMIRE;

    }



    public  String getUM () {

        return UM;
    }


    @NonNull
    @Override
    public String toString() {
        return getDENUMIRE();
    }
}
