package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MisReportesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misreportes);

        TableLayout table = (TableLayout) findViewById(R.id.tableLayout);

        String fecha = "30-10-2023";
        String direccion = "Deodoro Roca 800, Cordoba";

        TableRow row = new TableRow(this);

        TextView fechaView = new TextView(this);
        fechaView.setText(fecha);
        row.addView(fechaView);

        TextView direccionView = new TextView(this);
        direccionView.setText(direccion);
        row.addView(direccionView);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irReporte(v);
            }
        });

        table.addView(row);
    }

    public void irReporte(View view) {
        Intent intent = new Intent(this, ReporteActivity.class);
        startActivity(intent);
    }
}
