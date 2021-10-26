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
import com.bancusoft.levelstat.Retrofit.Scientistscu;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivitycu extends AppCompatActivity {

    //Let's define our instance fields
    private TextView DEN_CUATM_TV,NUMBER_CUATM_TV,source_TV;

    private Scientistscu receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        DEN_CUATM_TV= findViewById(R.id.DEN_CUATM_TV);
        NUMBER_CUATM_TV= findViewById(R.id.NUMBER_CUATM_TV);
        source_TV= findViewById(R.id.source_TV);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcu);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedScientist = Utils.receiveScientistscu(getIntent(),DetailActivitycu.this);

        if(receivedScientist != null){
            DEN_CUATM_TV.setText(receivedScientist.getDEN_CUATM());
            NUMBER_CUATM_TV.setText(receivedScientist.getNUMBER_CUATM());
            source_TV.setText(receivedScientist.getSource());



            mCollapsingToolbarLayout.setTitle(receivedScientist.getNUMBER_CUATM());

            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));




        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_cu, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id==R.id.action_edit_cu){
            Utils.sendScientistscuToActivity(this,receivedScientist,help_vw.class);
            finish();
            return true;

        }
        else

        if (id==R.id.action_edit_en_cu){
            Utils.sendScientistscuToActivity(this,receivedScientist,help_vw_en.class);
            finish();
            return true;

        }
        else


        if (id==R.id.action_edit_ru_cu){
            Utils.sendScientistscuToActivity(this,receivedScientist,help_vw_ru.class);
            finish();
            return true;

        }
        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,ScientistsActivitycu.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video3_cu) {

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
        intent = new Intent(this, ScientistsActivitycu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cu);

        DEN_CUATM_TV= findViewById(R.id.DEN_CUATM_TV);
        NUMBER_CUATM_TV= findViewById(R.id.NUMBER_CUATM_TV);
        source_TV= findViewById(R.id.source_TV);

        Button mBtnShare = findViewById(R.id.btnShare_cu);

        mBtnShare.setOnClickListener(view -> {
            String s_DEN_CUATM_TV = DEN_CUATM_TV.getText().toString();
            String s_NUMBER_CUATM_TV = NUMBER_CUATM_TV.getText().toString();
            String s_source_TV = source_TV.getText().toString();


            String contentShare = " Municipiu   raion : " + s_DEN_CUATM_TV + " - Număr (care au codul IDNO) :  "+ s_NUMBER_CUATM_TV + " Actualizarea " + s_source_TV;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia deschisa  despre Municipiu / raion");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
