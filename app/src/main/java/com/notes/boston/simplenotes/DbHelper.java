package com.notes.boston.simplenotes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DbHelper extends SQLiteOpenHelper {

    public  static final int DATABASE_VERSION = 1;
    public  static final String DATABASE_NAME = "db_SimpleNote";
    public static final String TABLE_NAME = "notes";
    public static final String TABLE_ID = "id";
    public static final String TABLE_TITLE = "title";
    public static final String TABLE_BODY = "body";
    public static final String TABLE_CHECK_DATE = "checkDate";
    public static final String TABLE_UPDATE_DATE ="updateDate";
    public DbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " +TABLE_NAME +" (" +
                TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                TABLE_TITLE + "TEXT," +
                TABLE_BODY + "TEXT," +
                TABLE_CHECK_DATE + "TEXT," +
                TABLE_UPDATE_DATE + " TEXT)";
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        Log.d(TAG, "onCreate: Yey!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
