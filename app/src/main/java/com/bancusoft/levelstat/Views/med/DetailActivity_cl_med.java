package com.bancusoft.levelstat.Views.med;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.bancusoft.levelstat.Retrofit.Scientist;
import com.bancusoft.levelstat.Views.help;
import com.bancusoft.levelstat.Views.helpen;
import com.bancusoft.levelstat.Views.helpru;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Cl_medicament;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

import static com.bancusoft.levelstat.R.id.mCollapsingToolbarLayout;


public class DetailActivity_cl_med extends AppCompatActivity  {

    //Let's define our instance fields
    private TextView codul_medTV,   //1
                     codul_vamalTV, //2
                     den_comeTV,    //3
                     forma_farmaceuticaTV, // forma_farmaceuticaTV
                     doza_concentratiaTV,  // doza_concentratiaTV
                     volumTV, // volumTV
                     divizareaTV, // divizareaTV
                     taraTV, // taraTV
                     producatorulTV, // producatorulTV
                     nr_inregistrareTV, // nr_inregistrareTV
                     data_inregistrariiTV, //data_inregistrariiTV
                     codul_atcTV, // codul_atcTV
                     denumirea_intTV, // denumirea_intTV
                     termen_valabilitateTV, // termen_valabilitateTV
                      codul_cu_bareTV; // codul_cu_bareTV
    //  private FloatingActionButton editFAB;
    private Cl_medicament receivedCl_medicament;
    private Scientist receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        codul_medTV= findViewById(R.id.codul_medTV);
        codul_vamalTV= findViewById(R.id.codul_vamalTV);
        den_comeTV = findViewById(R.id.den_comeTV);
        forma_farmaceuticaTV= findViewById(R.id.forma_farmaceuticaTV);
        doza_concentratiaTV = findViewById(R.id.doza_concentratiaTV);
        volumTV = findViewById(R.id.volumTV);
        divizareaTV = findViewById(R.id.divizareaTV);
        taraTV = findViewById(R.id.taraTV);
        producatorulTV = findViewById(R.id.producatorulTV);
        nr_inregistrareTV = findViewById(R.id.nr_inregistrareTV);
        data_inregistrariiTV = findViewById(R.id.data_inregistrariiTV);
        codul_atcTV = findViewById(R.id.codul_atcTV);
        denumirea_intTV = findViewById(R.id.denumirea_intTV);
        termen_valabilitateTV = findViewById(R.id.termen_valabilitateTV);
        codul_cu_bareTV = findViewById(R.id.codul_cu_bareTV);


//        dobTV= findViewById(R.id.dobTV);
//        diedTV= findViewById(R.id.diedTV);
        //  editFAB=findViewById(R.id.editFAB);

        //	editFAB.setOnClickListener(this);

        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayout_med);
    }

    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_medicament = Utils.receiveCl_medicament(getIntent(), DetailActivity_cl_med.this);

        if(receivedCl_medicament != null){
            codul_medTV.setText(receivedCl_medicament.getCodul_med().trim());
            codul_vamalTV.setText(receivedCl_medicament.getcodul_vamal().trim());
             den_comeTV.setText(receivedCl_medicament.getden_come().trim());
              forma_farmaceuticaTV.setText(receivedCl_medicament.getforma_farmaceutica().trim());
               doza_concentratiaTV.setText(receivedCl_medicament.getdoza_concentratia().trim());
               volumTV.setText(receivedCl_medicament.getvolum().trim());
               divizareaTV.setText(receivedCl_medicament.getdivizarea().trim());
               taraTV.setText(receivedCl_medicament.getTara().trim());
               producatorulTV.setText(receivedCl_medicament.getProducatorul().trim());
               nr_inregistrareTV.setText(receivedCl_medicament.getNr_inregistrare().trim());
               data_inregistrariiTV.setText(receivedCl_medicament.getData_inregistrarii().trim());
               codul_atcTV.setText(receivedCl_medicament.getCodul_atc().trim());
              denumirea_intTV.setText(receivedCl_medicament.getDenumirea_int().trim());
//             termen_valabilitateTV.setText(receivedCl_medicament.getTermen_valabilitate().trim());
//            codul_cu_bareTV.setText(receivedCl_medicament.getCodul_cu_bare().trim());

//             dobTV.setText(receivedScientist.getDob());
//             diedTV.setText(receivedScientist.getDied());

            mCollapsingToolbarLayout.setTitle(receivedCl_medicament.getden_come());
            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                    getColor(R.color.darkRed));
        }
    }
    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu, menu);
        return true;
    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Utils.sendScientistToActivity(this,receivedScientist, help.class);
                finish();
                return true;


            case R.id.action_edit_en:
                Utils.sendScientistToActivity(this,receivedScientist, helpen.class);
                finish();
                return true;

            case R.id.action_edit_ru:
                Utils.sendScientistToActivity(this,receivedScientist, helpru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
//                Utils.sendScientistToActivity(this,receivedScientist,ScientistsActivity.class);
//                finish();
//                return true;

                Intent intent;
                intent = new Intent(this, CL_medicament_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
                return true;


            case R.id.video3:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat ));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * When FAB button is clicked we want to go to the editing page
     */
