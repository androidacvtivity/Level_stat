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



import com.bancusoft.levelstat.Retrofit.Cl_cocm;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityclcocm extends AppCompatActivity {


    private TextView CODUL_TV_COCM ,DENUMIRE_TV_COCM;

    private Cl_cocm receivedCl_cocm;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_COCM = findViewById(R.id.CODUL_TV_COCM);
        DENUMIRE_TV_COCM = findViewById(R.id.DENUMIRE_TV_COCM);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcocm);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_cocm  = Utils.receiveCl_cocm(getIntent(),DetailActivityclcocm.this);

        if(receivedCl_cocm != null){
            CODUL_TV_COCM.setText(receivedCl_cocm.getCODUL());
            DENUMIRE_TV_COCM.setText(receivedCl_cocm.getDENUMIRE());




            mCollapsingToolbarLayout.setTitle(receivedCl_cocm.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                    getColor(R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_cocm_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_cl_cocm:
                Utils.sendCl_cocmToActivity(this,receivedCl_cocm,help_vw.class);
                finish();
                return true;


            case R.id.action_edit_en_cl_cocm:
                Utils.sendCl_cocmToActivity(this,receivedCl_cocm,help_vw_en.class);
                finish();
                return true;

            case R.id.action_edit_ru_cl_cocm:
                Utils.sendCl_cocmToActivity(this,receivedCl_cocm,help_vw_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                Utils.sendCl_cocmToActivity(this,receivedCl_cocm,ScientistsActivityclcocm.class);
                finish();
                return true;

            case R.id.video3_cl_cocm:
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
        intent = new Intent(this, ScientistsActivityclcocm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cocm);

        CODUL_TV_COCM = findViewById(R.id.CODUL_TV_COCM);
        DENUMIRE_TV_COCM = findViewById(R.id.DENUMIRE_TV_COCM);


        Button mBtnShare = findViewById(R.id.btnShare_cocm);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_CODUL_TV_COCM = CODUL_TV_COCM.getText().toString();
                String s_DENUMIRE_TV_COCM = DENUMIRE_TV_COCM.getText().toString();




                String a = " Codul COCM : " + s_CODUL_TV_COCM + " - Denumirea COCM, \n" +
                        "  :  " + s_DENUMIRE_TV_COCM;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Clasificatorul Organelor de Conducere al Republicii Moldova (COCM).");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
