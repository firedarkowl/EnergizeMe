package com.example.EnergizeMe.myfirstapp.Datenbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseMeinProfil extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "masse.db";
    public static final String TABLE_NAME = "masse_table";

    public static final String COL_1 = "MASSEID";
    public static final String COL_2 = "GEBDATUM";
    public static final String COL_3 = "GESCHLECHT";
    public static final String COL_4 = "GROESSE";
    public static final String COL_5 = "GEWICHT";
    public static final String COL_6 = "ZIEL";
    public static final String COL_7 = "TAETIGKEITSLEVEL";


    public static final String COL_11 = "BENUTZERID";

    public DataBaseMeinProfil(@Nullable Context context) {
        super(context,DATABASE_NAME,null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (MASSEID INTEGER PRIMARY KEY AUTOINCREMENT, GEBDATUM TEXT, GESCHLECHT TEXT" +
                ",GEWICHT INTEGER, ZIEL TEXT, TAETIGKEITSLEVEL INTEGER, BENUTZERID INTEGER," +
                " FOREIGN KEY (BENUTZERID) REFERENCES DataBaseHelperBenutzer(ID)) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData( String gebDatum,
                              String geschlecht, String groesse,String gewicht, String ziel,
                              String taetigkeitslevel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, gebDatum);
        contentValues.put(COL_3, geschlecht);
        contentValues.put(COL_4, groesse);
        contentValues.put(COL_5, gewicht);
        contentValues.put(COL_6, ziel);
        contentValues.put(COL_7, taetigkeitslevel);

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

    public boolean updateData(String masseid, String gebDatum,
                              String geschlecht, String groesse,String gewicht, String ziel,
                              String taetigkeitslevel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, masseid);
        contentValues.put(COL_2, gebDatum);
        contentValues.put(COL_3, geschlecht);
        contentValues.put(COL_4, groesse);
        contentValues.put(COL_5, gewicht);
        contentValues.put(COL_6, ziel);
        contentValues.put(COL_7, taetigkeitslevel);

        db.update(TABLE_NAME, contentValues, "nutzerid = ?", new String[] { masseid });
        return true;
    }

    public Integer deleteData (String masseid){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nutzerid = ?", new String[] {masseid});
    }
}
