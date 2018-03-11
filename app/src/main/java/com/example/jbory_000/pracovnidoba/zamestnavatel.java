package com.example.jbory_000.pracovnidoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class zamestnavatel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamestnavatel);
    }

    public void zamestnavatelMenu(View view) {
        switch(view.getId()) {
            case R.id.pridatProjekt:
                //prechod na aktivitu zamestnavatel
                Intent intent = new Intent(getApplicationContext(), pridatProjekt.class);
                startActivity(intent);
                break;
            case R.id.existujiciProjekt:
                //prechod na aktivitu zamestnanci
                intent = new Intent(getApplicationContext(), existujiciProjekt.class);
                startActivity(intent);
                break;
            case R.id.reportProjektu:
                //prechod na aktivitu zamestnanci
                intent = new Intent(getApplicationContext(), reportProjektu.class);
                startActivity(intent);
                break;
        }
    }
}
