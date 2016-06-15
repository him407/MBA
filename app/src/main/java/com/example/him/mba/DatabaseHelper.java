package com.example.him.mba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HIM on 13/6/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MBA.db";

    public static final String CLIENT_TABLE = "clientsTable";
    public static final String CLIENT_COL_1 = "cid";
    public static final String CLIENT_COL_2 = "firstName";
    public static final String CLIENT_COL_3 = "LastName";
    public static final String CLIENT_COL_4 = "mobile";
    public static final String CLIENT_COL_5 = "email";
    public static final String CLIENT_ = "joinDate";

    public static final String ORDER_TABLE = "ordersTable";
    public static final String ORDER_COL_1 = "orderID";
    public static final String ORDER_COL_2 = "clientID";
    public static final String ORDER_COL_3 = "eventDate";
    public static final String ORDER_COL_4 = "eventTime";
    public static final String ORDER_COL_5 = "eventLocation";
    public static final String ORDER_COL_6 = "price";
    public static final String ORDER_COL_7 = "deposit";
    public static final String ORDER_COL_8 = "remarks";
    public static final String ORDER_COL_9 = "status";
    public static final String ORDER_COL_10 = "setAlarm";
    public static final String ORDER_COL_11 = "lastUpdate";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CLIENT_TABLE +" (cid INTEGER PRIMARY KEY AUTOINCREMENT, firstName TEXT, LastName TEXT, mobile TEXT, email TEXT, joinDate DATE)");
        db.execSQL("create table " + ORDER_TABLE +" (orderID INTEGER PRIMARY KEY AUTOINCREMENT, clientID INTEGER, eventDate DATE, eventTime TIME, eventLocation TEXT, price TEXT, deposit TEXT, remarks TEXT, status TEXT, setAlarm INTEGER, lastUpdate DATETIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CLIENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ORDER_TABLE);
        onCreate(db);
    }
}