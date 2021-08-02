package com.bancusoft.levelstat.Helpers;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Cl_caem;
import com.bancusoft.levelstat.Retrofit.Cl_caem2;
import com.bancusoft.levelstat.Retrofit.Cl_cfoj;
import com.bancusoft.levelstat.Retrofit.Cl_cfp;
import com.bancusoft.levelstat.Retrofit.Cl_cocm;
import com.bancusoft.levelstat.Retrofit.Cl_cuatm_all;
import com.bancusoft.levelstat.Retrofit.Cl_medicament;
import com.bancusoft.levelstat.Retrofit.Cl_prodmold;
import com.bancusoft.levelstat.Retrofit.Cl_servicii;
import com.bancusoft.levelstat.Retrofit.Cl_tari;
import com.bancusoft.levelstat.Retrofit.Scientist;
import com.bancusoft.levelstat.Retrofit.Scientistscaem;
import com.bancusoft.levelstat.Retrofit.Scientistscfp;
import com.bancusoft.levelstat.Retrofit.Scientistscu;
import com.bancusoft.levelstat.Retrofit.Scientistvw;
import com.bancusoft.levelstat.Views.DashboardActivity;
import com.bancusoft.levelstat.Views.help;
import com.bancusoft.levelstat.Views.help_vw;
import com.bancusoft.levelstat.Views.help_vw_en;
import com.bancusoft.levelstat.Views.help_vw_ru;
import com.bancusoft.levelstat.Views.helpen;
import com.bancusoft.levelstat.Views.helpru;
import com.bancusoft.levelstat.Views.med.help_medicament;
import com.bancusoft.levelstat.Views.med.help_medicament_en;
import com.bancusoft.levelstat.Views.med.help_medicament_ru;
import com.yarolegovich.lovelydialog.LovelyChoiceDialog;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A Utility class. Contains reusable utility methods we will use throughout our project.This
 * class will save us from typing lots of repetitive code.
 */
//Last commit before change account in github.
public class Utils {
    /**
     * Let's define some Constants
     */
    //supply your ip address. Type ipconfig while connected to internet to get your
    //ip address in cmd. Watch video for more details.
     //
  //
  public   static  final  String  youtube_level_stat = "https://www.youtube.com/watch?v=GovpbmgZY_E";

    public   static  final  String  youtube_Stat_Level = "https://www.youtube.com/watch?v=Mn4AV9exZJ0";

      private  static  final String base_url = "http://bancusoft.com/PHP/bns/";


  //   private  static  final String base_url = "http://192.168.0.100/bns/";

    //http://192.168.1.2/PHP/bns/

   // private  static  final String base_url =   "http://192.168.0.101/PHP/bns/";


   //   private  static  final String base_url =   "http://192.168.0.102/PHP/bns/";


    private static Retrofit retrofit = null;
   // public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * This method will return us our Retrofit instance which we can use to initiate HTTP calls.
     */
    public static Retrofit getClient(){


        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(base_url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.MINUTES)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(okHttpClient)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return  retrofit;
    }
    /**
     * THis method will allow us show Toast messages throughout all activities
     */
    public static void show(Context c,String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }
    /**
     * This method will allow us validate edittexts
     */
    public static boolean validate(EditText... editTexts){
        EditText nameTxt = editTexts[0];
        EditText descriptionTxt = editTexts[1];
        EditText galaxyTxt = editTexts[2];

        if(nameTxt.getText() == null || nameTxt.getText().toString().isEmpty()){
            nameTxt.setError("Numele este obligatoriu Vă rog!");
            return false;
        }
        if(descriptionTxt.getText() == null || descriptionTxt.getText().toString().isEmpty()){
            descriptionTxt.setError("Locația este obligatorie Vă rog!");
            return false;
        }
        if(galaxyTxt.getText() == null || galaxyTxt.getText().toString().isEmpty()){
            galaxyTxt.setError("Funcția este obligatorie Vă rog!");
            return false;
        }
        return true;

    }

