package com.example.aspra_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.aspra_app.data.ReporteDAO;
import com.example.aspra_app.models.Reporte;

public class ReporteActivity extends AppCompatActivity {
    private TextView textViewDireccion;
    private TextView textViewMotivo;
    private ReporteDAO reporteDAO;
    private Reporte reporte;
    private long reporteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        reporteId = getIntent().getLongExtra("reporteId", -1);
        textViewDireccion = findViewById(R.id.textViewDireccion);
        textViewMotivo = findViewById(R.id.textViewMotivo);
        reporteDAO = new ReporteDAO(this);
        reporte = reporteDAO.getReporteById(reporteId);
        textViewDireccion.setText(reporte.getDireccion());
        textViewMotivo.setText(reporte.getMotivo());
    }

    public void irEditarReporte(View view) {
        Intent intent = new Intent(this, EditarReporteActivity.class);
        intent.putExtra("reporteId", reporteId);
        startActivity(intent);
    }

    public void eliminarReporte(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Estás seguro de que quieres eliminar el reporte?")
                .setCancelable(false)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        reporteDAO.deleteReport(reporte.getId());
                        Toast.makeText(ReporteActivity.this, "Reporte eliminado!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ReporteActivity.this, MisReportesActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}





