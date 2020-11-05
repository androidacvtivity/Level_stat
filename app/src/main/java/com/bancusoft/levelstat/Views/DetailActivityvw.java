package com.bancusoft.levelstat.Views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Scientistvw;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityvw extends AppCompatActivity  {

    //Let's define our instance fields
    private TextView DEN_COM_VW_TV,IDNO_VW_TV,ADRESA_VW_TV,FORMA_ORG_VW_TV,LIST_COND_VW_TV, LISTA_FOND_VW_TV, GEN_ACT_NE_LIC_VW_TV, GEN_ACT_LIC_VW_TV,
            STATUTUL_VW_TV, DATA_REG_VW_TV, act_TV;

    //  private FloatingActionButton editFAB;
    private Scientistvw receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayoutvw;

    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        DEN_COM_VW_TV= findViewById(R.id.DEN_COM_VW_TV);
        IDNO_VW_TV= findViewById(R.id.IDNO_VW_TV);
        ADRESA_VW_TV= findViewById(R.id.ADRESA_VW_TV);
        FORMA_ORG_VW_TV= findViewById(R.id.FORMA_ORG_VW_TV);
        LIST_COND_VW_TV = findViewById(R.id.LIST_COND_VW_TV);
        LISTA_FOND_VW_TV = findViewById(R.id.LISTA_FOND_VW_TV);
        GEN_ACT_NE_LIC_VW_TV = findViewById(R.id.GEN_ACT_NE_LIC_VW_TV);
        GEN_ACT_LIC_VW_TV = findViewById(R.id.GEN_ACT_LIC_VW_TV);
        STATUTUL_VW_TV = findViewById(R.id.STATUTUL_VW_TV);
        DATA_REG_VW_TV = findViewById(R.id.DATA_REG_VW_TV);
        act_TV = findViewById(R.id.act_TV);



//        dobTV= findViewById(R.id.dobTV);
//        diedTV= findViewById(R.id.diedTV);
        //  editFAB=findViewById(R.id.editFAB);

        //	editFAB.setOnClickListener(this);

        mCollapsingToolbarLayoutvw=findViewById(R.id.mCollapsingToolbarLayoutvw);
    }

    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedScientist = Utils.receiveScientistvw(getIntent(),DetailActivityvw.this);

        if(receivedScientist != null){
            DEN_COM_VW_TV.setText(receivedScientist.getDEN_COM_VW().trim());
            IDNO_VW_TV.setText(receivedScientist.getIDNO_VW().trim());
            ADRESA_VW_TV.setText(receivedScientist.getADRESA_VW().trim());
            FORMA_ORG_VW_TV.setText(receivedScientist.getFORMA_ORG_VW().trim());
            LIST_COND_VW_TV.setText(receivedScientist.getLIST_COND_VW().trim());
            LISTA_FOND_VW_TV.setText(receivedScientist.getLISTA_FOND_VW().trim());
            GEN_ACT_NE_LIC_VW_TV.setText(receivedScientist.getGEN_ACT_NE_LIC_VW().trim());
            GEN_ACT_LIC_VW_TV.setText(receivedScientist.getGEN_ACT_LIC_VW().trim());
            STATUTUL_VW_TV.setText(receivedScientist.getSTATUTUL_VW().trim());
            DATA_REG_VW_TV.setText(receivedScientist.getDATA_REG_VWW().trim());
            act_TV.setText(receivedScientist.getAct().trim().toUpperCase());



//             dobTV.setText(receivedScientist.getDob());
//             diedTV.setText(receivedScientist.getDied());

            mCollapsingToolbarLayoutvw.setTitle(receivedScientist.getIDNO_VW());
            mCollapsingToolbarLayoutvw.setExpandedTitleColor(getResources().
                    getColor(R.color.white));
        }
    }
    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_vw, menu);
        return true;
    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_vw:
                Utils.sendScientistvwToActivity(this,receivedScientist,help_vw.class);
                finish();
                return true;


            case R.id.action_edit_en_vw:
                Utils.sendScientistvwToActivity(this,receivedScientist,help_vw_en.class);
                finish();
                return true;

            case R.id.action_edit_ru_vw:
                Utils.sendScientistvwToActivity(this,receivedScientist,help_vw_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
//                Utils.sendScientistvwToActivity(this,receivedScientist,ScientistsActivityvw.class);
//                finish();


                Intent intent;
                intent = new Intent(this, ScientistsActivityvw.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
                return true;

            case R.id.video3_vw:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat ));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * When FAB button is clicked we want to go to the editing page
     */
