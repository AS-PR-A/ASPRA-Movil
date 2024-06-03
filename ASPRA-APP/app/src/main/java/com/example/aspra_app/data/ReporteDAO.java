package com.example.aspra_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aspra_app.models.Reporte;
import com.example.aspra_app.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    private DatabaseHelper dbHelper;

    public ReporteDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Agregar un nuevo reporte

    public long addReport(Reporte reporte, Usuario usuario, int idMotivo) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String query = "SELECT MAX(id) FROM Reportes";
        Cursor cursor = database.rawQuery(query, null);
        long lastId = 0;
        if (cursor != null && cursor.moveToFirst()) {
            lastId = cursor.getLong(0);
            cursor.close();
        }
        long newId = lastId + 1;
        ContentValues values = new ContentValues();
        values.put("id", newId);
        values.put("fecha", reporte.getFecha());
        values.put("direccion", reporte.getDireccion());
        values.put("motivo", idMotivo);
        values.put("descripcion", reporte.getDescripcion());
        values.put("usuario",usuario.getId());
        return database.insert("Reportes", null, values);
    }


    public List<Reporte> getReporte(long idUser) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        List<Reporte> reportes = new ArrayList<>();
        String[] findColumns = {"id", "fecha", "direccion"};
        Cursor cursor = database.query("Reportes", findColumns, "usuario = ?",
                new String[]{String.valueOf(idUser)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Reporte reporte = new Reporte();
                reporte.setId(cursor.getLong(0));
                reporte.setFecha(cursor.getString(1));
                reporte.setDireccion(cursor.getString(2));
                reportes.add(reporte);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return reportes;
    }
    // Buscar reporte por ID
    public Reporte getReporteById(Long id) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Reporte reporte = new Reporte();
        Cursor cursor = database.rawQuery("SELECT r.id, r.direccion, m.nombre, r.descripcion FROM Reportes r INNER JOIN Motivos m ON r.motivo = m.id WHERE r.id = ?", new String[]{String.valueOf(id)});
        if (cursor != null && cursor.moveToFirst()) {
             reporte.setId(cursor.getInt(0));
             reporte.setDireccion(cursor.getString(1));
             reporte.setMotivo(cursor.getString(2));
             reporte.setDescripcion(cursor.getString(3));
        }
        cursor.close();
        return reporte;
    }

    public int updateReport(Reporte reporte, int idMotivo) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("direccion", reporte.getDireccion());
        values.put("motivo", idMotivo);
        values.put("descripcion", reporte.getDescripcion());

        return database.update("Reportes", values,
                "id = ?", new String[]{String.valueOf(reporte.getId())});
    }

    public void deleteReport(Long id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete("Reportes", "id = ?", new String[]{String.valueOf(id)});
    }

}
