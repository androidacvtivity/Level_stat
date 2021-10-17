package com.bancusoft.levelstat.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Scientist;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class CRUDActivity extends AppCompatActivity {
    //we'll have several instance fields
    private EditText nameTxt, descriptionTxt, galaxyTxt, starTxt, serviciuTxt, sectiaTxt , departTxt, phoneTxt, phoneinternalTxt, emailTxt, personalinfoTxt,
            formnameTxt;
    private TextView headerTxt;
    private Scientist receivedScientist;
    private final Context c = CRUDActivity.this;

    /**
     * Let's reference our widgets
     */
    private void initializeWidgets() {
        //   private DateTimePickerEditText dobTxt, dodTxt;
        ProgressBar mProgressBar = findViewById(R.id.mProgressBarSave);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(View.GONE);

        headerTxt = findViewById(R.id.headerTxt);
        nameTxt = findViewById(R.id.nameTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        galaxyTxt = findViewById(R.id.galaxyTxt);
        starTxt = findViewById(R.id.starTxt);
        serviciuTxt = findViewById(R.id.serviciuTxt);
        sectiaTxt = findViewById(R.id.sectiaTxt);
        departTxt = findViewById(R.id.departTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        phoneinternalTxt = findViewById(R.id.phoneinternalTxt);
        emailTxt = findViewById(R.id.emailTxt);
        personalinfoTxt = findViewById(R.id.personalinfoTxt);
        formnameTxt = findViewById(R.id.formnameTxt);
    }



//    private void insertData() {
//        String name, description, galaxy, star, serviciu, sectia, depart, phone, phoneinternal, email, personalinfo, formname; //, dob, died;
//        if (Utils.validate(nameTxt, descriptionTxt, galaxyTxt, serviciuTxt, sectiaTxt, departTxt, phoneTxt, phoneinternalTxt, emailTxt ,
//                personalinfoTxt, formnameTxt)) {
//            name = nameTxt.getText().toString();
//            description = descriptionTxt.getText().toString();
//            galaxy = galaxyTxt.getText().toString();
//            star = starTxt.getText().toString();
//            serviciu = serviciuTxt.getText().toString();
//            sectia = sectiaTxt.getText().toString();
//            depart = departTxt.getText().toString();
//            phone = phoneTxt.getText().toString();
//            phoneinternal = phoneinternalTxt.getText().toString();
//            email = emailTxt.getText().toString();
//            personalinfo = personalinfoTxt.getText().toString();
//            formname = formnameTxt.getText().toString();
//
////            if (dobTxt.getDate() != null) {
////                dob = dobTxt.getDate().toString();
////            } else {
////                dobTxt.setError("Invalid Date");
////                dobTxt.requestFocus();
////                return;
////            }
////            if (dodTxt.getDate() != null) {
////                died = dodTxt.getDate().toString();
////            } else {
////                dodTxt.setError("Invalid Date");
////                dodTxt.requestFocus();
////                return;
////            }
//            RestApi api = Utils.getClient().create(RestApi.class);
//            Call<ResponseModel> insertData = api.insertData("INSERT", name,
//             description, galaxy, star,serviciu, sectia, depart, phone, phoneinternal,email,personalinfo, formname);
//
//            Utils.showProgressBar(mProgressBar);
//
//            insertData.enqueue(new Callback<ResponseModel>() {
//                @Override
//                public void onResponse(@NonNull Call<ResponseModel> call,
//                                       @NonNull Response<ResponseModel> response) {
//
//                    assert response.body() != null;
//                    Log.d("RETROFIT", "response : " + response.body().toString());
//                    String myResponseCode = response.body().getCode();
//
//                    if (myResponseCode.equals("1")) {
//                        Utils.show(c, "SUCCESS: \n 1. Data Inserted Successfully. \n 2. ResponseCode: "
//                         + myResponseCode);
//                        Utils.openActivity(c, ScientistsActivity.class);
//                    } else if (myResponseCode.equalsIgnoreCase("2")) {
//                        Utils.showInfoDialog(CRUDActivity.this, "UNSUCCESSFUL",
//                        "However Good Response. \n 1. CONNECTION TO SERVER WAS SUCCESSFUL \n 2. WE"+
//                        " ATTEMPTED POSTING DATA BUT ENCOUNTERED ResponseCode: "+myResponseCode+
//                        " \n 3. Most probably the problem is with your PHP Code.");
//                    }else if (myResponseCode.equalsIgnoreCase("3")) {
//                        Utils.showInfoDialog(CRUDActivity.this, "NO MYSQL CONNECTION","Your PHP Code is unable to connect to mysql database. Make sure you have supplied correct database credentials.");
//                    }
//                    Utils.hideProgressBar(mProgressBar);
//                }
//                @Override
//                public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
//                    Log.d("RETROFIT", "ERROR: " + t.getMessage());
//                    Utils.hideProgressBar(mProgressBar);
//                    Utils.showInfoDialog(CRUDActivity.this, "FAILURE",
//                     "FAILURE THROWN DURING INSERT."+
//                    " ERROR Message: " + t.getMessage());
//                }
//            });
//        }
//    }


//
//    private void updateData() {
//        String name, description, galaxy, star, serviciu , sectia, depart, phone, phoneinternal, email ,personalinfo, formname; //, dob, died;
//        if (Utils.validate(nameTxt, descriptionTxt, galaxyTxt, serviciuTxt , sectiaTxt, departTxt, phoneTxt, phoneinternalTxt, emailTxt,
//                personalinfoTxt, formnameTxt)) {
//            name = nameTxt.getText().toString();
//            description = descriptionTxt.getText().toString();
//            galaxy = galaxyTxt.getText().toString();
//            star = starTxt.getText().toString();
//            serviciu = serviciuTxt.getText().toString();
//            sectia = sectiaTxt.getText().toString();
//            depart = departTxt.getText().toString();
//            phone = phoneTxt.getText().toString();
//            phoneinternal = phoneinternalTxt.getText().toString();
//            email = emailTxt.getText().toString();
//            personalinfo = personalinfoTxt.getText().toString();
//            formname = formnameTxt.getText().toString();
//
////            if (dobTxt.getDate() != null) {
////                dob = dobTxt.getFormat().format(dobTxt.getDate());
////            } else {
////                dobTxt.setError("Invalid Date");
////                dobTxt.requestFocus();
////                return;
////            }
////            if (dodTxt.getDate() != null) {
////                died = dodTxt.getFormat().format(dodTxt.getDate());
////            } else {
////                dodTxt.setError("Invalid Date");
////                dodTxt.requestFocus();
////                return;
////            }
//            Utils.showProgressBar(mProgressBar);
//            RestApi api = Utils.getClient().create(RestApi.class);
//            Call<ResponseModel> update = api.updateData("UPDATE", id, name, description, galaxy,
//             star, serviciu, sectia, depart, phone,phoneinternal, email,personalinfo, formname);
//             //dob, died);
//            update.enqueue(new Callback<ResponseModel>() {
//                @Override
//                public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
//                    assert response.body() != null;
//                    Log.d("RETROFIT", "Response: " + response.body().getResult());
//
//                    Utils.hideProgressBar(mProgressBar);
//                    String myResponseCode = response.body().getCode();
//
//                    if (myResponseCode.equalsIgnoreCase("1")) {
//                        Utils.show(c, response.body().getMessage());
//                        Utils.openActivity(c, ScientistsActivity.class);
//                        finish();
//                    } else if (myResponseCode.equalsIgnoreCase("2")) {
//                        Utils.showInfoDialog(CRUDActivity.this, "UNSUCCESSFUL",
//                        "Good Response From PHP,"+
//                        "WE ATTEMPTED UPDATING DATA BUT ENCOUNTERED ResponseCode: "+myResponseCode+
//                        " \n 3. Most probably the problem is with your PHP Code.");
//                    } else if (myResponseCode.equalsIgnoreCase("3")) {
//                        Utils.showInfoDialog(CRUDActivity.this, "NO MYSQL CONNECTION",
//                        " Your PHP Code"+
//                        " is unable to connect to mysql database. Make sure you have supplied correct"+
//                        " database credentials.");
//                    }
//                }
//                @Override
//                public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
//                    Log.d("RETROFIT", "ERROR THROWN DURING UPDATE: " + t.getMessage());
//                    Utils.hideProgressBar(mProgressBar);
//                    Utils.showInfoDialog(CRUDActivity.this, "FAILURE THROWN", "ERROR DURING UPDATE.Here"+
//                    " is the Error: " + t.getMessage());
//                }
//            });
//        }
//    }

//    private void deleteData() {
//        RestApi api = Utils.getClient().create(RestApi.class);
//        Call<ResponseModel> del = api.remove("DELETE", id);
//
//        Utils.showProgressBar(mProgressBar);
//        del.enqueue(new Callback<ResponseModel>() {
//            @Override
//            public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
//                Log.d("RETROFIT", "DELETE RESPONSE: " + response.body());
//                Utils.hideProgressBar(mProgressBar);
//                assert response.body() != null;
//                String myResponseCode = response.body().getCode();
//
//                if (myResponseCode.equalsIgnoreCase("1")) {
//                    Utils.show(c, response.body().getMessage());
//                    Utils.openActivity(c, ScientistsActivity.class);
//                    finish();
//                } else if (myResponseCode.equalsIgnoreCase("2")) {
//                    Utils.showInfoDialog(CRUDActivity.this, "UNSUCCESSFUL",
//                     "However Good Response. \n 1. CONNECTION TO SERVER WAS SUCCESSFUL"+
//                     " \n 2. WE ATTEMPTED POSTING DATA BUT ENCOUNTERED ResponseCode: "+
//                     myResponseCode+ " \n 3. Most probably the problem is with your PHP Code.");
//                }else if (myResponseCode.equalsIgnoreCase("3")) {
//                    Utils.showInfoDialog(CRUDActivity.this, "NO MYSQL CONNECTION",
//                    " Your PHP Code is unable to connect to mysql database. Make sure you have supplied correct database credentials.");
//                }
//            }
//            @Override
//            public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
//                Utils.hideProgressBar(mProgressBar);
//                Log.d("RETROFIT", "ERROR: " + t.getMessage());
//                Utils.showInfoDialog(CRUDActivity.this, "FAILURE THROWN", "ERROR during DELETE attempt. Message: " + t.getMessage());
//            }
//        });
//    }

     // Show selected star in our edittext

    /**
     * When our back button is pressed
     */
    @Override
    public void onBackPressed() {
        Utils.showInfoDialog(this, "Atenție", "Sunteți sigutri că vreți sa esiți?");
    }
    /**
     * Let's inflate our menu based on the role this page has been opened for.
     */
    @SuppressLint("SetTextI18n")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (receivedScientist == null) {
            getMenuInflater().inflate(R.menu.new_item_menu, menu);
            headerTxt.setText("Adaugă angajat nou");
        } else {
            getMenuInflater().inflate(R.menu.edit_item_menu, menu);
            headerTxt.setText("Editează angajatul existent");
        }
        return true;
    }
    /**
     * Let's listen to menu action events and perform appropriate function
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    /**
     * Attach Base Context
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    /**
     * When our activity is resumed we will receive our data and set them to their editing
     * widgets.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Scientist o = Utils.receiveScientist(getIntent(), c);
        if (o != null) {
            receivedScientist = o;
            nameTxt.setText(receivedScientist.getName());
            descriptionTxt.setText(receivedScientist.getDescription());
            galaxyTxt.setText(receivedScientist.getGalaxy());
            starTxt.setText(receivedScientist.getStar());
            serviciuTxt.setText(receivedScientist.getServiciu());
            sectiaTxt.setText(receivedScientist.getSectia());
            departTxt.setText(receivedScientist.getDepart());
            phoneTxt.setText(receivedScientist.getPhone());
            phoneinternalTxt.setText(receivedScientist.getPhoneinternal());
            emailTxt.setText(receivedScientist.getEmail());
            personalinfoTxt.setText(receivedScientist.getPersonalinfo());
            formnameTxt.setText(receivedScientist.getFormname());
        }  //Utils.show(c,"Received Scientist is Null");

    }
    /**
     * Let's override our onCreate() method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        this.initializeWidgets();
      //  this.showSelectedStarInEditText();
    }
}
//end
