package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aspra_app.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    Button buttonDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void irReportar(View view) {
        Intent intent = new Intent(this, ReportarActivity.class);
        startActivity(intent);
    }
    public void irContacto(View view) {
       Intent intent = new Intent(this, ContactoActivity.class);
       startActivity(intent);
    }

    public void irMultimedia(View view) {
        Intent intent = new Intent(this, MultimediaActivity.class);
        startActivity(intent);
    }

    public void irMisReportes(View view) {
        Intent intent = new Intent(this, MisReportesActivity.class);
        startActivity(intent);
    }

    public void irMiCuenta(View view) {
        Intent intent = new Intent(this, MiCuentaActivity.class);
        startActivity(intent);
    }
}