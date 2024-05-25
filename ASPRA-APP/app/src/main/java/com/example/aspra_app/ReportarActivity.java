package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    private ReporteDAO reporteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar);

        spMotivo = findViewById(R.id.spMotivo);
        String[] motivo = {"Maltrato", "Abandono", "Otro"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, motivo);
        spMotivo.setAdapter(adaptador);

        edtdireccion = findViewById(R.id.etDireccion);
        edtdescripcion = findViewById(R.id.etDescripcion);
        button_reporte_enviar = findViewById(R.id.button_reporte_enviar);

        final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        reporteDAO = new ReporteDAO(ReportarActivity.this);

        button_reporte_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motivo = spMotivo.getSelectedItem().toString();
                String direccion = edtdireccion.getText().toString();
                String descripcion = edtdescripcion.getText().toString();
                String fecha = obtenerFechaActual();
                String emailUsuario = LoginActivity.getUserLogged(ReportarActivity.this);

                if (!motivo.isEmpty() && !direccion.isEmpty() && !descripcion.isEmpty()) {
                    Reporte reporte = new Reporte(0, fecha, direccion, motivo, descripcion, emailUsuario);
                    long result = reporteDAO.addReport(reporte);
                    if (result != -1) {
                        Toast.makeText(ReportarActivity.this, "Reporte aprobado!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ReportarActivity.this, ReporteExitosoActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ReportarActivity.this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ReportarActivity.this, "Los campos están vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String obtenerFechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }
}
