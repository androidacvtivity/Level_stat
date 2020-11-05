package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Let's Create our Cl_cocm class to represent a single Cl_cocm.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our  class to support serialization and deserialization.
 */

public class Cl_cocm  implements Serializable  {

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



    @Override
    public String toString() {
        return getDENUMIRE();
    }
}
