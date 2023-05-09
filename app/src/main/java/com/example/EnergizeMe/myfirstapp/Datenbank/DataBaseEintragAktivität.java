package com.example.EnergizeMe.myfirstapp.Datenbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseEintragAktivität extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eintragaktivität.db";
    public static final String TABLE_NAME = "eintrag_aktivität_table";
    public static final String COL_1 = "EINTRAG_AKTIVITÄT_ID";
    public static final String COL_2 = "BENUTZER_ID";
    //public static final String COL_3 = "AKTIVITÄTS_ID;"
    public static final String COL_3 = "DATUM";
    public static final String COL_4 = "UHRZEIT";
    public static final String COL_5 = "DAUER";


    public DataBaseEintragAktivität(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String befehl = "create table " + TABLE_NAME + "(EINTRAG_AKTIVITÄT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BENUTZER_ID INTEGER, DATUM DATE, UHRZEIT TIME, DAUER INTEGER," +
                "FOREIGN KEY (BENUTZER_ID) REFERENCES DataBaseHelper(ID))";
        db.execSQL(befehl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String datum, String uhrzeit, String dauer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // wie macht man das mit FKs
        // als Parameter übergeben oder getter-MEthode??
        contentValues.put(COL_3, datum);
        contentValues.put(COL_4, uhrzeit);
        contentValues.put(COL_5, dauer);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
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

    public boolean updateData(String aktivitaetid, String benutzerid, String datum,
                              String uhrzeit, String dauer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, aktivitaetid);
        contentValues.put(COL_2, benutzerid);
        contentValues.put(COL_3, datum);
        contentValues.put(COL_4, uhrzeit);
        contentValues.put(COL_5, dauer);
        db.update(TABLE_NAME, contentValues, "EINTRAG_MAHLZEIT_ID = ?", new String[] { aktivitaetid });
        return true;

    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "EINTRAG_AKTIVITÄT_ID = ?", new String[] {id});
    }


}
