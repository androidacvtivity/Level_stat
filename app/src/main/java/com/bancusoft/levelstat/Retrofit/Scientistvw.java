package com.bancusoft.levelstat.Retrofit;
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


/**
 * Let's Create our Scientistvw class to represent a single Scientist.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our
 * class to support serialization and deserialization.
 */
public class Scientistvw  implements Serializable{
/**
 * Let' now come define instance fields for this class. We decorate them with
 * SerializedName
 * attribute. Through this we are specifying the keys in our json data.
 */

@SerializedName("id_vw")
private String mId_vw;



    @SerializedName("DEN_COM_VW")
    private String DEN_COM_VW;

    @SerializedName("IDNO_VW")
    private String IDNO_VW;

    @SerializedName("ADRESA_VW")
    private String ADRESA_VW;

    @SerializedName("FORMA_ORG_VW")
    private String FORMA_ORG_VW;

    @SerializedName("LIST_COND_VW")
    private String LIST_COND_VW;

    @SerializedName("LISTA_FOND_VW")
    private String LISTA_FOND_VW;

    @SerializedName("GEN_ACT_NE_LIC_VW")
    private String GEN_ACT_NE_LIC_VW;

    @SerializedName("GEN_ACT_LIC_VW")
    private String GEN_ACT_LIC_VW;

    @SerializedName("STATUTUL_VW")
    private String STATUTUL_VW;

    @SerializedName("DATA_REG_VW")
    private String DATA_REG_VW;

    @SerializedName("personalinfo")
    private String personalinfo;

    @SerializedName("act")
    private String act;

    /**
     * Let's now come define our getter and setter methods.
     */

    public String getmId_vw() {
        return mId_vw;
    }

    public void setmId_vw(String id_vw) {
        mId_vw = id_vw;
    }


    public  String getDEN_COM_VW () {

        return DEN_COM_VW;
    }

    public void setDEN_COM_VW(String DEN_COM_VW) {
        this.DEN_COM_VW =  DEN_COM_VW;

    }


    public  String getAct () {

        return act;
    }

    public void setAct(String act) {
        this.act =  act;

    }


    public  String getIDNO_VW () {

        return IDNO_VW;
    }

    public void setIDNO_VW(String IDNO_VW) {
        this.IDNO_VW =  IDNO_VW;

    }
   //-----------
    public  String getADRESA_VW () {

        return ADRESA_VW;
    }

    public void setADRESA_VW (String ADRESA_VW) {
        this.ADRESA_VW =  ADRESA_VW;

    }

    //-----------
    public  String getFORMA_ORG_VW () {

        return FORMA_ORG_VW;
    }

    public void setFORMA_ORG_VW (String FORMA_ORG_VW) {
        this.FORMA_ORG_VW = FORMA_ORG_VW;

    }

    //-----------
    public  String getLIST_COND_VW () {

        return LIST_COND_VW;
    }

    public void setLIST_COND_VW (String LIST_COND_VW) {
        this.LIST_COND_VW = LIST_COND_VW;

    }

    //-----------
    public  String getLISTA_FOND_VW () {

        return LISTA_FOND_VW;
    }

    public void setLISTA_FOND_VW (String LISTA_FOND_VW) {
        this.LISTA_FOND_VW = LISTA_FOND_VW;

    }

    //-----------
    public  String getGEN_ACT_NE_LIC_VW () {

        return GEN_ACT_NE_LIC_VW;
    }

    public void setGEN_ACT_NE_LIC_VW (String GEN_ACT_NE_LIC_VW) {
        this.GEN_ACT_NE_LIC_VW = GEN_ACT_NE_LIC_VW;

    }

    //-----------
    public  String getGEN_ACT_LIC_VW () {

        return GEN_ACT_LIC_VW;
    }

    public void setGEN_ACT_LIC_VW (String GEN_ACT_LIC_VW) {
        this.GEN_ACT_LIC_VW = GEN_ACT_LIC_VW;

    }


    //-----------
    public  String getSTATUTUL_VW () {

        return STATUTUL_VW;
    }

    public void setSTATUTUL_VW (String STATUTUL_VW) {
        this.STATUTUL_VW = STATUTUL_VW;

    }

    //-----------
    public  String getDATA_REG_VWW () {

        return DATA_REG_VW;
    }

    public void setDATA_REG_VW (String DATA_REG_VW) {
        this.DATA_REG_VW = DATA_REG_VW;

    }

    //-----------
    public  String getPersonalinfo () {

        return personalinfo;
    }

    public void setPersonalinfo (String personalinfo) {
        this.personalinfo = personalinfo;

    }

    @NonNull
    @Override
    public String toString() {
        return getLIST_COND_VW();
    }


    }
