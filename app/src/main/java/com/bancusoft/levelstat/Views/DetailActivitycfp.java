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

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;

import com.bancusoft.levelstat.Retrofit.Scientistscfp;


import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivitycfp extends AppCompatActivity {


    //Let's define our instance fields
    private TextView DENUMIRE_TV_cfp,VALUE_TV_cfp,act_TV_cfp;

    private Scientistscfp receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        DENUMIRE_TV_cfp= findViewById(R.id.DENUMIRE_TV_cfp);
        VALUE_TV_cfp= findViewById(R.id.VALUE_TV_cfp);
        act_TV_cfp= findViewById(R.id.act_TV_cfp);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcfp);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedScientist = Utils.receiveScientistscfp(getIntent(),DetailActivitycfp.this);

        if(receivedScientist != null){
            DENUMIRE_TV_cfp.setText(receivedScientist.getDENUMIRE());
            VALUE_TV_cfp.setText(receivedScientist.getVALUE());
            act_TV_cfp.setText(receivedScientist.getAct());



            mCollapsingToolbarLayout.setTitle(receivedScientist.getVALUE());

            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                    getColor(R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_cfp, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_cfp:
                Utils.sendScientistscfpToActivity(this,receivedScientist,help_vw.class);
                finish();
                return true;


            case R.id.action_edit_en_cfp:
                Utils.sendScientistscfpToActivity(this,receivedScientist,help_vw_en.class);
                finish();
                return true;

            case R.id.action_edit_ru_cfp:
                Utils.sendScientistscfpToActivity(this,receivedScientist,help_vw_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                Utils.sendScientistscfpToActivity(this,receivedScientist,ScientistsActivitycfp.class);
                finish();
                return true;

            case R.id.video3_cfp:
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
        intent = new Intent(this, ScientistsActivitycfp.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cfp);

        DENUMIRE_TV_cfp= findViewById(R.id.DENUMIRE_TV_cfp);
        VALUE_TV_cfp= findViewById(R.id.VALUE_TV_cfp);
        act_TV_cfp= findViewById(R.id.act_TV_cfp);

        Button mBtnShare = findViewById(R.id.btnShare_cfp);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_DENUMIRE_TV_cfp = DENUMIRE_TV_cfp.getText().toString();
                String s_VALUE_TV_cfp = VALUE_TV_cfp.getText().toString();
                String s_act_TV_cfp = act_TV_cfp.getText().toString();



                String a = "Forma organizatorico-juridică: " + s_DENUMIRE_TV_cfp + " - Număr (care au codul IDNO) :  "+ s_VALUE_TV_cfp + "  Actualizarea  " + s_act_TV_cfp;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Informatia deschisa  după forma juridică de organizare");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
