package com.bancusoft.levelstat.Views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bancusoft.levelstat.Retrofit.Scientistvw;
import androidx.appcompat.widget.Toolbar;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
public class help_vw_ru extends BaseActivity{


    private Scientistvw receivedScientist;
    @Override
    public  void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_ruvw);

        Toolbar toolbar = findViewById(R.id.aboutUsToolBarn_ru_vw);
        setSupportActionBar(toolbar);

        //findViewById(R.id.mBackArrowh_ru).setOnClickListener(v -> finish());

        findViewById(R.id.mBackArrowh_ru).setOnClickListener( v -> Utils.showInfoDialog_help_ru_vw(this, "Внимание.", "Вы уверены что хотите выйти? У нас есть перевод руководства о программе на румынском и на английском.") );
    }




    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();

        Utils.showInfoDialog_help_ru_vw(this, "Внимание.", "Вы уверены что хотите выйти? У нас есть перевод руководства о программе на румынском и на английском.");
    }


    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.help, menu);

        getMenuInflater().inflate(R.menu.helpvw, menu);
        return true;

    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rolang_vw:
                Utils.sendScientistvwToActivity(this, receivedScientist, help_vw.class);
                finish();
                return true;

            case R.id.enlang_vw:
                Utils.sendScientistvwToActivity(this, receivedScientist, help_vw_en.class);
                finish();
                return true;


            case R.id.rulang_vw:
                Utils.sendScientistvwToActivity(this, receivedScientist, help_vw_ru.class);
                finish();
                return true;


            case R.id.link1_vw:
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
