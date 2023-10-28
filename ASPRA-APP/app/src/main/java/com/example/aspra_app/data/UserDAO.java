package com.example.aspra_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.aspra_app.models.Usuario;

public class UserDAO {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Agregar un nuevo usuario
    public long addUser(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOMBRE, usuario.getNombre());
        values.put(DatabaseHelper.COLUMN_EMAIL, usuario.getEmail());
        values.put(DatabaseHelper.COLUMN_CONTRASENA, usuario.getContrasena());
        return database.insert(DatabaseHelper.TABLE_USUARIOS, null, values);
    }

    // Obtener un usuario por su DNI (o ID en tu caso)
    public Usuario getUsuariopordni(String email) {
        Usuario usuario = null;
        Cursor cursor = database.query(DatabaseHelper.TABLE_USUARIOS, null, DatabaseHelper.COLUMN_EMAIL + " = ?",
                new String[]{email}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            usuario = cursorToUser(cursor);
        }

        if (cursor != null) {
            cursor.close();
        }

        return usuario;
    }

    // Actualizar un usuario
    public int modificarUsuario(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOMBRE, usuario.getNombre());
        values.put(DatabaseHelper.COLUMN_EMAIL, usuario.getEmail());
        values.put(DatabaseHelper.COLUMN_CONTRASENA, usuario.getContrasena());

        return database.update(DatabaseHelper.TABLE_USUARIOS, values,
                DatabaseHelper.COLUMN_EMAIL + " = ?", new String[]{usuario.getEmail()});
    }

    // Eliminar un usuario por su DNI (o ID en tu caso)
    public void borrarUsuario(String email) {
        database.delete(DatabaseHelper.TABLE_USUARIOS, DatabaseHelper.COLUMN_EMAIL + " = ?", new String[]{email});
    }

    private Usuario cursorToUser(Cursor cursor) {
        Usuario usuario = new Usuario();
        usuario.setEmail(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL)));
        usuario.setNombre(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE)));
        usuario.setTelefono(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TELEFONO)));
        usuario.setContrasena(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTRASENA)));
        return usuario;
    }}