package com.bancusoft.levelstat.Retrofit;
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/**
 * Let's Create our Cl_cfoj class to represent a single Cl_cfoj.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our  class to support serialization and deserialization.
 */
public class Cl_cfoj implements Serializable {


    @SerializedName("id")
    private String mId;

    @SerializedName("CODUL")
    private final String CODUL;

    @SerializedName("DENUMIRE")
    private String DENUMIRE;

    public Cl_cfoj(String codul) {
        CODUL = codul;
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



    @NonNull
    @Override
    public String toString() {
        return getDENUMIRE();
    }
}
