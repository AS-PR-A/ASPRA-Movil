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

        // Obtén la referencia de la tabla desde el layout
        TableLayout table = (TableLayout) findViewById(R.id.tableLayout);

        // Aquí debes obtener los datos de los reportes. Por ahora, solo vamos a agregar un reporte de ejemplo.
        String fecha = "01-01-2023";
        String direccion = "Direccion 1";

        // Crea una nueva fila
        TableRow row = new TableRow(this);

        // Crea un TextView para la fecha
        TextView fechaView = new TextView(this);
        fechaView.setText(fecha);
        row.addView(fechaView);

        // Crea un TextView para la dirección
        TextView direccionView = new TextView(this);
        direccionView.setText(direccion);
        row.addView(direccionView);

        // Agrega un escuchador de clics a la fila
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irReporte(v);
            }
        });

        // Agrega la fila a la tabla
        table.addView(row);
    }

    public void irReporte(View view) {
        Intent intent = new Intent(this, ReporteActivity.class);
        startActivity(intent);
    }
}
