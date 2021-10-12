package com.bancusoft.levelstat.Views;
import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.levelstat.Helpers.Utils;



public class BaseActivity  extends AppCompatActivity {
    protected void show(String message){
        Utils.show(this,message);
    }
}

