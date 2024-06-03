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



    public void openWebsite1(View view) {
        Uri webpage = Uri.parse("https://ezmant.github.io/Proyecto_FullStack_ISPC/Maqueta/Vistas/index.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ezmant.github.io/Proyecto_FullStack_ISPC/Maqueta/Vistas/index.html"));
            startActivity(browserIntent);
        }
    }

    public void openWebsite2(View view) {
        Uri webpage = Uri.parse("https://maps.app.goo.gl/QMXWQGYYGyBV4Yry9");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/QMXWQGYYGyBV4Yry9"));
            startActivity(browserIntent);
        }
    }

    public void openEmailChooser(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "aspraproteccionanimal@gmail.com" });
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }

    public void openWebsite3(View view) {
        Uri webpage = Uri.parse("https://wa.me/+5493516110625");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+5493516110625"));
            startActivity(browserIntent);
        }
    }
}
