package com.example.aspra_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspra_app.data.ReporteDAO;
import com.example.aspra_app.data.UserDAO;
import com.example.aspra_app.models.Reporte;
import com.example.aspra_app.models.Usuario;

import java.util.List;

public class MisReportesActivity extends AppCompatActivity {

    private ReporteDAO reporteDAO;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reportes);

        userEmail = LoginActivity.getUserLogged(this);
        UserDAO userDAO = new UserDAO(MisReportesActivity.this);
        Usuario usuario = userDAO.getUser(userEmail);

        reporteDAO = new ReporteDAO(this);

        TableLayout table = findViewById(R.id.tableLayout);


        List<Reporte> reportes = reporteDAO.getReporte(usuario.getId());

        for (Reporte reporte : reportes) {
            TableRow row = new TableRow(this);

            TextView fechaView = new TextView(this);
            fechaView.setTextColor(getResources().getColor(R.color.white));
            fechaView.setText(reporte.getFecha());
            fechaView.setTextSize(18);
            fechaView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            row.addView(fechaView);

            TextView direccionView = new TextView(this);
            direccionView.setTextColor(getResources().getColor(R.color.white));
            direccionView.setText(reporte.getDireccion());
            direccionView.setTextSize(18);
            direccionView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            row.addView(direccionView);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    irReporte(reporte.getId());
                }
            });

            table.addView(row);
        }
    }

    public void irReporte(long reporteId) {
        try {
            Intent intent = new Intent(this, ReporteActivity.class);
            intent.putExtra("reporteId", reporteId);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir el reporte", Toast.LENGTH_SHORT).show();
        }
    }

    public void irReportar(View view) {
        Intent intent = new Intent(this, ReportarActivity.class);
        startActivity(intent);
    }
}