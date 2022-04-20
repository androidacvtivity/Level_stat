package com.bancusoft.levelstat.Retrofit;
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Scientistscaem implements Serializable {

    /**
     * Let' now come define instance fields for this class. We decorate them with
     * SerializedName
     * attribute. Through this we are specifying the keys in our json data.
     */

    @SerializedName("id")
    private String mId;

    @SerializedName("DENUMIRE")
    private String DENUMIRE;

    @SerializedName("VALUE")
    private final String VALUE;


    @SerializedName("act")
    private String act;

    public Scientistscaem(String value) {
        VALUE = value;
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



    public  String getDENUMIRE () {

        return DENUMIRE;
    }

    public void setDENUMIRE (String DENUMIRE) {
        this.DENUMIRE =  DENUMIRE;

    }

    public  String getVALUE () {

        return VALUE;
    }


    public  String getAct () {

        return act;
    }

    public void setAct(String act) {
        this.act =  act;

    }


    @NonNull
    @Override
    public String toString() {
        return getDENUMIRE();
    }
}
