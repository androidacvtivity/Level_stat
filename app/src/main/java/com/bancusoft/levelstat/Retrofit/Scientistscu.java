package com.bancusoft.levelstat.Retrofit;
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Let's Create our Scientist class to represent a single Scientist.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our
 * class to support serialization and deserialization.
 */

public class Scientistscu  implements Serializable{

    @SerializedName("DEN_CUATM")
    private final String DEN_CUATM;

    @SerializedName("NUMBER_CUATM")
    private final String NUMBER_CUATM;


    @SerializedName("source")
    private final String source;

    public Scientistscu(String den_cuatm, String number_cuatm, String source) {
        DEN_CUATM = den_cuatm;
        NUMBER_CUATM = number_cuatm;
        this.source = source;
    }


    public  String getDEN_CUATM () {

        return DEN_CUATM;
    }

    public  String getNUMBER_CUATM () {

        return NUMBER_CUATM;
    }


    public  String getSource () {

        return source;
    }


    @NonNull
    @Override
    public String toString() {
        return getDEN_CUATM();
    }
}
