package com.bancusoft.levelstat.Views;


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



import com.bancusoft.levelstat.Retrofit.Cl_servicii;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityclservicii extends AppCompatActivity{

    private TextView CODUL_TV_CSPM, DENUMIRE_TV_CSPM;

    private Cl_servicii receivedCl_servicii;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CSPM = findViewById(R.id.CODUL_TV_CSPM);
        DENUMIRE_TV_CSPM = findViewById(R.id.DENUMIRE_TV_CSPM);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcspm);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_servicii  = Utils.receiveCl_servicii(getIntent(),DetailActivityclservicii.this);

        if(receivedCl_servicii != null){
            CODUL_TV_CSPM.setText(receivedCl_servicii.getCODUL());
            DENUMIRE_TV_CSPM.setText(receivedCl_servicii.getDENUMIRE());




            mCollapsingToolbarLayout.setTitle(receivedCl_servicii.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                    getColor(R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_servicii_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_cl_servicii:
                Utils.sendCl_serviciiToActivity(this,receivedCl_servicii,help_vw.class);
                finish();
                return true;


            case R.id.action_edit_en_cl_servicii:
                Utils.sendCl_serviciiToActivity(this,receivedCl_servicii,help_vw_en.class);
                finish();
                return true;

            case R.id.action_edit_ru_cl_servicii:
                Utils.sendCl_serviciiToActivity(this,receivedCl_servicii,help_vw_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                Utils.sendCl_serviciiToActivity(this,receivedCl_servicii,ScientistsActivityclservicii.class);
                finish();
                return true;

            case R.id.video3_cl_servicii:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat ));
                startActivity(browserIntent);
                break;
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
        intent = new Intent(this, ScientistsActivityclservicii.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cspm);

        CODUL_TV_CSPM = findViewById(R.id.CODUL_TV_CSPM);
        DENUMIRE_TV_CSPM = findViewById(R.id.DENUMIRE_TV_CSPM);


        Button mBtnShare = findViewById(R.id.btnShare_cspm);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_CODUL_TV_CSPM = CODUL_TV_CSPM.getText().toString();
                String s_DENUMIRE_TV_CSPM = DENUMIRE_TV_CSPM.getText().toString();




                String a = " Codul servicii : " + s_CODUL_TV_CSPM + " - Denumirea codului, \n" +
                        "  :  " + s_DENUMIRE_TV_CSPM;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Clasificatorul serviciilor în domeniul activităţii economice externe");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
