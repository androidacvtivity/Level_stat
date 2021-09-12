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
import com.bancusoft.levelstat.Retrofit.Cl_caem;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityclcaem extends AppCompatActivity {

    //Let's define our instance fields
    private TextView CODUL_TV_CAEM ,DENUMIRE_TV_caem;

    private Cl_caem receivedCl_caem;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CAEM = findViewById(R.id.CODUL_TV_CAEM);
        DENUMIRE_TV_caem = findViewById(R.id.DENUMIRE_TV_caem);



        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutclcaem);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_caem  = Utils.receiveCl_caem(getIntent(),DetailActivityclcaem.this);

        if(receivedCl_caem != null){
            CODUL_TV_CAEM.setText(receivedCl_caem.getCODUL());
            DENUMIRE_TV_caem.setText(receivedCl_caem.getDENUMIRE());




            mCollapsingToolbarLayout.setTitle(receivedCl_caem.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_caem_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        int id = item.getItemId();

        if (id==R.id.action_edit_caem){
            Utils.sendCl_caemToActivity(this,receivedCl_caem,help_vw.class);
                finish();
                return true;

        }
        else

        if (id==R.id.action_edit_en_caem){
            Utils.sendCl_caemToActivity(this,receivedCl_caem,help_vw_en.class);
                finish();
                return true;

        }
        else


        if (id==R.id.action_edit_ru_caem){
            Utils.sendCl_caemToActivity(this,receivedCl_caem,help_vw_ru.class);
                finish();
                return true;

        }
        else


        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,ScientistsActivitycucaem.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }


        else
        if (id == R.id.video3_caem){

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
        intent = new Intent(this, ScientistsActivityclcaem.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cl_caem);

        CODUL_TV_CAEM = findViewById(R.id.CODUL_TV_CAEM);
        DENUMIRE_TV_caem = findViewById(R.id.DENUMIRE_TV_caem);


        Button mBtnShare = findViewById(R.id.btnShare_caem);

        mBtnShare.setOnClickListener(view -> {
            String s_CODUL_TV_CAEM = CODUL_TV_CAEM.getText().toString();
            String s_DENUMIRE_TV_caem = DENUMIRE_TV_caem.getText().toString();


            String contentShare = " Codul CAEM : " + s_CODUL_TV_CAEM + " - Denumirea activitatii, \n" +
                    "  :  " + s_DENUMIRE_TV_caem;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "CLASIFICATORUL ACTIVITĂŢILOR \n" +
                    "DIN ECONOMIA MOLDOVEI \n" +
                    "(CAEM)\n");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
