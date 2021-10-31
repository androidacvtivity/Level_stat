package com.bancusoft.levelstat.Retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Cl_medicament implements Serializable{

    @SerializedName("id")
    private String mId;

    @SerializedName("nr_ordine")
    private String nr_ordine;

    @SerializedName("codul_med")
    private String codul_med;

    @SerializedName("codul_vamal")
    private String codul_vamal;

    @SerializedName("den_come")
    private String den_come;

    @SerializedName("forma_farmaceutica")
    private String forma_farmaceutica;

    @SerializedName("doza_concentratia")
    private String doza_concentratia;

    @SerializedName("volum")
    private String volum;

    @SerializedName("divizarea")
    private String divizarea;

    @SerializedName("tara")
    private String tara;

    @SerializedName("producatorul")
    private String producatorul;


    @SerializedName("nr_inregistrare")
    private String nr_inregistrare;

    @SerializedName("data_inregistrarii")
    private String data_inregistrarii;

    @SerializedName("codul_atc")
    private String codul_atc;

    @SerializedName("denumirea_int")
    private String denumirea_int;

    @SerializedName("termen_valabilitate")
    private String termen_valabilitate;


    @SerializedName("codul_cu_bare")
    private String codul_cu_bare;


    @SerializedName("notice")
    private String notice;

    /**
     * Let's now come define our getter and setter methods.
     */

    public String getmId() {
        return mId;
    }

    public void setmId(String id) {
        mId = id;
    }

//-1--nr_ordine
    public  String getNr_ordine () {

        return nr_ordine;
    }

    public void setNr_ordine(String nr_ordine) {
        this.nr_ordine =  nr_ordine; }

    //-2--codul_med

    public  String getCodul_med () {

        return codul_med;
    }

    public void setCodul_med(String codul_med) {
        this.codul_med =  codul_med;
    }



    //-3--codul_vamal
    public  String getcodul_vamal () {

        return codul_vamal;
    }

    public void setcodul_vamal(String codul_vamal) {
        this.codul_vamal =  codul_vamal;
    }

    //-4--den_come

    public  String getden_come () {

        return den_come;
    }

    public void setden_come(String den_come) {
        this.den_come =  den_come;
    }

    //-5--forma_farmaceutica

    public  String getforma_farmaceutica () {

        return forma_farmaceutica;
    }

    public void setforma_farmaceutica(String forma_farmaceutica) {
        this.forma_farmaceutica =  forma_farmaceutica;
    }

    //-5--doza_concentratia

    public  String getdoza_concentratia () {

        return doza_concentratia;
    }

    public void setdoza_concentratia(String doza_concentratia) {
        this.doza_concentratia =  doza_concentratia;
    }

    //-6--volum
    public  String getvolum () {

        return volum;
    }

    public void setvolum(String volum) {
        this.volum =  volum;
    }


    //-6--divizarea
    public  String getdivizarea () {

        return divizarea;
    }

    public void setdivizarea(String divizarea) {
        this.divizarea =  divizarea;
    }

 //-7-tara

    public  String getTara () {

        return tara;
    }

    public void setTara(String tara) {
        this.tara =  tara;
    }


 //--producatorul

    public  String getProducatorul () {

        return producatorul;
    }

    public void setProducatorul(String producatorul) {
        this.producatorul =  producatorul;
    }

    //--nr_inregistrare

    public  String getNr_inregistrare () {

        return nr_inregistrare;
    }

    public void setNr_inregistrare(String nr_inregistrare) {
        this.nr_inregistrare =  nr_inregistrare;
    }



    //--data_inregistrarii

    public  String getData_inregistrarii () {

        return data_inregistrarii;
    }

    public void setData_inregistrarii (String data_inregistrarii) {
        this.data_inregistrarii =  data_inregistrarii;
    }


    //--codul_atc

    public  String getCodul_atc () {

        return codul_atc;
    }

    public void setCodul_atc(String codul_atc) {
        this.codul_atc =  codul_atc;
    }


    //--denumirea_int

    public  String getDenumirea_int () {

        return denumirea_int;
    }

    public void setDenumirea_int(String denumirea_int) {
        this.denumirea_int =  denumirea_int;
    }



    //--termen_valabilitate

    public  String getTermen_valabilitate () {

        return termen_valabilitate;
    }

    public void setTermen_valabilitate(String termen_valabilitate) {
        this.termen_valabilitate =  termen_valabilitate;
    }



    //--codul_cu_bare

    public  String getCodul_cu_bare () {

        return codul_cu_bare;
    }

    public void setCodul_cu_bare(String codul_cu_bare) {
        this.codul_cu_bare =  codul_cu_bare;
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
