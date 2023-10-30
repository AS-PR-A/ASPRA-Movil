package com.example.aspra_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aspra_app.data.UserDAO;
import com.example.aspra_app.models.Usuario;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonRegistrarse;

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        // Inicializar vistas
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonRegistrarse = findViewById(R.id.button_registrarse_confirmar);

        // Inicializar la instancia de UserDAO
        userDAO = new UserDAO(this);

        // Asignar un listener al botón de registro
        buttonRegistrarse.setOnClickListener(view -> {
            // Obtener los valores ingresados por el usuario
            String username = editTextUsername.getText().toString();
            String email = editTextEmail.getText().toString();
            String phone = editTextPhone.getText().toString();
            String password = editTextPassword.getText().toString();
            String confirmPassword = editTextConfirmPassword.getText().toString();

            // Verificar si las contraseñas coinciden
            if (password.equals(confirmPassword) && isValidEmail(email))  {
                // Crear un nuevo objeto Usuario con los datos ingresados
                Usuario usuario = new Usuario();
                usuario.setNombre(username);
                usuario.setEmail(email);
                usuario.setPhone(phone);
                usuario.setPass(password);

                // Abrir la base de datos y agregar el usuario
                userDAO.open();
                long result = userDAO.addUser(usuario);
                userDAO.close();

                if (result != -1) {
                    // El usuario se ha registrado con éxito en la base de datos
                    Toast.makeText(RegistrarseActivity.this, "Registro aprobado!", Toast.LENGTH_SHORT).show();
                } else {
                    // Ocurrió un error al registrar el usuario
                    Toast.makeText(RegistrarseActivity.this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                }
            } else {
                // No se valida email o las contraseñas no coinciden
                Toast.makeText(RegistrarseActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void irLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    // Validación de mail
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

}