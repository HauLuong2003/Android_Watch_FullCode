package com.example.andorid_watch.Respository.DB_Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andorid_watch.Domain.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "watch_db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_DATABASE_CART = "CREATE TABLE CART (" +
            "id_product TEXT PRIMARY KEY," +
            "name_product TEXT," +
            "unit INTEGER," +
            "price REAL," +
            "image TEXT," +
            "categoryId TEXT," +
            "description TEXT)";

    //Constructor
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE_CART);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS CART");
        // Tạo lại bảng mới
        onCreate(db);
    }

}


