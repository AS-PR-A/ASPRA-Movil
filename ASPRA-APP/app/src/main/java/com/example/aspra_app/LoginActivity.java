package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void irReportar(View view) {
        Intent intent = new Intent(this, ReportarActivity.class);
        startActivity(intent);
    }
    public void irRegistrarse(View view) {
        Intent intent = new Intent(this, RegistrarseActivity.class);
        startActivity(intent);
    }
}