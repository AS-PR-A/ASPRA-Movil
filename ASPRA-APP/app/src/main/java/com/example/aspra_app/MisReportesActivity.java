package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MisReportesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reportes);
    }

    public void irReporte(View view) {
        Intent intent = new Intent(this, ReporteActivity.class);
        startActivity(intent);
    }

}