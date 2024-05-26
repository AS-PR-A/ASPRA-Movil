package com.example.aspra_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aspra_app.models.Reporte;

import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    private DatabaseHelper dbHelper;

    public ReporteDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Agregar un nuevo reporte

    public long addReport(Reporte reporte) {
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
        values.put("motivo", reporte.getMotivo());
        values.put("descripcion", reporte.getDescripcion());
        values.put("usuario", reporte.getUsuario());
        return database.insert("Reportes", null, values);
    }


    public List<Reporte> getReporte(String mail) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        List<Reporte> reportes = new ArrayList<>();
        String[] findColumns = {"id", "fecha", "direccion", "motivo", "descripcion"};
        Cursor cursor = database.query("Reportes", findColumns, "usuario = ?",
                new String[]{mail}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Reporte reporte = new Reporte();
                reporte.setId(cursor.getLong(0));
                reporte.setFecha(cursor.getString(1));
                reporte.setDireccion(cursor.getString(2));
                reporte.setMotivo(cursor.getString(3));
                reporte.setDescripcion(cursor.getString(4));
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
        Reporte reporte = null;
        Cursor cursor = database.query(
                "Reportes",
                new String[]{"id", "fecha", "direccion", "motivo", "descripcion", "usuario"},
                "id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
        if (cursor != null) {
            String[] columnNames = cursor.getColumnNames();
            for (String columnName : columnNames) {
            }

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex("id");
                int fechaIndex = cursor.getColumnIndex("fecha");
                int direccionIndex = cursor.getColumnIndex("direccion");
                int motivoIndex = cursor.getColumnIndex("motivo");
                int descripcionIndex = cursor.getColumnIndex("descripcion");
                int usuarioIndex = cursor.getColumnIndex("usuario");

                if (idIndex == -1 || fechaIndex == -1 || direccionIndex == -1 || motivoIndex == -1 || descripcionIndex == -1 || usuarioIndex == -1) {
                } else {
                    reporte = new Reporte();
                    reporte.setId(cursor.getLong(idIndex));
                    reporte.setFecha(cursor.getString(fechaIndex));
                    reporte.setDireccion(cursor.getString(direccionIndex));
                    reporte.setMotivo(cursor.getString(motivoIndex));
                    reporte.setDescripcion(cursor.getString(descripcionIndex));
                    reporte.setUsuario(cursor.getString(usuarioIndex));
                }
            }
            cursor.close();
        }
        database.close();
        return reporte;
    }

    public int updateReport(Reporte reporte) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("direccion", reporte.getDireccion());
        values.put("motivo", reporte.getMotivo());
        values.put("descripcion", reporte.getDescripcion());

        return database.update("Reportes", values,
                "id = ?", new String[]{String.valueOf(reporte.getId())});
    }

    public void deleteReport(Long id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete("Reportes", "id = ?", new String[]{String.valueOf(id)});
    }

}
