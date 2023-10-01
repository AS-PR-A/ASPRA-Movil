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

public class ReportarActivity extends AppCompatActivity {

    Spinner spMotivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar);
        irReporteExitoso(ReportarActivity.this);

        spMotivo = findViewById(R.id.spMotivo);

        String[] Motivo = {"Maltrato", "Abandono", "Otro"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Motivo);

        spMotivo.setAdapter(adaptador);
    }


    public void irReporteExitoso (Context context)
    {
        Button button = findViewById(R.id.button_reporte_enviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Reporte");
                builder.setMessage("Enviando reporte...");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, ReporteExitosoActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}

