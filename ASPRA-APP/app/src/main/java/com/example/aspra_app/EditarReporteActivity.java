package com.example.aspra_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aspra_app.data.ReporteDAO;
import com.example.aspra_app.models.Reporte;

public class EditarReporteActivity extends AppCompatActivity {

    private EditText editDireccion;
    private EditText editDescripcion;
    private Button button_edit_reporte;
    private ReporteDAO reporteDAO;
    private Reporte reporte;
    private Spinner spMotivo;
    private long reporteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_reporte);

        reporteId = getIntent().getLongExtra("reporteId", -1);

        editDireccion = findViewById(R.id.editDireccion);
        spMotivo = findViewById(R.id.spMotivo);
        editDescripcion = findViewById(R.id.editDescripcion);
        button_edit_reporte = findViewById(R.id.button_edit_reporte);

        String[] Motivo = {"Maltrato", "Abandono", "Otro"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Motivo);
        spMotivo.setAdapter(adaptador);

        reporteDAO = new ReporteDAO(this);
        reporte = reporteDAO.getReporteById(reporteId);

        if (reporte != null) {
            editDireccion.setText(reporte.getDireccion());
            spMotivo.setSelection(adaptador.getPosition(reporte.getMotivo()));
            editDescripcion.setText(reporte.getDescripcion());
        } else {
            Toast.makeText(this, "Error al cargar el reporte", Toast.LENGTH_SHORT).show();
            finish();
        }

        button_edit_reporte.setOnClickListener(view -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Confirmar cambios")
                    .setCancelable(false)
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reporte.setDireccion(editDireccion.getText().toString());
                            reporte.setMotivo(spMotivo.getSelectedItem().toString());
                            reporte.setDescripcion(editDescripcion.getText().toString());
                            int idMotivo = spMotivo.getSelectedItemPosition()+1;
                            reporteDAO.updateReport(reporte,idMotivo);
                            Toast.makeText(EditarReporteActivity.this, "Reporte modificado!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditarReporteActivity.this, MisReportesActivity.class);
                            startActivity(intent);
                            finish(); // Termina esta actividad para que no esté en el back stack
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        });
    }
}
