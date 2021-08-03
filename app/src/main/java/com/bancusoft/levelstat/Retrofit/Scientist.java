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
     * @SerializedName
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
     private String phoneinternal;
     @SerializedName("email")
     private String email;
     @SerializedName("personalinfo")
     private String personalinfo;

     @SerializedName("formname")
     private String formname;

     @SerializedName("phonemobil")
     private String phonemobil;

     @SerializedName("floor")
     private String floor;

     @SerializedName("office")
     private String office;


     @SerializedName("notice")
     private String notice;


//    @SerializedName("dob")
//    private String dob;
//    @SerializedName("died")
//    private String died;

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

     public void setFloor(String floor) {
         this.floor = floor;
     }


     public String getOffice() {
         return office;
     }

     public void setOffice(String office) {
         this.office = office;
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

     public void setFormname(String formname) {
         this.formname = formname;
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

     public void setPhonemobil(String phonemobil) {
         this.phonemobil = phonemobil;
     }




     public String getPersonalinfo() {
         return personalinfo;
     }

     public void sePersonalinfo (String personalinfo) {
         this.personalinfo = personalinfo;
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

     public void setPhoneinternal(String phoneinternal) {
         this.phoneinternal = phoneinternal;
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

//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public String getDied() {
//        return died;
//    }
//
//    public void setDied(String died) {
//        this.died = died;
//    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
//end

