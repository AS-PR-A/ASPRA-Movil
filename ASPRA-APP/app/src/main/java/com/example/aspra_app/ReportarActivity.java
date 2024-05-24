package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.example.aspra_app.data.ReporteDAO;
import com.example.aspra_app.models.Reporte;
import com.example.aspra_app.data.DatabaseHelper;

public class ReportarActivity extends AppCompatActivity {

    EditText edtdireccion, edtdescripcion;
    Button button_reporte_enviar;
    Spinner spMotivo;

    private ReporteDAO ReporteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar);
        //Toma la fecha para crear el reporte



        spMotivo = findViewById(R.id.spMotivo);

        String[] Motivo = {"Maltrato", "Abandono", "Otro"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Motivo);

        spMotivo.setAdapter(adaptador);

        edtdireccion = findViewById(R.id.etDireccion);
        edtdescripcion = findViewById(R.id.etDescripcion);

        button_reporte_enviar = findViewById(R.id.button_reporte_enviar);

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        ReporteDAO = new ReporteDAO(ReportarActivity.this);

        button_reporte_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motivo = spMotivo.getSelectedItem().toString();
                String direccion = edtdireccion.getText().toString();
                String descripcion = edtdescripcion.getText().toString();
                String fecha = obtenerFechaActual();

                // Validadores de datos

                if (TextUtils.isEmpty(motivo) || TextUtils.isEmpty(direccion) || TextUtils.isEmpty(descripcion)) {
                    Toast.makeText(ReportarActivity.this, "Los campos están vacíos", Toast.LENGTH_SHORT).show();
                    return;
                }
                Reporte reporte = new Reporte(0, fecha, direccion, motivo, descripcion, "");
                long result = ReporteDAO.addReport(reporte);
                if (result != -1) {
                    Toast.makeText(ReportarActivity.this, "Reporte aprobado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReportarActivity.this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                }

                irReporteExitoso(ReportarActivity.this);
            }
        });
        }
    // Funcion para tomar la fecha
    private String obtenerFechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaActual = sdf.format(new Date());
        return fechaActual;
    }
    // Funcion para cambiar la pantalla
    public void irReporteExitoso(Context context) {
        Intent intent = new Intent(context, ReporteExitosoActivity.class);
        startActivity(intent);
    }
}
