package com.example.jesperenemark.friendsapp.DAO;

import android.content.ContentResolver;
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
    public static final int DATABASE_VERSION = 12;

    ContentResolver mContentResolver;
    SQLiteDatabase db;

    // Implement AppDatabase as a Singleton.
    private static AppDatabase instance = null;


    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContentResolver = context.getContentResolver();
        db = this.getWritableDatabase();
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
        String sSQL; // Use a string variable to facilitate logging
        sSQL = "CREATE TABLE " + AppProvider.TABLE_NAME + " (" + AppProvider.Columns._ID + " INTEGER PRIMARY KEY," +
                AppProvider.Columns.PERSON_FirstName + " TEXT, " + AppProvider.Columns.PERSON_LastName + " TEXT, " + AppProvider.Columns.PERSON_Address +
                " TEXT, " + AppProvider.Columns.PERSON_Phone + " TEXT, "  + AppProvider.Columns.PERSON_Mail +
                " TEXT," + AppProvider.Columns.PERSON_Image + " TEXT, " + AppProvider.Columns.PERSON_Location + " TEXT " + ")";
        // Log.d(TAG, sSQL);
        db.execSQL(sSQL);

        Log.d(TAG, "Database Created Successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + AppProvider.TABLE_NAME);
        onCreate(db);
    }


}
