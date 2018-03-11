package com.example.jbory_000.pracovnidoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void vyberMenu(View view) {
        switch (view.getId()) {
            case R.id.zamestnavatel:
                //prechod na aktivitu zamestnavatel
                Intent intent = new Intent(getApplicationContext(), zamestnavatel.class);
                startActivity(intent);
                break;
            case R.id.zamestnanec:
                //prechod na aktivitu zamestnanci
                intent = new Intent(getApplicationContext(), zamestnanci.class);
                startActivity(intent);
                break;
        }
    }
}