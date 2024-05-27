package com.example.aspra_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aspra_app.data.UserDAO;
import com.example.aspra_app.models.Usuario;

public class EditarCuentaActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPass;
    private EditText editPhone;
    private Button button_edit_cuenta;
    private UserDAO userDAO;
    private Usuario usuario;
    private LoginActivity userlogged = new LoginActivity();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cuenta);

        String emailUser = userlogged.getUserLogged(this);

        editName = findViewById(R.id.editName);
        editPass = findViewById(R.id.editPass);
        editPhone = findViewById(R.id.editPhone);
        button_edit_cuenta = findViewById(R.id.button_conf_edit_cuenta);

        userDAO = new UserDAO(this);
        usuario = userDAO.getUser(emailUser);

        editName.setText(usuario.getNombre());
        editPhone.setText(usuario.getTelefono());

        button_edit_cuenta.setOnClickListener(view -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Confirmar cambios")
                    .setCancelable(false)
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,int which) {
                            usuario.setNombre(editName.getText().toString());
                            usuario.setPass(editPass.getText().toString());
                            usuario.setTelefono(editPhone.getText().toString());
                            userDAO.updateUser(usuario);
                            Toast.makeText(EditarCuentaActivity.this, "Cuenta modificada!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditarCuentaActivity.this, MiCuentaActivity.class);
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

    public void irMiCuenta2(View view) {
        Intent intent = new Intent(this, MiCuentaActivity.class);
        startActivity(intent);
    }

    public void irMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}