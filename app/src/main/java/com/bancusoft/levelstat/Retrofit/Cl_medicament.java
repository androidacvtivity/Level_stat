package com.bancusoft.levelstat.Retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Cl_medicament implements Serializable{

    @SerializedName("id")
    private String mId;

    @SerializedName("codul_med")
    private final String codul_med;

    @SerializedName("codul_vamal")
    private final String codul_vamal;

    @SerializedName("den_come")
    private final String den_come;

    @SerializedName("forma_farmaceutica")
    private final String forma_farmaceutica;

    @SerializedName("doza_concentratia")
    private final String doza_concentratia;

    @SerializedName("volum")
    private final String volum;

    @SerializedName("divizarea")
    private final String divizarea;

    @SerializedName("tara")
    private final String tara;

    @SerializedName("producatorul")
    private final String producatorul;


    @SerializedName("nr_inregistrare")
    private final String nr_inregistrare;

    @SerializedName("data_inregistrarii")
    private final String data_inregistrarii;

    @SerializedName("codul_atc")
    private final String codul_atc;

    @SerializedName("denumirea_int")
    private final String denumirea_int;

    @SerializedName("termen_valabilitate")
    private final String termen_valabilitate;


    @SerializedName("codul_cu_bare")
    private final String codul_cu_bare;


    @SerializedName("notice")
    private String notice;

    public Cl_medicament(String codul_med, String codul_vamal, String den_come, String forma_farmaceutica, String doza_concentratia, String volum, String divizarea, String tara, String producatorul, String nr_inregistrare, String data_inregistrarii, String codul_atc, String denumirea_int, String termen_valabilitate, String codul_cu_bare) {
        this.codul_med = codul_med;
        this.codul_vamal = codul_vamal;
        this.den_come = den_come;
        this.forma_farmaceutica = forma_farmaceutica;
        this.doza_concentratia = doza_concentratia;
        this.volum = volum;
        this.divizarea = divizarea;
        this.tara = tara;
        this.producatorul = producatorul;
        this.nr_inregistrare = nr_inregistrare;
        this.data_inregistrarii = data_inregistrarii;
        this.codul_atc = codul_atc;
        this.denumirea_int = denumirea_int;
        this.termen_valabilitate = termen_valabilitate;
        this.codul_cu_bare = codul_cu_bare;
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

    //-2--codul_med

    public  String getCodul_med () {

        return codul_med;
    }


    //-3--codul_vamal
    public  String getcodul_vamal () {

        return codul_vamal;
    }

    //-4--den_come

    public  String getden_come () {

        return den_come;
    }

    //-5--forma_farmaceutica

    public  String getforma_farmaceutica () {

        return forma_farmaceutica;
    }

    //-5--doza_concentratia

    public  String getdoza_concentratia () {

        return doza_concentratia;
    }

    //-6--volum
    public  String getvolum () {

        return volum;
    }


    //-6--divizarea
    public  String getdivizarea () {

        return divizarea;
    }

    //-7-tara

    public  String getTara () {

        return tara;
    }


    //--producatorul

    public  String getProducatorul () {

        return producatorul;
    }

    //--nr_inregistrare

    public  String getNr_inregistrare () {

        return nr_inregistrare;
    }


    //--data_inregistrarii

    public  String getData_inregistrarii () {

        return data_inregistrarii;
    }


    //--codul_atc

    public  String getCodul_atc () {

        return codul_atc;
    }


    //--denumirea_int

    public  String getDenumirea_int () {

        return denumirea_int;
    }


    //--termen_valabilitate

    public  String getTermen_valabilitate () {

        return termen_valabilitate;
    }


    //--codul_cu_bare

    public  String getCodul_cu_bare () {

        return codul_cu_bare;
    }


    //--notice

    public  String getNotice () {

        return notice;
    }

    public void setNotice(String notice) {
        this.notice =  notice;
    }



    @NonNull
    @Override
    public String toString() {
        return getden_come();
    }
}
