package com.example.EnergizeMe.myfirstapp.Datenbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class DataBaseHelperBenutzer extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "nutzer.db";
    public static final String TABLE_NAME = "nutzer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "VORNAME";
    public static final String COL_3 = "NACHNAME";
    public static final String COL_4 = "AGE";

    public static long currentUserId = -1;


    public DataBaseHelperBenutzer(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, VORNAME TEXT, NACHNAME TEXT, AGE TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertData(String vorname, String nachname, String alter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, vorname);
        contentValues.put(COL_3, nachname);
        contentValues.put(COL_4, alter);

        // wenn db.insert -1 returned = Fehler, wenn ID der Zeile ausgegeben = hat geklappt
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public HashMap<String, String> getUserData() {
        SQLiteDatabase db = this.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                COL_1, COL_2, COL_3, COL_4
        };

// Filter results WHERE "title" = 'My Title'
        String selection = COL_1 + " = ?";
        String[] selectionArgs = {String.valueOf(currentUserId)};

        Cursor cursor = db.query(
                TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        cursor.moveToFirst();
        HashMap<String, String> userData = new HashMap<String, String>();
        userData.put("vorname", cursor.getString(cursor.getColumnIndexOrThrow(COL_2)));
        userData.put("nachname", cursor.getString(cursor.getColumnIndexOrThrow(COL_3)));
        userData.put("alter", cursor.getString(cursor.getColumnIndexOrThrow(COL_4)));

        cursor.close();
        return userData;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String masseid, String vorname, String nachname, String alter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, masseid);
        contentValues.put(COL_2, vorname);
        contentValues.put(COL_3, nachname);
        contentValues.put(COL_4, alter);

        db.update(TABLE_NAME, contentValues, "nutzerid = ?", new String[]{masseid});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nutzerid = ?", new String[]{id});
    }


}
