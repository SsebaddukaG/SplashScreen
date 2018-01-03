package com.example.luckygilbert.splashscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LuckyGilbert on 28-Dec-17.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "user_data";
    public static final String USER_ID = "Userid";
    public static final String  User_name = "Username";
    public static final String User_password  = "password";

   /* public static final String CREATE_TABLE_QUERY =
            "TABLE NAME " + TABLE_NAME + "(" +
                    USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULLNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT ";*/

//this a constructor
    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //writing command for sqlite to create table with required columns
        String CREATE_TABLE_QUERY =
                "TABLE NAME " + TABLE_NAME + "(" +
                        USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        User_name + " TEXT, " +
                        User_password + " TEXT " + ")";

        db.execSQL(CREATE_TABLE_QUERY);

    }

    //upgrading the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);

    }

    //add new user by calling this method

    public void addUser(User user)
    {
        //get database instance for writing the user
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(User_name, user.getName());
        cv.put(User_password,user.getPassword());
        //cv.put(USER_ID,user.getId()); not rewuired at the moment

        //inserting row
        db.insert(TABLE_NAME,null,cv);
        //close the database
        db.close();
    }

    public int checkUser(User user)
    {
        int Id = -1;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT ID FROM user WHERE name=? AND password=?", new String[]{user.getName(),user.getPassword()});
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            Id = cursor.getInt(0);

            cursor.close();
        }

        return Id;
    }
}
