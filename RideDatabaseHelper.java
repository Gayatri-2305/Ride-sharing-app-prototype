package com.example.rideshare;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RideDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "RideDB";
    private static final int DB_VERSION = 1;

    public RideDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE rides (id INTEGER PRIMARY KEY AUTOINCREMENT, pickup TEXT, drop_loc TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS rides");
        onCreate(db);
    }

    public boolean insertRide(String pickup, String drop) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pickup", pickup);
        values.put("drop_loc", drop);
        long result = db.insert("rides", null, values);
        return result != -1;
    }
}
