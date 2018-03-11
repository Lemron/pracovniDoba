package com.example.jbory_000.pracovnidoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class zamestnanci extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamestnanci);
    }

    public void zamestnanciMenu(View view) {

        switch(view.getId()) {
            case R.id.pridatZamestnance:
                //prechod na aktivitu zamestnavatel
                Intent intent = new Intent(getApplicationContext(), pridatZamestnance.class);
                startActivity(intent);
                break;
            case R.id.existujiciZamestnanec:
                //prechod na aktivitu zamestnanci
                intent = new Intent(getApplicationContext(), EmployeeList.class);
                startActivity(intent);
                break;
            case R.id.reportPrace:
                //prechod na aktivitu zamestnanci
                intent = new Intent(getApplicationContext(), reportPrace.class);
                startActivity(intent);
                break;
        }
    }
}