//    @Override
//    public void onClick(View v) {
//        int id =v.getId();
//        if(id == R.id.editFAB){
//            Utils.sendScientistToActivity(this,receivedScientist,CRUDActivity.class);
//            finish();
//        }
//    }
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
        intent = new Intent(this, ScientistsActivityvw.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();
//    }
    /**
     * Our onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvw);

        DEN_COM_VW_TV= findViewById(R.id.DEN_COM_VW_TV);
        IDNO_VW_TV= findViewById(R.id.IDNO_VW_TV);
        ADRESA_VW_TV= findViewById(R.id.ADRESA_VW_TV);
        FORMA_ORG_VW_TV= findViewById(R.id.FORMA_ORG_VW_TV);
        LIST_COND_VW_TV = findViewById(R.id.LIST_COND_VW_TV);
        LISTA_FOND_VW_TV = findViewById(R.id.LISTA_FOND_VW_TV);
        GEN_ACT_NE_LIC_VW_TV = findViewById(R.id.GEN_ACT_NE_LIC_VW_TV);
        GEN_ACT_LIC_VW_TV = findViewById(R.id.GEN_ACT_LIC_VW_TV);
        STATUTUL_VW_TV = findViewById(R.id.STATUTUL_VW_TV);
        DATA_REG_VW_TV = findViewById(R.id.DATA_REG_VW_TV);
        act_TV = findViewById(R.id.act_TV);

        Button mBtnShare = findViewById(R.id.btnShare_vw);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_DEN_COM_VW_TV = DEN_COM_VW_TV.getText().toString();
                String s_IDNO_VW_TV = IDNO_VW_TV.getText().toString();
                String s_ADRESA_VW_TV = ADRESA_VW_TV.getText().toString();
                String  s_FORMA_ORG_VW_TV = FORMA_ORG_VW_TV.getText().toString();
                String  s_LIST_COND_VW_TV = LIST_COND_VW_TV.getText().toString();
                String  s_LISTA_FOND_VW_TV = LISTA_FOND_VW_TV.getText().toString();
                String  s_GEN_ACT_NE_LIC_VW_TV = GEN_ACT_NE_LIC_VW_TV.getText().toString();
                String  s_GEN_ACT_LIC_VW_TVV = GEN_ACT_LIC_VW_TV.getText().toString();
                String  s_STATUTUL_VW_TV = STATUTUL_VW_TV.getText().toString();
                String  s_DATA_REG_VW_TV = DATA_REG_VW_TV.getText().toString();
                String  s_act_TV = act_TV.getText().toString();

//                String  s_phonemobilTV = phonemobilTV.getText().toString();
//                String  s_phoneinternalTV = phoneinternalTV.getText().toString();
//                String  s_formnameTV = formnameTV.getText().toString();
//                String  s_emailTV = emailTV.getText().toString();


                String a = " IDNO / Cod fiscal : " + s_IDNO_VW_TV + "-   Data înregistrării :  "+ s_DATA_REG_VW_TV + " - Forma org./jurid. :  " +  s_FORMA_ORG_VW_TV
                        + " -  Adresa :  " +  s_ADRESA_VW_TV + "  - Lista conducătorilor  :  " + s_LIST_COND_VW_TV + " -  Lista fondatorilor (cota parte în capitalul social %) :  " + s_LISTA_FOND_VW_TV
                        + " -  : Genuri de activitate nelicentiate " + s_GEN_ACT_NE_LIC_VW_TV +  " -  Genuri de activitate licentiate :  " +  s_GEN_ACT_LIC_VW_TVV + " -  Statutul :  " + s_STATUTUL_VW_TV
                        + " - Ultima actualizare" + s_act_TV
                        ;


                String contentShare = new String(a);

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Informatia deschisa  despre Unitatea de drept");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, contentShare);

                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }

}
//end
