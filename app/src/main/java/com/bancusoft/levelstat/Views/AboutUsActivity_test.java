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

public class AboutUsActivity_test extends AppCompatActivity {

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
        setContentView(R.layout.activity_about_us_test);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrow).setOnClickListener(v -> finish());

    }



    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }


}
