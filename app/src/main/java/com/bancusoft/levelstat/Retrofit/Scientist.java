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
public class Scientist implements Serializable {
    /**
     * Let' now come define instance fields for this class. We decorate them with
     * SerializedName
     * attribute. Through this we are specifying the keys in our json data.
     */
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("galaxy")
    private String galaxy;
    @SerializedName("star")
    private String star;
    @SerializedName("serviciu")
     private String serviciu;
    @SerializedName("sectia")
     private String sectia;
     @SerializedName("depart")
     private String depart;
     @SerializedName("phone")
     private String phone;
     @SerializedName("phoneinternal")
     private final String phoneinternal;
     @SerializedName("email")
     private String email;
     @SerializedName("personalinfo")
     private final String personalinfo;

     @SerializedName("formname")
     private final String formname;

     @SerializedName("phonemobil")
     private final String phonemobil;

     @SerializedName("floor")
     private final String floor;

     @SerializedName("office")
     private final String office;


     @SerializedName("notice")
     private String notice;

     public Scientist(String phoneinternal, String personalinfo, String formname, String phonemobil, String floor, String office) {
         this.phoneinternal = phoneinternal;
         this.personalinfo = personalinfo;
         this.formname = formname;
         this.phonemobil = phonemobil;
         this.floor = floor;
         this.office = office;
     }


     /**
     * Let's now come define our getter and setter methods.
     */
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }


     public String getNotice() {
         return notice;
     }

     public void setNotice(String notice) {
         this.notice = notice;
     }

     public String getFloor() {
         return floor;
     }


     public String getOffice() {
         return office;
     }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



     public String getDepart() {
         return depart;
     }

     public void setDepart(String depart) {
         this.depart = depart;
     }


     public String getFormname() {
         return formname;
     }


     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }


     public String getPhonemobil() {
         return phonemobil;
     }


     public String getPersonalinfo() {
         return personalinfo;
     }


     public String getEmail() {
         return email;
     }

     public void setEmail (String email) {
         this.email = email;
     }



     public String getPhoneinternal() {
         return phoneinternal;
     }


     public String getServiciu() {
         return serviciu;
     }

     public void setServiciu(String serviciu) {
         this.serviciu = serviciu;
     }

     public String getSectia() {
         return sectia;
     }

     public void setSectia(String sectia) {
         this.sectia = sectia;
     }



     public String getStar() {
         return star;
     }

     public void setStar(String star) {
         this.star = star;
     }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

     @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
//end

