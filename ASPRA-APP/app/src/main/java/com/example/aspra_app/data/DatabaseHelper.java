package com.example.aspra_app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Informacion de la base de datos
    public static final String DATABASE_NAME = "ASPRA.db";
    public static final int DATABASE_VERSION = 1;

    // Definición de la tabla de usuarios
    public static final String TABLE_USUARIOS = "usuarios";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_CONTRASENA = "contraseña";
    public static final String COLUMN_TELEFONO = "telefono";

    // Definición de la tabla de reportes
    public static final String TABLE_REPORTES = "reportes";
    public static final String COLUMN_ID_REPORTE = "id";
    public static final String COLUMN_DIRECCION = "direccion";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_EMAIL_USUARIO = "email_usuario";
    public static final String COLUMN_ID_MOTIVO2 = "id_motivo";

    // Definición de la tabla de motivos
    public static final String TABLE_MOTIVOS = "motivos";
    public static final String COLUMN_ID_MOTIVO = "id";
    public static final String COLUMN_TIPO = "tipo";

    // Sentencia SQL para crear la tabla de usuarios
    private static final String CREATE_TABLE_USUARIOS =
            "CREATE TABLE " + TABLE_USUARIOS + " (" +
                    COLUMN_EMAIL + " TEXT PRIMARY KEY NOT NULL, " +
                    COLUMN_NOMBRE + " TEXT NOT NULL, " +
                    COLUMN_CONTRASENA + " TEXT NOT NULL, " +
                    COLUMN_TELEFONO + " TEXT NOT NULL);";

    // Sentencia SQL para crear la tabla de reportes
    private static final String CREATE_TABLE_REPORTES =
            "CREATE TABLE " + TABLE_REPORTES + " (" +
                    COLUMN_ID_REPORTE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DIRECCION + " TEXT NOT NULL, " +
                    COLUMN_DESCRIPCION + " TEXT NOT NULL, " +
                    COLUMN_EMAIL_USUARIO + " TEXT NOT NULL," +
                    COLUMN_ID_MOTIVO2 + " TEXT NOT NULL);";

    // Sentencia SQL para crear la tabla de motivos
    private static final String CREATE_TABLE_MOTIVOS =
            "CREATE TABLE " + TABLE_MOTIVOS + " (" +
                    COLUMN_ID_MOTIVO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TIPO + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIOS);
        db.execSQL(CREATE_TABLE_REPORTES);
        db.execSQL(CREATE_TABLE_MOTIVOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOTIVOS);
        onCreate(db);
    }

    public void agregarReportes(String direccion, String motivo, String descripcion){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO REPORTES VALUES('"+direccion+"','"+motivo+"','"+descripcion+"')");
            bd.close();
        }
    }
}