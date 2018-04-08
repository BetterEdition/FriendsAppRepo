package com.example.jesperenemark.friendsapp.DAO;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.jesperenemark.friendsapp.BE.Friend;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robiesun on 15/03/2018.
 *
 * Provider for AndroidFriendsApp.
 * This is the only class knows about the {@link AppDatabase}
 */

public class AppProvider  {
    private static final String TAG = "AppProvider";

    // Person Table Name
    static final String TABLE_NAME = "PERSON";

    AppDatabase appDatabase;
    SQLiteDatabase db;


    public static class Columns {
        public static final String _ID = "id";
        public static final String PERSON_FirstName = "firstName";
        public static final String PERSON_LastName = "lastName";
        public static final String PERSON_Address = "address";
        public static final String PERSON_Mail = "mail";
        public static final String PERSON_Phone = "phone";
        public static final String PERSON_Image = "image";
        public static final String PERSON_Location = "location";

    }

    public AppProvider(Context context) {
        this.appDatabase = AppDatabase.getInstance(context);

    }


    public void addPerson(Friend friend) {
        // Create and/or open the database for writing
        SQLiteDatabase db = appDatabase.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(Columns.PERSON_FirstName, friend.FirstName);
        cValues.put(Columns.PERSON_LastName,friend.LastName);
        cValues.put(Columns.PERSON_Address,friend.Address);
        cValues.put(Columns.PERSON_Phone,friend.PhoneNumber);
        cValues.put(Columns.PERSON_Mail,friend.MailAddress);
        cValues.put(Columns.PERSON_Image,friend.Image);
        cValues.put(Columns.PERSON_Location,friend.Location);
         db.insert("PERSON",null, cValues);
         db.close();

    }
    public void updateFriendById(int id, String FirstName, String LastName, String Address, String PhoneNumber, String MailAddress, String Location) {
        SQLiteDatabase db = appDatabase.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(Columns.PERSON_FirstName, FirstName);
        cValues.put(Columns.PERSON_LastName, LastName);
        cValues.put(Columns.PERSON_Address, Address);
        cValues.put(Columns.PERSON_Phone, PhoneNumber);
        cValues.put(Columns.PERSON_Mail, MailAddress);
        cValues.put(Columns.PERSON_Location, Location);
            db.update("PERSON", cValues, Columns._ID + "=" + id,null);
            db.close();

    }

    public List<Friend> getAll() {
        List<Friend> list = new ArrayList<Friend>();

        // opening database ready for fetching data
        SQLiteDatabase db = appDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{"id", "firstName", "lastName", "address", "mail", "phone", "image", "location"},
                null, null,
                null, null, "id");
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    list.add(new Friend(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7)));
                } while (cursor.moveToNext());
            }
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }


    public void deleteById(int id)
    {
        SQLiteDatabase db = appDatabase.getWritableDatabase();
        db.delete(TABLE_NAME, "id = " + id, null);
    }

    /**
     *  Getting the person ID using their firstName and LastName
     */
    public Cursor getItemId(String firstName, String lastName) {
        SQLiteDatabase db = appDatabase.getWritableDatabase();
        String query = "SELECT" + Columns._ID + " FROM " + TABLE_NAME +
                "WHERE" + Columns.PERSON_FirstName + " = '"+ firstName + " '" +
                Columns.PERSON_LastName + " = '"+ lastName + " '";
        Cursor data = db.rawQuery(query,null);
        return data;
    }






}
