package com.example.aspra_app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UsuariosASPRA.db";
    public static final int DATABASE_VERSION = 1;

    // Definición de la tabla de usuarios
    public static final String TABLA_USUARIOS = "usuarios";
    public static final String COLUMN_DNI = "dni";
    public static final String COLUMN_NAME = "nombre";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "contraseña";

    // Sentencia SQL para crear la tabla de usuarios
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLA_USUARIOS + " (" +
                    COLUMN_DNI + " TEXT PRIMARY KEY, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PASS + " TEXT);";

    /*public static final String TABLA_REPORTES = "usuarios";
    public static final String COLUMN_ID_REPORTE = "idreporte";
    public static final String COLUMN_DIRECCION = "direccion";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_EMAILUSER = "email";
    public static final String COLUMN_ID_MOTIVO = "idmotivo";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLA_REPORTES + " (" +
                    COLUMN_ID_REPORTE + " TEXT PRIMARY KEY, " +
                    COLUMN_DIRECCION + " TEXT, " +
                    COLUMN_DESCRIPCION + " TEXT, " +
                    COLUMN_EMAILUSER + " TEXT," +
                    COLUMN_ID_MOTIVO + " TEXT);"
            ;*/

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIOS);
        onCreate(db);

        /*db.execSQL("DROP TABLE IF EXISTS " + TABLA_REPORTES);
        onCreate(db);*/
    }
}