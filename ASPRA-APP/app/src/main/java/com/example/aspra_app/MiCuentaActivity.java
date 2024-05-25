package com.example.aspra_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aspra_app.data.UserDAO;
import com.example.aspra_app.models.Usuario;


public class MiCuentaActivity extends AppCompatActivity {

    private TextView textViewUsername;
    private TextView textViewEmail;
    private TextView textViewPhone;
    private Button buttonEliminar;
    private UserDAO userDAO;
    private Usuario usuario;
    private LoginActivity userlogged = new LoginActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_cuenta);

        String emailUser = userlogged.getUserLogged(this);

        textViewUsername = findViewById(R.id.textViewUsername);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPhone = findViewById(R.id.textViewPhone);
        buttonEliminar = findViewById(R.id.button_eliminar_cuenta);
        userDAO = new UserDAO(this);
        usuario = userDAO.getUser(emailUser);

        textViewUsername.setText(usuario.getNombre());
        textViewEmail.setText(usuario.getEmail());
        textViewPhone.setText(usuario.getTelefono());

        buttonEliminar.setOnClickListener(view -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("¿Estás seguro de que quieres eliminar tu cuenta?")
                    .setCancelable(false)
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,int which) {
                            userDAO.deleteUser(usuario.getEmail());
                            Toast.makeText(MiCuentaActivity.this, "Cuenta eliminada!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MiCuentaActivity.this, MainActivity.class);
                            startActivity(intent);
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

    public void irEditarCuenta(View view) {
        Intent intent = new Intent(this, EditarCuentaActivity.class);
        startActivity(intent);
    }

}