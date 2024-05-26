package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.aspra_app.data.Auth;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPass;
    private Auth auth;

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
            boolean log = auth.login(email, password);
            if (log) {
                Toast.makeText(LoginActivity.this, "Inicio aprobado!", Toast.LENGTH_SHORT).show();
                setUserLogged(email);  // Guarda el email del usuario logueado
                Intent intent = new Intent(this, MiCuentaActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setUserLogged(String email) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_email", email);
        editor.apply();
    }

    public static String getUserLogged(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user_email", "");
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
