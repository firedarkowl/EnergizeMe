package com.example.EnergizeMe.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "nutzer.db";
    public static final String TABLE_NAME = "nutzer_table";
    public static final String COL_1 = "NUTZERID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "GEBDATUM";
    public static final String COL_4 = "GESCHLECHT";
    public static final String COL_5 = "GROESSE";
    public static final String COL_6 = "GEWICHT";
    public static final String COL_7 = "ZIEL";
    public static final String COL_8 = "TAETIGKEITSLEVEL";
    public static final String COL_9 = "TAEGLICHEPUNKTE";
    public static final String COL_10 = "PUNKTESTANDTAG";
    public static final String COL_11 = "PUNKTESTANDWOCHE";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GEBDATUM TEXT, GESCHLECHT TEXT" +
                ",GEWICHT INTEGER, ZIEL TEXT, TAETIGKEITSLEVEL INTEGER, TAEGLICHEPUNKTE INTEGER, PUNKTESTANDTAG INTEGER, PUNKTESTANDWOCHE INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }
}
