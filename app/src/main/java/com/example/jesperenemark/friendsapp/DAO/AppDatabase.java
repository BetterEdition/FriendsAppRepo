package com.example.jesperenemark.friendsapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by robiesun on 14/03/2018.
 */

public class AppDatabase extends SQLiteOpenHelper {
    private static final String TAG = "AppDatabase";
    public static final String DATABASE_NAME = "AppFriend.db";
    public static final int DATABASE_VERSION = 4;

    // Implement AppDatabase as a Singleton.
    private static AppDatabase instance = null;


    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "AppDatabase: constructor");
    }

    /**
     * Get an instance of the app's singleton database helper object
     *
     * @param context the content providers context
     * @return a SQLITE database helper object
     */
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            Log.d(TAG, "getInstance: creating new instance");
            instance = new AppDatabase(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: starts");
        String sSQL; // Use a string variable to facilitate logging
        // sSQL = "CREATE TABLE " + TABLE_NAME + (COLUMN_ID + "INTEGER PRIMARY KEY " + COLUMN_FirstName + "TEXT" );
        sSQL = "CREATE TABLE " + AppProvider.TABLE_NAME + " (" + AppProvider.Columns._ID + " INTEGER PRIMARY KEY," +
                AppProvider.Columns.PERSON_FirstName + " TEXT" + ")";
        // Log.d(TAG, sSQL);
        db.execSQL(sSQL);

        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + AppProvider.TABLE_NAME);
        onCreate(db);
    }


}
