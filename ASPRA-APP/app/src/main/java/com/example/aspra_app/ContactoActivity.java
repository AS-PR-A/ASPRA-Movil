package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void openWebsite(View view) {
        Uri webpage = Uri.parse("https://ezmant.github.io/Proyecto_FullStack_ISPC/Maqueta/Vistas/index.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
// Si no hay una aplicación para manejar el intent, abre el navegador web.
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ezmant.github.io/Proyecto_FullStack_ISPC/Maqueta/Vistas/index.html"));
            startActivity(browserIntent);
        }
    }
}
