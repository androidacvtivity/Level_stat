package com.bancusoft.levelstat.Retrofit;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Let's Create our Scientist class to represent a single Scientist.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our
 * class to support serialization and deserialization.
 */

public class Scientistscu  implements Serializable{

    /**
     * Let' now come define instance fields for this class. We decorate them with
     * @SerializedName
     * attribute. Through this we are specifying the keys in our json data.
     */

    @SerializedName("id_cu")
    private String mId_cu;

    @SerializedName("DEN_CUATM")
    private String DEN_CUATM;

    @SerializedName("NUMBER_CUATM")
    private String NUMBER_CUATM;


    @SerializedName("source")
    private String source;

    /**
     * Let's now come define our getter and setter methods.
     */

    public String getmId_cu() {
        return mId_cu;
    }

    public void setmId_cu(String id_cu) {
        mId_cu = id_cu;
    }



    public  String getDEN_CUATM () {

        return DEN_CUATM;
    }

    public void setDEN_CUATM(String DEN_CUATM) {
        this.DEN_CUATM =  DEN_CUATM;

    }

    public  String getNUMBER_CUATM () {

        return NUMBER_CUATM;
    }

    public void setNUMBER_CUATM(String NUMBER_CUATM) {
        this.NUMBER_CUATM =  NUMBER_CUATM;

    }


    public  String getSource () {

        return source;
    }

    public void setSource(String source) {
        this.source =  source;

    }


    @Override
    public String toString() {
        return getDEN_CUATM();
    }
}
