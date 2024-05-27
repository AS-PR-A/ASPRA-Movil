package com.example.aspra_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aspra_app.models.Usuario;

public class UserDAO {

    private DatabaseHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Agregar un nuevo usuario
    public long addUser(Usuario usuario) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("email", usuario.getEmail());
        values.put("password", usuario.getPass());
        values.put("telefono", usuario.getTelefono());
        return database.insert("Usuarios", null, values);
    }

    // Obtener un usuario por su email
    public Usuario getUser(String email) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Usuario usuario = new Usuario();
        String[] findColumns = {"id","nombre", "email" ,"telefono"};
        Cursor cursor = database.query("Usuarios", findColumns,  "email = ?",
                new String[]{email}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setEmail(cursor.getString(2));
            usuario.setTelefono(cursor.getString(3));
        }
        cursor.close();
        return usuario;
    }

    // Actualizar un usuario
    public int updateUser(Usuario usuario) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("password", usuario.getPass());
        values.put("telefono", usuario.getTelefono());
        return database.update("Usuarios", values,
                "email = ?", new String[]{usuario.getEmail()});
    }

    // Eliminar un usuario por su email
    public void deleteUser(String email) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete("Usuarios", "email = ?", new String[]{email});
    }
}
