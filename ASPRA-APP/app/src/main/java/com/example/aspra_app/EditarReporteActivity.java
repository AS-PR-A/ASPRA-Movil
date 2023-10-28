package com.example.aspra_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class EditarReporteActivity extends AppCompatActivity {

    Spinner spMotivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_reporte);


        spMotivo = findViewById(R.id.spMotivo);

        String[] Motivo = {"Maltrato", "Abandono", "Otro"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Motivo);

        spMotivo.setAdapter(adaptador);
    }




    public void irMisReporte() {
        Intent intent = new Intent(this, ReporteActivity.class);
        startActivity(intent);
    }


}