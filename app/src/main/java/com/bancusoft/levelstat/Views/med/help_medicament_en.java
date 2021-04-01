package com.bancusoft.levelstat.Views.med;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bancusoft.levelstat.Retrofit.Scientist;
import androidx.appcompat.widget.Toolbar;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Views.BaseActivity;
import com.bancusoft.levelstat.Views.help;
import com.bancusoft.levelstat.Views.helpen;
import com.bancusoft.levelstat.Views.helpru;

public class help_medicament_en extends BaseActivity{

    private Scientist receivedScientist;
    private Toolbar toolbar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_en_med);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBarn_en_med);

        setSupportActionBar(toolbar);

        //findViewById(R.id.mBackArrowh).setOnClickListener(v -> finish());
        findViewById(R.id.mBackArrowh_en_med_en).setOnClickListener( v -> Utils.showInfoDialog_help_en(this,
                "Atenție", "Sunteți sigutri că vreți sa esiți? Exista traducere la indrumar in limba engleza si rusa.") );
    }


    @Override
    public void onBackPressed() {
        Utils.showInfoDialog_help_en(this,
                "Atenție", "Sunteți sigutri că vreți sa esiți? Exista traducere la indrumar in limba engleza si rusa.");
        //this.finish();
    }


    /**
     * Let's inflate our menu for the detail page
     */

    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.help, menu);

        getMenuInflater().inflate(R.menu.help_med, menu);
        return true;

    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rolang_med:
                Utils.sendScientistToActivity(this,receivedScientist, help_medicament.class);
                finish();
                return true;

            case R.id.enlang_med:
                Utils.sendScientistToActivity(this,receivedScientist, help_medicament_en.class);
                finish();
                return true;


            case R.id.rulang_med:
                Utils.sendScientistToActivity(this,receivedScientist, help_medicament_ru.class);
                finish();
                return true;

            case R.id.link1_med:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat ));
                startActivity(browserIntent);
                break;



//            case android.R.id.home:
//
//                Utils.sendScientistToActivity(this,receivedScientist,ScientistsActivity.class);
//                finish();
//                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