    //This utility method will allow us clear arbitrary number of edittexts

//    public static void clearEditTexts(EditText... editTexts){
//        for (EditText editText:editTexts) {
//            editText.setText("");
//        }
//
//
//    }


    /**
     * This utility method will allow us open any activity.
     */
    public static void openActivity(Context c,Class <?> clazz){
        Intent intent = new Intent(c, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(intent);
    }



    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog(final AppCompatActivity activity, String title,
                                      String message) {
        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Relax", v -> {})
                .setNeutralButton("Go Home", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("Go Back", v -> activity.finish())
                .show();
    }




    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ro_med(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)

                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("en", v -> openActivity(activity, help_medicament_en.class))
                .setNeutralButton("La inceput", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, help_medicament_ru.class))

                .show();
    }

    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ro(final AppCompatActivity activity, String title,
                                      String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)

                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("en", v -> openActivity(activity, helpen.class))
                .setNeutralButton("La inceput", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, helpru.class))

                .show();
    }

    /**
     * For Scientistvw
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ro_vw(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)

                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("en", v -> openActivity(activity, help_vw_en.class))
                .setNeutralButton("La inceput", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, help_vw_ru.class))

                .show();
    }


    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_en(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help.class))
                .setNeutralButton("Dashboard", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, helpru.class))

                .show();
    }


    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_en_med(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help_medicament.class))
                .setNeutralButton("Dashboard", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, help_medicament_ru.class))

                .show();
    }


    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_en_vw(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help_vw.class))
                .setNeutralButton("Dashboard", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", v -> openActivity(activity, help_vw_ru.class))

                .show();
    }

    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ru(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help.class))
                .setNeutralButton("В начало", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("en", v -> openActivity(activity, helpen.class))


                .show();
    }

    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ru_med(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help_medicament.class))
                .setNeutralButton("В начало", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("en", v -> openActivity(activity, help_medicament_en.class))


                .show();
    }



    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */
    public static void showInfoDialog_help_ru_vw(final AppCompatActivity activity, String title,
                                              String message) {

        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)

                .setPositiveButton("ro", v -> openActivity(activity, help_vw.class))
                .setNeutralButton("В начало", v -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("en", v -> openActivity(activity, help_vw_en.class))


                .show();
    }

    /**
     * This method will allow us show a single select dialog where we can select and return a
     * star to an edittext.
     */
     public static void selectStar(Context c,final EditText starTxt){
//        String[] stars ={"Rigel","Aldebaran","Arcturus","Betelgeuse","Antares","Deneb",
//        "Wezen","VY Canis Majoris","Sirius","Alpha Pegasi","Vega","Saiph","Polaris",
//        "Canopus","KY Cygni","VV Cephei","Uy Scuti","Bellatrix","Naos","Pollux",
//        "Achernar","Other"};

    String[] stars ={"Director General","Director general adjunct","tehnologii informationale","statistica intreprinderilor","statistica macroeconomica","colectarea datelor entitati economice",

            "statistica sociala si demografie","CRS NORD","CRS NORD Balti","CRS NORD Briceni","CRS NORD Donduseni","CRS NORD Drochia","CRS NORD Edinet",

            "CRS NORD Falesti","CRS NORD Floresti","CRS NORD Glodeni","CRS NORD Ocnita","CRS NORD Rezina","CRS NORD Rascani","CRS NORD Sangerei",

            "CRS NORD Soroca","CRS NORD Soldanesti", "CRS NORD Soldanesti","CRS NORD Telenesti","CRS CENTRU","CRS CENTRU Anenii-Noi",
            "CRS CENTRU Calarasi","CRS CENTRU Causeni","CRS CENTRU Cimislia","CRS CENTRU Criuleni",
            "CRS CENTRU Dubasari Cocieri","CRS CENTRU Hancesti","CRS CENTRU Ialoveni","CRS CENTRU Nisporeni",
            "CRS CENTRU Orhei","CRS CENTRU Straseni","CRS CENTRU Stefan-Voda","CRS CENTRU Ungheni","CRS SUD","CRS SUD Basarabeasca",
            "CRS SUD Cahul","CRS SUD Cantemir","CRS SUD UTA Gagauzia","CRS SUD Leova","CRS SUD Taraclia","CRS CENTRU Donduseni","CRS CENTRU Drochia",
            "CRS CENTRU Dubasari (Cocieri)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(c,
                android.R.layout.simple_list_item_1,
                stars);
        new LovelyChoiceDialog(c)
                .setTopColorRes(R.color.darkGreen)
                .setTitle("Direcția generală")
                .setTitleGravity(Gravity.CENTER_HORIZONTAL)
                .setIcon(R.drawable.m_star)
                .setMessage("Selectați Direcția generală sau cenrtul regional")
                .setMessageGravity(Gravity.CENTER_HORIZONTAL)
                .setItems(adapter, (position, item) -> starTxt.setText(item))
                .show();
    }


   // This method will allow us convert a string into a java.util.Date object and
   // return it.


  //  public static Date giveMeDate(String stringDate){
   //     try {
    //        SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
   //         return sdf.parse(stringDate);
  //      }catch (ParseException e){
  //          e.printStackTrace();
  //          return null;
  //      }
  //  }


    /**
     * This method will allow us show a progressbar
     */
    public static void showProgressBar(ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
    }
    /**
     * This method will allow us hide a progressbar
     */
    public static void hideProgressBar(ProgressBar pb){
        pb.setVisibility(View.GONE);
    }



    /**
     * This method will allow us send a serialized Cl_medicament objec  to a specified
     *  activity
     */

    public static void sendCl_mediToActivity(Context c, Cl_medicament cl_medicament,
                                             Class clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY",  cl_medicament);
        c.startActivity(i);
    }



    /**
     * This method will allow us send a serialized Cl_tari objec  to a specified
     *  activity
     */

    public static void sendCl_tariToActivity(Context c, Cl_tari cl_tari,
                                             Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",  cl_tari);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized Cl_tari objec  to a specified
     *  activity
     */

    public static void sendCl_prodmoldToActivity(Context c, Cl_prodmold cl_prodmold,
                                             Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable) cl_prodmold);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized Cl_cfoj objec  to a specified
     *  activity
     */

    public static void sendCl_cfojToActivity(Context c, Cl_cfoj cl_cfoj,
                                              Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable)cl_cfoj);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized Cl_cocm objec  to a specified
     *  activity
     */

    public static void sendCl_cocmToActivity(Context c, Cl_cocm cl_cocm,
                                             Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable)cl_cocm);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized Cl_cocm objec  to a specified
     *  activity
     */

    public static void sendCl_cfpToActivity(Context c, Cl_cfp cl_cfp,
                                             Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable)cl_cfp);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized Cl_servicii objec  to a specified
     *  activity
     */

    public static void sendCl_serviciiToActivity(Context c, Cl_servicii cl_servicii,
                                            Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable)cl_servicii);
        c.startActivity(i);
    }


       /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */

    public static void sendCl_caem2ToActivity(Context c, Cl_caem2 cl_caem2,
                                              Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable) cl_caem2);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */

    public static void sendCl_caemToActivity(Context c, Cl_caem cl_caem,
                                              Class clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY",(Serializable)cl_caem);
        c.startActivity(i);
    }



    /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */

    public static void sendScientistToActivity(Context c, Scientist scientist,
     Class clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//                "",scientist);
        i.putExtra("SCIENTIST_KEY",(Serializable)scientist);
        c.startActivity(i);
    }





    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistvwToActivity(Context c, Scientistvw scientistvw,
                                               Class clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY",(Serializable)scientistvw);
        c.startActivity(i);
    }
    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistscuToActivity(Context c, Scientistscu scientistscu,
                                                 Class clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY",(Serializable)scientistscu);
        c.startActivity(i);
    }



    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistscaemToActivity(Context c, Scientistscaem scientistscaem,
                                                  Class clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY",(Serializable)scientistscaem);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized cl_cuatm_all objec  to a specifie activity
     */
    public static void sendCl_cuatm_allToActivity(Context c, Cl_cuatm_all cl_cuatm_all,
                                                    Class clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY",(Serializable)cl_cuatm_all);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized Scientistscfp objec  to a specifie activity
     */
    public static void sendScientistscfpToActivity(Context c, Scientistscfp scientistscfp,
                                                    Class clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY",(Serializable)scientistscfp);
        c.startActivity(i);
    }


    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientist receiveScientist(Intent intent,Context c){
        try {
            Scientist scientist= (Scientist) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientist;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized Cl_caem2, deserialize it and return it,.
     */
    public  static Cl_caem2 receiveCl_caem2(Intent intent,Context c){
        try {
            Cl_caem2 cl_caem2= (Cl_caem2) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_caem2;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }
    /**
     * This method will allow us receive a serialized Cl_caem, deserialize it and return it,.
     */
    public  static Cl_caem receiveCl_caem(Intent intent,Context c){
        try {
            Cl_caem cl_caem = (Cl_caem) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_caem;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized cl_cuatm_all, deserialize it and return it,.
     */
    public  static Cl_cuatm_all receiveCl_cuatm_all(Intent intent,Context c){
        try {
            Cl_cuatm_all cl_cuatm_all= (Cl_cuatm_all) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_cuatm_all;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }






    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistvw receiveScientistvw(Intent intent,Context c){
        try {
            Scientistvw scientistvw= (Scientistvw) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientistvw;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistscu receiveScientistscu(Intent intent,Context c) {
        try {
            Scientistscu scientistscu= (Scientistscu) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientistscu
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistscaem receiveScientistscaem(Intent intent,Context c) {
        try {
            Scientistscaem scientistscaem= (Scientistscaem) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientistscaem
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Scientistscfp, deserialize it and return it,.
     */
    public  static Scientistscfp receiveScientistscfp(Intent intent,Context c) {
        try {
            Scientistscfp scientistscfp= (Scientistscfp) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientistscfp
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Cl_cfoj, deserialize it and return it,.
     */
    public  static Cl_cfoj receiveCl_cfoj(Intent intent,Context c) {
        try {
            Cl_cfoj cl_cfoj= (Cl_cfoj) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_cfoj
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Cl_cocm, deserialize it and return it,.
     */
    public  static Cl_cocm receiveCl_cocm(Intent intent,Context c) {
        try {
            Cl_cocm cl_cocm= (Cl_cocm) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_cocm
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Cl_cfp, deserialize it and return it,.
     */
    public  static Cl_cfp receiveCl_cfp(Intent intent,Context c) {
        try {
            Cl_cfp cl_cfp= (Cl_cfp) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_cfp
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * This method will allow us receive a serialized Cl_servicii, deserialize it and return it,.
     */
    public  static Cl_servicii receiveCl_servicii(Intent intent,Context c) {
        try {
            Cl_servicii cl_servicii= (Cl_servicii) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_servicii
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized Cl_tari, deserialize it and return it,.
     */
    public  static Cl_tari receiveCl_tari(Intent intent,Context c) {
        try {
            Cl_tari cl_tari= (Cl_tari) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_tari;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * This method will allow us receive a serialized Cl_prodmold, deserialize it and return it,.
     */
    public  static Cl_prodmold receiveCl_prodmold(Intent intent,Context c) {
        try {
            Cl_prodmold cl_prodmold= (Cl_prodmold) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_prodmold;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * This method will allow us receive a serialized cl_medicament, deserialize it and return it,.
     */

    public  static Cl_medicament receiveCl_medicament(Intent intent,Context c) {
        try {
            Cl_medicament cl_medicament= (Cl_medicament) intent.getSerializableExtra("SCIENTIST_KEY");
            return cl_medicament;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -Medicament ERROR: "+e.getMessage());
        }
        return null;
    }


}
//end
