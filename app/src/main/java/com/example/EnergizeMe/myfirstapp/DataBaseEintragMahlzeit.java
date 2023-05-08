package com.example.EnergizeMe.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseEintragMahlzeit extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eintragmahlzeit.db";
    public static final String TABLE_NAME = "eintrag_mahlzeit_table";
    public static final String COL_1 = "EINTRAG_MAHLZEIT_ID";
    public static final String COL_2 = "BENUTZER_ID";
    public static final String COL_3 = "LEBENSMITTEL_ID";
    public static final String COL_4 = "DATUM";
    public static final String COL_5 = "UHRZEIT";
    public static final String COL_6 = "MENGE";



    public DataBaseEintragMahlzeit(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String befehl ="create table " + TABLE_NAME + " (EINTRAG_MAHLZEITID INTEGER PRIMARY KEY AUTOINCREMENT," +
               "BENUTZER_ID INTEGER, LEBENSMITTEL_ID INTEGER, DATUM DATE, UHRZEIT TIME, MENGE INTEGER," +
                //"FOREIGN KEY (LEBENSMITTEL_ID) REFERENCES DataBaseLebensmittel(LEBENSMITTEL_ID)"
                 "FOREIGN KEY (BENUTZER_ID) REFERENCES DataBaseHelper(ID))";
        db.execSQL(befehl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String datum, String uhrzeit, String menge){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, datum);
        contentValues.put(COL_5, uhrzeit);
        contentValues.put(COL_6, menge);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        }
            else{
                return true;
        }
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "EINTRAG_MAHLZEIT_ID = ?", new String[] {id});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
