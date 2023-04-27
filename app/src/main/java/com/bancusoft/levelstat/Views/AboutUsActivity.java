package com.bancusoft.levelstat.Views;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Scientist;

public class AboutUsActivity extends AppCompatActivity {

    private  Scientist receivedScientist;

    public void openEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:vitale.bancu@statistica.gov.md"));
        startActivity(intent);
    }

    public void onCallTextivewClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+37367770604"));
        startActivity(intent);
    }



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrow).setOnClickListener(v -> finish());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_dgti, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.action_dgti){
            Utils.sendScientistToActivity(this, receivedScientist, ScientistsActivity_dgti.class);
                finish();
                return true;

        }

        else
        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }



        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }


}
