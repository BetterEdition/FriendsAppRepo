package com.example.jesperenemark.friendsapp.DAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.jesperenemark.friendsapp.BE.Friend;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robiesun on 15/03/2018.
 *
 * Provider for AndroidFriendsApp.
 * This is the only class knows about the {@link AppDatabase}
 */

public class AppProvider {
    private static final String TAG = "AppProvider";

    // Person Table Name
    static final String TABLE_NAME = "PERSON";

    AppDatabase appDatabase;
    SQLiteDatabase db;


    public static class Columns {
        public static final String _ID = "id";
        public static final String PERSON_FirstName = "firstName";

    }



    public AppProvider(Context context) {
        this.appDatabase = AppDatabase.getInstance(context);
        appDatabase.getWritableDatabase();

    }


    public void addPerson(Friend friend) {
        // Create and/or open the database for writing
        SQLiteDatabase db = appDatabase.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(Columns.PERSON_FirstName, friend.FirstName);
        db.insert("PERSON",null, cValues);
        db.close();
    }

    public List<Friend> getAll() {
        List<Friend> list = new ArrayList<Friend>();

        // opening database ready for fetching data
        SQLiteDatabase db = appDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{"id", "firstName"},
                null, null,
                null, null, "id");
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    list.add(new Friend(cursor.getInt(0),
                            cursor.getString(1)));
                } while (cursor.moveToNext());
            }
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }


    public void deletePerson(int id) {

    }
    public Friend updatePerson(int id) {
        return null;
    }


}
