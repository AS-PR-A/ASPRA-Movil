package com.example.aspra_app.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class Auth {

    private DatabaseHelper dbHelper;

    public Auth(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean login(String email, String pass){
        boolean exist = false;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String[] findColumns = { "email" ,"password"};
        Cursor cursor = database.query("Usuarios", findColumns,  "email=? and password=?",
                new String  []{email,pass}, null, null, null);
        //Cursor cursor = database.rawQuery("select * from Usuarios where email=? and password=?",new String  []{email,pass});
        if (cursor != null && cursor.moveToFirst()) {
            exist = true;
        }

        if (cursor != null) {
            cursor.close();
        }
        return exist;
    }

}
