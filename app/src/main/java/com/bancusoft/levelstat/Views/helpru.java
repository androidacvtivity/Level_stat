
package com.bancusoft.levelstat.Views;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bancusoft.levelstat.Retrofit.Scientist;
import androidx.appcompat.widget.Toolbar;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;

public class helpru extends BaseActivity {

    private Scientist receivedScientist;
    @Override
    public  void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_ru);

        Toolbar toolbar = findViewById(R.id.aboutUsToolBarn_ru);
        setSupportActionBar(toolbar);

        //findViewById(R.id.mBackArrowh_ru).setOnClickListener(v -> finish());

        findViewById(R.id.mBackArrowh_ru).setOnClickListener( v -> Utils.showInfoDialog_help_ru(this, "Внимание.", "Вы уверены что хотите выйти? У нас есть перевод руководства о программе на румынском и на английском.") );
    }

    @Override
    public void onBackPressed() {

        Utils.showInfoDialog_help_ru(this, "Внимание.", "Вы уверены что хотите выйти? У нас есть перевод руководства о программе на румынском и на английском.");
    }


    /**
     * Let's inflate our menu for the detail page
     */

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.help, menu);
        return true;

    }



    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id==R.id.rolang){
            Utils.sendScientistToActivity(this,receivedScientist,help.class);
            finish();
            return true;
        }
        else

        if (id==R.id.enlang){
            Utils.sendScientistToActivity(this,receivedScientist,helpen.class);
            finish();
            return true;

        }

        else
        if (id==R.id.rulang){
            Utils.sendScientistToActivity(this,receivedScientist,helpru.class);
            finish();
            return true;
        }


        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this, ScientistsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.link1) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat));

            startActivity(browserIntent);


        }


        return super.onOptionsItemSelected(item);
    }

    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }
}
