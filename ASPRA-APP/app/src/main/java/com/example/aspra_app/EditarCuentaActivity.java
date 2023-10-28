package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditarCuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cuenta);
    }

    public void irMiCuenta2(View view) {
        Intent intent = new Intent(this, MiCuentaActivity.class);
        startActivity(intent);
    }

}