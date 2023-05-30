package com.bancusoft.levelstat.Views;

import android.content.Context;
import android.os.Bundle;

import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Views.med.CL_medicament_Activity;
import com.bancusoft.levelstat.Views.med.help_medicament;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DashboardActivity extends AppCompatActivity {

    //We have more cards in the dashboard
    LinearLayout viewScientistsCard;
    LinearLayout third1;
    LinearLayout third;
    LinearLayout closeCard;
    LinearLayout ScientistsCard;
    LinearLayout layout_help;
    LinearLayout layout_viewCUATM;
    LinearLayout layout_cam;
    LinearLayout layout_cfp_next;
    LinearLayout layout_cut_next;
    LinearLayout layout_cam2;
    LinearLayout cam_cl;
    LinearLayout layout_foj;
    LinearLayout layout_cl_cfp;
    LinearLayout layout_cl_coco;
    LinearLayout layout_cl_service;
    LinearLayout layout_cl_taro;
    LinearLayout layout_cl_prodded;
    LinearLayout layout_view_structure;
    LinearLayout layout_view_cl_med;
    LinearLayout help_cl_med;

    /**
     * Let's initialize our cards  and listen to their click events
     */
    private void initializeWidgets(){
        viewScientistsCard = findViewById(R.id.viewScientistsCard);
        third1 = findViewById(R.id.third);
        third = findViewById(R.id.help);
        closeCard = findViewById(R.id.closeCard);
        ScientistsCard = findViewById(R.id.viewScientistsvwCard);
        layout_help = findViewById(R.id.helpvw);
        layout_viewCUATM = findViewById(R.id.viewCUATM);
        layout_cam = findViewById(R.id.caem);
        layout_cfp_next = findViewById(R.id.cfp);
        layout_cut_next = findViewById(R.id.cuatm_next);
        layout_cam2 = findViewById(R.id.caem2);
        cam_cl = findViewById(R.id.cl_caem);
        layout_foj = findViewById(R.id.cl_cfoj);
        layout_cl_cfp = findViewById(R.id.cl_cfp);
        layout_cl_coco = findViewById(R.id.cl_cocm);
        layout_cl_service = findViewById(R.id.cl_servicii);
        layout_cl_taro =   findViewById(R.id.cl_tari);
        layout_cl_prodded =   findViewById(R.id.cl_prodmild);
        layout_view_structure = findViewById(R.id.view_structura);
        layout_view_cl_med = findViewById(R.id.view_list_of_med);
        help_cl_med = findViewById(R.id.help_cl_med);




help_cl_med.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this, help_medicament.class));




        layout_view_cl_med.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this, CL_medicament_Activity.class));

        layout_view_structure.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,structurabns.class));

        layout_cl_prodded.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclprodmold.class));


        layout_cl_taro.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivitycltari.class));


        layout_cl_service.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclservicii.class));


        layout_cl_coco.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclcocm.class));


        layout_cl_cfp.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclcfp.class));



        layout_foj.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclcfoj.class));


        cam_cl.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclcaem.class));



        layout_cam2.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityclcaem2.class));

        layout_cut_next.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivitycuatm.class));


        layout_cfp_next.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivitycfp.class));





        layout_cam.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivitycucaem.class));




		viewScientistsCard.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivity.class));




        layout_viewCUATM.setOnClickListener(v -> {
            Utils.openActivity(DashboardActivity.this,ScientistsActivitycu.class);
          //  Utils.openActivity(DashboardActivity.this,ScientistsActivity_digit.class);

        });



        ScientistsCard.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,ScientistsActivityvw.class));

        third1.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,AboutUsActivity_test.class));

        layout_help.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,help_vw.class));

        third.setOnClickListener(v -> Utils.openActivity(DashboardActivity.this,help.class));



        closeCard.setOnClickListener(v -> finish());
    }
    /**
     * Let's override the attachBaseContext() method
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * When the back button is pressed finish this activity
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    /**
     * Let's override the onCreate() and call our initializeWidgets()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.initializeWidgets();
    }
}
//end