////    @Override
//    public void onClick(View v) {
//        int id =v.getId();
//        if(id == R.id.editFAB){
//         //   Utils.sendScientistToActivity(this,receivedScientist,CRUDActivity.class);
//
//
//
//
//
//
//
//         //   finish();
//        }
//    }


    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * Let's finish the current activity when back button is pressed
     */
    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, CL_medicament_Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();
//    }
    /**
     * Our onCreate method
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cm_med);

        codul_medTV = findViewById(R.id.codul_medTV);
        codul_vamalTV = findViewById(R.id.codul_vamalTV);
        den_comeTV = findViewById(R.id.den_comeTV);
        forma_farmaceuticaTV= findViewById(R.id.forma_farmaceuticaTV);
        doza_concentratiaTV = findViewById(R.id.doza_concentratiaTV);
        volumTV = findViewById(R.id.volumTV);
        divizareaTV = findViewById(R.id.divizareaTV);
        taraTV = findViewById(R.id.taraTV);
        producatorulTV = findViewById(R.id.producatorulTV);
        nr_inregistrareTV = findViewById(R.id.nr_inregistrareTV);
        data_inregistrariiTV = findViewById(R.id.data_inregistrariiTV);
        codul_atcTV = findViewById(R.id.codul_atcTV);
        denumirea_intTV = findViewById(R.id.denumirea_intTV);
        termen_valabilitateTV = findViewById(R.id.termen_valabilitateTV);
        codul_cu_bareTV = findViewById(R.id.codul_cu_bareTV);

        Button mBtnShare = findViewById(R.id.btnShare);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_codul_medTV = codul_medTV.getText().toString();
                String s_codul_vamalTV = codul_vamalTV.getText().toString();
                String s_den_comeTV = den_comeTV.getText().toString();
                String  s_forma_farmaceuticaTV = forma_farmaceuticaTV.getText().toString();
                String  s_doza_concentratiaTV = doza_concentratiaTV.getText().toString();
                String  s_volumTV = volumTV.getText().toString();
                String  s_divizareaTV = divizareaTV.getText().toString();
                String  s_taraTV = taraTV.getText().toString();
                String  s_producatorulTV = producatorulTV.getText().toString();
                String  s_nr_inregistrareTV = nr_inregistrareTV.getText().toString();
                String  s_data_inregistrariiTV = data_inregistrariiTV.getText().toString();
                String  s_codul_atcTV = codul_atcTV.getText().toString();
                String  s_denumirea_intTV = denumirea_intTV.getText().toString();
                String  s_termen_valabilitateTV = termen_valabilitateTV.getText().toString();
                String  s_codul_cu_bareTV = codul_cu_bareTV.getText().toString();


                String a = " Codul medicamentului  : " + s_codul_medTV + "-   Codul vamal :  "+ s_codul_vamalTV + " - Denumirea comercială :  " +  s_den_comeTV
                        + " -  Forma farmaceutică :  " +  s_forma_farmaceuticaTV + "  - Doza, concentraţia :  " + s_doza_concentratiaTV + " -  Volum :  " + s_volumTV
                        + " - Divizarea :  " + s_divizareaTV +  " -  Ţara :  " +  s_taraTV + " -  Firma producătoare :  " + s_producatorulTV
                        + " - Numărul de înregistrare :  " + s_nr_inregistrareTV  + "  - Data înregistrării :  " +  s_data_inregistrariiTV
                        + " -  Codul ATC :  " +  s_codul_atcTV + " - Denumirea comună internaţională  :  " + s_denumirea_intTV
                        +  " -  Termenul de valabilitate :   " +  s_termen_valabilitateTV  +  " -  Codul cu bare :   " +  s_codul_cu_bareTV
                        ;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia despre medicament");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }



        });




//        nameTV= findViewById(R.id.nameTV);
//        descriptionTV= findViewById(R.id.descriptionTV);
//        galaxyTV= findViewById(R.id.galaxyTV);
//        starTV= findViewById(R.id.starTV);
//        serviciuTV = findViewById(R.id.serviciuTV);
//        sectiaTV = findViewById(R.id.sectiaTV);
//        departTV = findViewById(R.id.departTV);
//        phoneTV = findViewById(R.id.phoneTV);
//        phoneinternalTV = findViewById(R.id.phoneinternalTV);
//        emailTV = findViewById(R.id.emailTV);
//        personalinfoTV = findViewById(R.id.personalinfoTV);
//        formnameTV = findViewById(R.id.formnameTV);
//        phonemobilTV = findViewById(R.id.phonemobilTV);
//        floorTV = findViewById(R.id.floorTV);
//        officeTV = findViewById(R.id.officeTV);
//
//        Button mBtnSend = findViewById(R.id.btnnNtice);
//
//        mBtnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s_nameTV = nameTV.getText().toString();
//                String s_descriptionTV = descriptionTV.getText().toString();
//                String s_floorTV = floorTV.getText().toString();
//                String  s_officeTV = officeTV.getText().toString();
//                String  s_galaxyTV = galaxyTV.getText().toString();
//                String  s_serviciuTV = serviciuTV.getText().toString();
//                String  s_sectiaTV = sectiaTV.getText().toString();
//                String  s_departTV = departTV.getText().toString();
//                String  s_starTV = starTV.getText().toString();
//                String  s_phoneTV = phoneTV.getText().toString();
//                String  s_phonemobilTV = phonemobilTV.getText().toString();
//                String  s_phoneinternalTV = phoneinternalTV.getText().toString();
//                String  s_formnameTV = formnameTV.getText().toString();
//                String  s_emailTV = emailTV.getText().toString();
//
//
//                String a = " Nume, prenume  : " + s_nameTV + "  -   Locația :  "+  s_descriptionTV +  "  - Etajul :   " +  s_floorTV
//                        + "  -  Oficiul :  " +  s_officeTV + "  -  Functia :  " + s_galaxyTV + "  -  Serviciu :   " + s_serviciuTV
//                        + "  -  Sectia :   " + s_sectiaTV +   " -   Directia :   " +  s_departTV + " -   Directia generala :  " + s_starTV
//                        + " -  Telefon fix serviciu :   " + s_phoneTV  + "  -  Telefon mobil serviciu :   " +  s_phonemobilTV
//                        + " -   Telefon intern :  " +  s_phoneinternalTV + " -  Cercetări Statistice  :   " + s_formnameTV
//                        +  "  -  E-mail :   " +  s_emailTV
//                        ;
//
//
//
//
//                String email2 = "vitallybankou@gmail.com";
//                String subject= "The list of contacts of Employer are wrong. Write please,  which of fields is wrong.  ";
//                String contentShare = new String(a);
//                String mailTo = "mailto:" + email2 + //"," + email2 +
//                        "?&subject=" + Uri.encode(subject) +
//                        "&body=" + Uri.encode(contentShare);
//                Intent emailIntent = new Intent(Intent.ACTION_VIEW);
//                emailIntent.setData(Uri.parse(mailTo));
//                startActivity(emailIntent);
//            }
//
//
//
//        });








        initializeWidgets();
        receiveAndShowData();
    }



}
