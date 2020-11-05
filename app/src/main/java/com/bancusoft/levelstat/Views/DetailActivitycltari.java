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

import com.bancusoft.levelstat.Retrofit.Cl_tari;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class DetailActivitycltari extends AppCompatActivity {

    private TextView CODUL_TV_CL_TARII ,DENUMIRE_TV_CL_TARII;

    private Cl_tari receivedCl_tari;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CL_TARII = findViewById(R.id.CODUL_TV_CL_TARII);
        DENUMIRE_TV_CL_TARII = findViewById(R.id.DENUMIRE_TV_CL_TARII);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayouttari);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_tari  = Utils.receiveCl_tari(getIntent(),DetailActivitycltari.this);

        if(receivedCl_tari != null){
            CODUL_TV_CL_TARII.setText(receivedCl_tari.getCODUL());
            DENUMIRE_TV_CL_TARII.setText(receivedCl_tari.getDENUMIRE());




            mCollapsingToolbarLayout.setTitle(receivedCl_tari.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                    getColor(R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_tari_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_cl_tari:
                Utils.sendCl_tariToActivity(this,receivedCl_tari,help_vw.class);
                finish();
                return true;


            case R.id.action_edit_en_cl_tari:
                Utils.sendCl_tariToActivity(this,receivedCl_tari,help_vw_en.class);
                finish();
                return true;

            case R.id.action_edit_ru_cl_tari:
                Utils.sendCl_tariToActivity(this,receivedCl_tari,help_vw_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                Utils.sendCl_tariToActivity(this,receivedCl_tari,ScientistsActivitycltari.class);
                finish();
                return true;

            case R.id.video3_cl_tari:
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
        intent = new Intent(this, ScientistsActivitycltari.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cl_tari);

        CODUL_TV_CL_TARII = findViewById(R.id.CODUL_TV_CL_TARII);
        DENUMIRE_TV_CL_TARII = findViewById(R.id.DENUMIRE_TV_CL_TARII);


        Button mBtnShare = findViewById(R.id.btnShare_cl_tarii);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_CODUL_TV_CL_TARII = CODUL_TV_CL_TARII.getText().toString();
                String s_DENUMIRE_TV_CL_TARII = DENUMIRE_TV_CL_TARII.getText().toString();




                String a = " Codul Țării : " + s_CODUL_TV_CL_TARII + " - Denumirea , \n" +
                        "  :  " + s_DENUMIRE_TV_CL_TARII;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Clasificatorul internaţional al ţărilor lumii şi teritoriilor, care se utilizează la\n" +
                        "completarea rapoartelor statistice privind exportul şi importul de servicii.");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
