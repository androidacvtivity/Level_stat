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


    @SerializedName("DEN_COM_VW")
    private final String DEN_COM_VW;

    @SerializedName("IDNO_VW")
    private final String IDNO_VW;

    @SerializedName("ADRESA_VW")
    private final String ADRESA_VW;

    @SerializedName("FORMA_ORG_VW")
    private final String FORMA_ORG_VW;

    @SerializedName("LIST_COND_VW")
    private final String LIST_COND_VW;

    @SerializedName("LISTA_FOND_VW")
    private final String LISTA_FOND_VW;

    @SerializedName("GEN_ACT_NE_LIC_VW")
    private final String GEN_ACT_NE_LIC_VW;

    @SerializedName("GEN_ACT_LIC_VW")
    private final String GEN_ACT_LIC_VW;

    @SerializedName("STATUTUL_VW")
    private final String STATUTUL_VW;

    @SerializedName("DATA_REG_VW")
    private final String DATA_REG_VW;

    @SerializedName("personalinfo")
    private final String personalinfo;

    @SerializedName("act")
    private String act;

    public Scientistvw(String den_com_vw, String idno_vw, String adresa_vw, String forma_org_vw, String list_cond_vw, String lista_fond_vw, String gen_act_ne_lic_vw, String gen_act_lic_vw, String statutul_vw, String data_reg_vw, String personalinfo) {
        DEN_COM_VW = den_com_vw;
        IDNO_VW = idno_vw;
        ADRESA_VW = adresa_vw;
        FORMA_ORG_VW = forma_org_vw;
        LIST_COND_VW = list_cond_vw;
        LISTA_FOND_VW = lista_fond_vw;
        GEN_ACT_NE_LIC_VW = gen_act_ne_lic_vw;
        GEN_ACT_LIC_VW = gen_act_lic_vw;
        STATUTUL_VW = statutul_vw;
        DATA_REG_VW = data_reg_vw;
        this.personalinfo = personalinfo;
    }


    public  String getDEN_COM_VW () {

        return DEN_COM_VW;
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

    //-----------
    public  String getADRESA_VW () {

        return ADRESA_VW;
    }

    //-----------
    public  String getFORMA_ORG_VW () {

        return FORMA_ORG_VW;
    }

    //-----------
    public  String getLIST_COND_VW () {

        return LIST_COND_VW;
    }

    //-----------
    public  String getLISTA_FOND_VW () {

        return LISTA_FOND_VW;
    }

    //-----------
    public  String getGEN_ACT_NE_LIC_VW () {

        return GEN_ACT_NE_LIC_VW;
    }

    //-----------
    public  String getGEN_ACT_LIC_VW () {

        return GEN_ACT_LIC_VW;
    }


    //-----------
    public  String getSTATUTUL_VW () {

        return STATUTUL_VW;
    }

    //-----------
    public  String getDATA_REG_VWW () {

        return DATA_REG_VW;
    }

    //-----------
    public  String getPersonalinfo () {

        return personalinfo;
    }

    @NonNull
    @Override
    public String toString() {
        return getLIST_COND_VW();
    }


    }
