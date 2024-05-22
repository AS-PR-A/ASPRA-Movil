package com.example.aspra_app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ASPRA.db";
    public static final int DATABASE_VERSION = 1;

    // Sentencia SQL para crear la tabla de Usuarios
    private static final String TABLE_CREATE_USUARIOS =
            "CREATE TABLE IF NOT EXISTS Usuarios ( id INTEGER PRIMARY KEY AUTOINCREMENT,\n " +
                    " nombre TEXT NOT NULL,\n " +
                    " email TEXT UNIQUE NOT NULL,\n " +
                    " password TEXT NOT NULL,\n " +
                    " telefono TEXT UNIQUE NOT NULL);";

    // Sentencia SQL para crear la tabla de Motivos
    private static final String TABLE_CREATE_MOTIVOS =
            "CREATE TABLE IF NOT EXISTS Motivos (id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "  nombre TEXT NOT NULL);";

    // Sentencia SQL para crear la tabla de Reportes
    private static final String TABLE_CREATE_REPORTES =
            "CREATE TABLE IF NOT EXISTS Reportes (id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "  fecha TEXT NOT NULL,\n" +
                    "  direccion TEXT NOT NULL,\n" +
                    "  motivo INTEGER NOT NULL,\n" +
                    "  descripcion TEXT NOT NULL,\n" +
                    "  usuario INTEGER NOT NULL,\n" +
                    "FOREIGN KEY(motivo) REFERENCES Motivos (id),\n" +
                    "FOREIGN KEY(usuario) REFERENCES Usuarios (id));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USUARIOS);
        db.execSQL(TABLE_CREATE_MOTIVOS);
        db.execSQL(TABLE_CREATE_REPORTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS Motivos");
        db.execSQL("DROP TABLE IF EXISTS Reportes");
        db.execSQL(TABLE_CREATE_USUARIOS);
        db.execSQL(TABLE_CREATE_MOTIVOS);
        db.execSQL(TABLE_CREATE_REPORTES);
    }
}