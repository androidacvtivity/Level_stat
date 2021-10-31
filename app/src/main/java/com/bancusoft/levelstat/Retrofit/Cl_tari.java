package com.bancusoft.levelstat.Retrofit;
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Cl_tari implements Serializable{
    @SerializedName("id")
    private String mId;

    @SerializedName("CODUL")
    private String CODUL;

    @SerializedName("DENUMIRE")
    private String DENUMIRE;



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

    public void setCODUL(String CODUL) {
        this.CODUL =  CODUL;

    }


    public  String getDENUMIRE () {

        return DENUMIRE;
    }

    public void setDENUMIRE(String DENUMIRE) {
        this.DENUMIRE =  DENUMIRE;

    }



    @NonNull
    @Override
    public String toString() {
        return getDENUMIRE();
    }
}
