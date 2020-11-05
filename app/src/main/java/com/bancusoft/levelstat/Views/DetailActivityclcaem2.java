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
import com.bancusoft.levelstat.Retrofit.Cl_caem2;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
public class DetailActivityclcaem2 extends AppCompatActivity {

    //Let's define our instance fields
    private TextView CODUL_TV_CAEM2 ,DENUMIRE_TV_caem2,act_TV_prim;

    private Cl_caem2 receivedCl_caem2;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CAEM2= findViewById(R.id.CODUL_TV_CAEM2);
        DENUMIRE_TV_caem2= findViewById(R.id.DENUMIRE_TV_caem2);
        act_TV_prim= findViewById(R.id.act_TV_prim);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcaem2);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_caem2 = Utils.receiveCl_caem2(getIntent(),DetailActivityclcaem2.this);

        if(receivedCl_caem2 != null){
            CODUL_TV_CAEM2.setText(receivedCl_caem2.getCODUL());
            DENUMIRE_TV_caem2.setText(receivedCl_caem2.getDENUMIRE());
            act_TV_prim.setText(receivedCl_caem2.getPRIM());



            mCollapsingToolbarLayout.setTitle(receivedCl_caem2.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                    getColor(R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_caem2_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_caem2:
                Utils.sendCl_caem2ToActivity(this,receivedCl_caem2,help_vw.class);
                finish();
                return true;


            case R.id.action_edit_en_caem2:
                Utils.sendCl_caem2ToActivity(this,receivedCl_caem2,help_vw_en.class);
                finish();
                return true;

            case R.id.action_edit_ru_caem2:
                Utils.sendCl_caem2ToActivity(this,receivedCl_caem2,help_vw_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                Utils.sendCl_caem2ToActivity(this,receivedCl_caem2,ScientistsActivitycuatm.class);
                finish();
                return true;

            case R.id.video3_caem:
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
        intent = new Intent(this, ScientistsActivityclcaem2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cl_caem2);

        CODUL_TV_CAEM2 = findViewById(R.id.CODUL_TV_CAEM2);
        DENUMIRE_TV_caem2 = findViewById(R.id.DENUMIRE_TV_caem2);
        act_TV_prim = findViewById(R.id.act_TV_prim);

        Button mBtnShare = findViewById(R.id.btnShare_caem2);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_CODUL_TV_CAEM2 = CODUL_TV_CAEM2.getText().toString();
                String s_DENUMIRE_TV_caem2 = DENUMIRE_TV_caem2.getText().toString();
                String s_act_TV_prim = act_TV_prim.getText().toString();



                String a = " Codul CAEM2 : " + s_CODUL_TV_CAEM2 + " - Denumirea activitatii, \n" +
                        "  :  " + s_DENUMIRE_TV_caem2 + " Statutul " + s_act_TV_prim;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "CLASIFICATORUL ACTIVITĂŢILOR \n" +
                        "DIN ECONOMIA MOLDOVEI \n" +
                        "(CAEM-2)\n");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }
}
