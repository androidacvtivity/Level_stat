package com.bancusoft.levelstat.Views.med;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Scientist;
import com.bancusoft.levelstat.Views.BaseActivity;

public class help_medicament_en extends BaseActivity{

    private Scientist receivedScientist;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_en_med);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBarn_en_med);

        setSupportActionBar(toolbar);

        //findViewById(R.id.mBackArrowh).setOnClickListener(v -> finish());
        findViewById(R.id.mBackArrowh_en_med_en).setOnClickListener( v -> Utils.showInfoDialog_help_en_med(this,
                "Atenție", "Are you sure you want to go out? There is a translation in the guide for the medicament classifier in English and Russian.") );
    }


    @Override
    public void onBackPressed() {
        Utils.showInfoDialog_help_en_med(this,
                "Atenție", "Are you sure you want to go out? There is a translation in the guide for the medicament classifier in English and Russian.");
        //this.finish();
    }


    /**
     * Let's inflate our menu for the detail page
     */

    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.help_med, menu);
        return true;

    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id==R.id.rolang_med){
            Utils.sendScientistToActivity(this,receivedScientist, help_medicament.class);
            finish();
            return true;

        }
        else

        if (id==R.id.enlang_med){
            Utils.sendScientistToActivity(this,receivedScientist, help_medicament_en.class);
            finish();
            return true;

        }
        else


        if (id==R.id.rulang_med){
            Utils.sendScientistToActivity(this,receivedScientist, help_medicament_ru.class);
            finish();
            return true;

        }
        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this, CL_medicament_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.link1_med) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat));
            startActivity(browserIntent);
            return true;
        }




        return super.onOptionsItemSelected(item);
    }

    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }

}
