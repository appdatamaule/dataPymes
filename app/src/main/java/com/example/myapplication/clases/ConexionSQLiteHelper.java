package com.example.myapplication.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.myapplication.utilidades.utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.CREAR_TABLA_PREVENTA);
        db.execSQL(utilidades.CREAR_TABLA_DETALLE_PREVENTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(utilidades.BORRAR_TABLA_PREVENTA);
        db.execSQL(utilidades.BORRAR_TABLA_DETALLE_PREVENTA);
        onCreate(db);
    }
}
