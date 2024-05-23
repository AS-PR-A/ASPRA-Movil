package com.example.aspra_app;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aspra_app.data.Auth;

public class LoginActivity extends AppCompatActivity {

    public static String userLogged = "com.example.android.aspra_app.USER.LOGGED";

    private EditText editEmail;
    private EditText editPass;
    private Auth auth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editTextTextEmailAddress);
        editPass = findViewById(R.id.editTextTextPassword);
        Button button_login = findViewById(R.id.button_login);
        auth = new Auth(this);

        button_login.setOnClickListener(view -> {
            String email = editEmail.getText().toString();
            String password = editPass.getText().toString();
            boolean log = auth.login(email,password);
            if (log){
                Toast.makeText(LoginActivity.this, "Inicio aprobado!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MiCuentaActivity.class);
                userLogged = email;
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }

    });


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