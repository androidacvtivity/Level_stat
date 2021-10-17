package com.bancusoft.levelstat.Views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Cl_cuatm_all;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivitycuatm extends AppCompatActivity {

    //Let's define our instance fields
    private TextView CODUL_TV_CUATM ,DENUMIRE_TV_cuatm,act_TV_cuatm;

    private Cl_cuatm_all receivedCl_cuatm_all;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CUATM= findViewById(R.id.CODUL_TV_CUATM);
        DENUMIRE_TV_cuatm= findViewById(R.id.DENUMIRE_TV_cuatm);
        act_TV_cuatm= findViewById(R.id.act_TV_cuatm);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcuatm);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_cuatm_all = Utils.receiveCl_cuatm_all(getIntent(),DetailActivitycuatm.this);

        if(receivedCl_cuatm_all != null){
            CODUL_TV_CUATM.setText(receivedCl_cuatm_all.getCODUL());
            DENUMIRE_TV_cuatm.setText(receivedCl_cuatm_all.getDENUMIRE());
            act_TV_cuatm.setText(receivedCl_cuatm_all.getPrgs());



            mCollapsingToolbarLayout.setTitle(receivedCl_cuatm_all.getCODUL());



            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_cuatm, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id==R.id.action_edit_cuatm){
            Utils.sendCl_cuatm_allToActivity(this,receivedCl_cuatm_all,help_vw.class);
            finish();
            return true;

        }
        else

        if (id==R.id.action_edit_en_cuatm){
            Utils.sendCl_cuatm_allToActivity(this,receivedCl_cuatm_all,help_vw_en.class);
            finish();
            return true;

        }
        else


        if (id==R.id.action_edit_ru_cuatm){
            Utils.sendCl_cuatm_allToActivity(this,receivedCl_cuatm_all,help_vw_ru.class);
            finish();
            return true;

        }
        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,ScientistsActivitycuatm.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video3_cuatm) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat));
            startActivity(browserIntent);
            return true;
        }




        return super.onOptionsItemSelected(item);
    }



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
        intent = new Intent(this, ScientistsActivitycuatm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cl_cuatm);

        CODUL_TV_CUATM= findViewById(R.id.CODUL_TV_CUATM);
        DENUMIRE_TV_cuatm= findViewById(R.id.DENUMIRE_TV_cuatm);
        act_TV_cuatm= findViewById(R.id.act_TV_cuatm);

        Button mBtnShare = findViewById(R.id.btnShare_cuatm);

        mBtnShare.setOnClickListener(view -> {
            String s_CODUL_TV_CUATM = CODUL_TV_CUATM.getText().toString();
            String s_DENUMIRE_TV_cuatm = DENUMIRE_TV_cuatm.getText().toString();
            String s_act_TV_cuatm = act_TV_cuatm.getText().toString();


            String contentShare = " Codul statistic: " + s_CODUL_TV_CUATM + "- Denumirea oraşelor (municipiilor), \n" +
                    "satelor (comunelor) :  "+ s_DENUMIRE_TV_cuatm + "Statutul " + s_act_TV_cuatm;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia deschisa  după CLASIFICATORUL  UNITĂŢILOR ADMINISTRATIV-TERITORIALE AL  REPUBLICII  MOLDOVA (CUATM)");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
