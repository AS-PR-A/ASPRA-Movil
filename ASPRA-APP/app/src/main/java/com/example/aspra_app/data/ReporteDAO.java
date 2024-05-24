package com.example.aspra_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aspra_app.models.Reporte;

public class RegistroDAO {

    private DatabaseHelper dbHelper;

    public RegistroDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Agregar un nuevo reporte

    public long addReport(Reporte reporte) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", reporte.getId());
        values.put("fecha", reporte.getFecha());
        values.put("direccion", reporte.getDireccion());
        values.put("motivo", reporte.getMotivo());
        values.put("descripcion", reporte.getDescripcion());
        values.put("usuario", reporte.getUsuario());
        return database.insert("Reportes", null, values);
    }

    // Buscar reporte por usuario

    public Reporte getReporte(Long id) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Reporte reporte = new Reporte();
        String[] findColumns = {"id", "fecha", "direccion" ,"motivo", "descripcion"};
        Cursor cursor = database.query("Reportes", findColumns,  "id = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            reporte.setId(cursor.getLong(0));
            reporte.setFecha(cursor.getString(1));
            reporte.setDireccion(cursor.getString(2));
            reporte.setMotivo(cursor.getString(3));
            reporte.setDescripcion(cursor.getString(4));
        }

        if (cursor != null) {
            cursor.close();
        }
        return reporte;
    }

    // Actualizar un reporte

    public int updateReport(Reporte reporte) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fecha", reporte.getFecha());
        values.put("direccion", reporte.getDireccion());
        values.put("motivo", reporte.getMotivo());
        values.put("descripcion", reporte.getDescripcion());

        return database.update("Reportes", values,
                "id = ?", new String[]{String.valueOf(reporte.getId())});
    }

    // Eliminar un reporte

    public void deleteReport(Long id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete("Reportes", "id = ?", new String[]{String.valueOf(id)});
    }

}
