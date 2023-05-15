package com.example.EnergizeMe.myfirstapp.Datenbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelperBenutzer extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "nutzer.db";
    public static final String TABLE_NAME = "nutzer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "VORNAME";
    public static final String COL_3 = "NACHNAME";


    public DataBaseHelperBenutzer(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, VORNAME TEXT, NACHNAME TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String vorname, String nachname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, vorname);
        contentValues.put(COL_3, nachname);
        
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

    public boolean updateData(String masseid, String vorname, String nachname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, masseid);
        contentValues.put(COL_2, vorname);
        contentValues.put(COL_3, nachname);
        
        db.update(TABLE_NAME, contentValues, "nutzerid = ?", new String[] { masseid });
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nutzerid = ?", new String[] {id});
    }


}
