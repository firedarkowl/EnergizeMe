package com.example.EnergizeMe.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelperBenutzer extends SQLiteOpenHelper {
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

    public DataBaseHelperBenutzer(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db = this.getWritableDatabase();
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

    public boolean insertData(String name, String gebDatum,
                              String geschlecht, String groesse,String gewicht, String ziel,
                              String taetigkeitslevel, String taeglichePunkte, String punktestandtag, String punktestandwoche) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, gebDatum);
        contentValues.put(COL_4, geschlecht);
        contentValues.put(COL_5, groesse);
        contentValues.put(COL_6, gewicht);
        contentValues.put(COL_7, ziel);
        contentValues.put(COL_8, taetigkeitslevel);
        contentValues.put(COL_9, taeglichePunkte);
        contentValues.put(COL_10, punktestandtag);
        contentValues.put(COL_11, punktestandwoche);
        // wenn db.insert -1 returned = Fehler, wenn ID der Zeile ausgegeben = hat geklappt
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String name, String gebDatum,
                              String geschlecht, String groesse,String gewicht, String ziel,
                              String taetigkeitslevel, String taeglichePunkte, String punktestandtag, String punktestandwoche) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, gebDatum);
        contentValues.put(COL_4, geschlecht);
        contentValues.put(COL_5, groesse);
        contentValues.put(COL_6, gewicht);
        contentValues.put(COL_7, ziel);
        contentValues.put(COL_8, taetigkeitslevel);
        contentValues.put(COL_9, taeglichePunkte);
        contentValues.put(COL_10, punktestandtag);
        contentValues.put(COL_11, punktestandwoche);
        db.update(TABLE_NAME, contentValues, "nutzerid = ?", new String[] { id });
        return true;
    }

}
