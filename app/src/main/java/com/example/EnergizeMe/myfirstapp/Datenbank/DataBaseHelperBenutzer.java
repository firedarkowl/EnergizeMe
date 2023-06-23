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
    public static final String COL_ID = "ID";
    public static final String COL_VORNAME = "VORNAME";
    public static final String COL_NACHNAME = "NACHNAME";
    public static final String COL_ALTER = "AGE";
    public static final String COL_GESCHLECHT = "GESCHLECHT";
    public static final String COL_GROESSE = "GROESSE";
    public static final String COL_GEWICHT = "GEWICHT";
    public static final String COL_TAETIGKEIT = "TAETIGKEIT";

    public static long currentUserId = -1;


    public DataBaseHelperBenutzer(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "" + COL_VORNAME + " TEXT, " +
                "" + COL_NACHNAME + " TEXT, " +
                "" + COL_ALTER + " INTEGER," +
                "" + COL_GROESSE + " INTEGER," +
                "" + COL_GEWICHT + " INTEGER," +
                "" + COL_GESCHLECHT + " TEXT, " +
                "" + COL_TAETIGKEIT + " TEXT " +
                ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertData(String vorname, String nachname, String alter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_VORNAME, vorname);
        contentValues.put(COL_NACHNAME, nachname);
        contentValues.put(COL_GROESSE, 160);
        contentValues.put(COL_GEWICHT, 60);
        contentValues.put(COL_ALTER, alter);

        // wenn db.insert -1 returned = Fehler, wenn ID der Zeile ausgegeben = hat geklappt
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public HashMap<String, String> getUserData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COL_ID, COL_VORNAME, COL_NACHNAME, COL_ALTER, COL_TAETIGKEIT, COL_GESCHLECHT, COL_GEWICHT, COL_GROESSE};
        String selection = COL_ID + " = ?";
        String[] selectionArgs = {String.valueOf(currentUserId)};

        Cursor cursor = db.query(TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        cursor.moveToFirst();
        HashMap<String, String> userData = new HashMap<String, String>();
        userData.put("vorname", cursor.getString(cursor.getColumnIndexOrThrow(COL_VORNAME)));
        userData.put("nachname", cursor.getString(cursor.getColumnIndexOrThrow(COL_NACHNAME)));
        userData.put("alter", cursor.getString(cursor.getColumnIndexOrThrow(COL_ALTER)));
        userData.put("groesse", cursor.getString(cursor.getColumnIndexOrThrow(COL_GROESSE)));
        userData.put("gewicht", cursor.getString(cursor.getColumnIndexOrThrow(COL_GEWICHT)));

        cursor.close();
        return userData;
    }

    public void updateCurrentUser(ContentValues cv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_NAME, cv, "id = ?", new String[]{String.valueOf(currentUserId)});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String masseid, String vorname, String nachname, String alter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, masseid);
        contentValues.put(COL_VORNAME, vorname);
        contentValues.put(COL_NACHNAME, nachname);
        contentValues.put(COL_ALTER, alter);

        db.update(TABLE_NAME, contentValues, "nutzerid = ?", new String[]{masseid});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nutzerid = ?", new String[]{id});
    }


}
