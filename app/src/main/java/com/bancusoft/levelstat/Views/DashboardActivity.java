package com.bancusoft.levelstat.Views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DashboardActivity extends AppCompatActivity {

    //We have more cards in the dashboard
    LinearLayout viewScientistsCard;
    LinearLayout third1;
    LinearLayout third;
    LinearLayout closeCard;
    LinearLayout viewScientistsvwCard;
    LinearLayout layout_helpvw;
    LinearLayout layout_viewCUATM;
    LinearLayout layout_caem;
    LinearLayout layout_cfp_next;
    LinearLayout layout_cuatm_next;
    LinearLayout layout_caem2;
    LinearLayout caem_cl;
    LinearLayout layout_cl_cfoj;
    LinearLayout layout_cl_cfp;
    LinearLayout layout_cl_cocm;
    LinearLayout layout_cl_servicii;
    LinearLayout layout_cl_tari;
    LinearLayout layout_cl_prodmild;
    LinearLayout layout_view_structura;

    /**
     * Let's initialize our cards  and listen to their click events
     */
    private void initializeWidgets(){
        viewScientistsCard = findViewById(R.id.viewScientistsCard);
        third1 = findViewById(R.id.third);
        third = findViewById(R.id.help);
        closeCard = findViewById(R.id.closeCard);
        viewScientistsvwCard = findViewById(R.id.viewScientistsvwCard);
        layout_helpvw = findViewById(R.id.helpvw);
        layout_viewCUATM = findViewById(R.id.viewCUATM);
        layout_caem  = findViewById(R.id.caem);
        layout_cfp_next = findViewById(R.id.cfp);
        layout_cuatm_next = findViewById(R.id.cuatm_next);
        layout_caem2 = findViewById(R.id.caem2);
        caem_cl = findViewById(R.id.cl_caem);
        layout_cl_cfoj = findViewById(R.id.cl_cfoj);
        layout_cl_cfp = findViewById(R.id.cl_cfp);
        layout_cl_cocm = findViewById(R.id.cl_cocm);
        layout_cl_servicii = findViewById(R.id.cl_servicii);
        layout_cl_tari =   findViewById(R.id.cl_tari);
        layout_cl_prodmild   =   findViewById(R.id.cl_prodmild);
        layout_view_structura = findViewById(R.id.view_structura);


        layout_view_structura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,structurabns.class);

            }
        });

        layout_cl_prodmild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclprodmold.class);

            }
        });


        layout_cl_tari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivitycltari.class);

            }
        });


        layout_cl_servicii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclservicii.class);

            }
        });


        layout_cl_cocm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclcocm.class);

            }
        });


        layout_cl_cfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclcfp.class);

            }
        });



        layout_cl_cfoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclcfoj.class);

            }
        });


        caem_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclcaem.class);

            }
        });



        layout_caem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityclcaem2.class);

            }
        });

        layout_cuatm_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivitycuatm.class);

            }
        });


        layout_cfp_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivitycfp.class);

            }
        });





        layout_caem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivitycucaem.class);

            }
        });




		viewScientistsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				Utils.openActivity(DashboardActivity.this,ScientistsActivity.class);

            }
        });




        layout_viewCUATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivitycu.class);
              //  Utils.openActivity(DashboardActivity.this,ScientistsActivity_dgti.class);

            }
        });



        viewScientistsvwCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,ScientistsActivityvw.class);

            }
        });

        third1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openActivity(DashboardActivity.this,AboutUsActivity.class);

            }
        });

        layout_helpvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utils.openActivity(DashboardActivity.this,help_vw.class);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utils.openActivity(DashboardActivity.this,help.class);
            }
        });
        closeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				finish();

            }
        });
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


