package com.example.aspra_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MiCuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_cuenta);
    }

    public void irEditarCuenta(View view) {
        Intent intent = new Intent(this, EditarCuentaActivity.class);
        startActivity(intent);
    }

    public void eliminarCuenta(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Estás seguro de que quieres eliminar tu cuenta?")
                .setCancelable(false)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acciones a realizar si el usuario confirma
                        mostrarConfirmacion();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acciones a realizar si el usuario cancela
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void mostrarConfirmacion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Cuenta eliminada")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acciones a realizar al presionar OK
                        Intent intent = new Intent(MiCuentaActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }



}