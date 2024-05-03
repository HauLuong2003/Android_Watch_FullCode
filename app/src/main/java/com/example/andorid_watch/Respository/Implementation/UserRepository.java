package com.example.andorid_watch.Respository.Implementation;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Respository.DB_Helper.DatabaseHelper;
import com.example.andorid_watch.Respository.Interface.IUserRepository;


import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    //Instance Fields
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    //Constructor
    public UserRepository(Context context)
    {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public boolean insertUser(UserSQL user) {
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("fullName",user.getFullName());

        long result = database.insert("USER", null, values);

        if (result != -1)
        {
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) {
        // Xóa giỏ hàng khỏi sqlite
        // Xác định điều kiện xóa dựa trên id_product
        String selection = "userName = ?";
        String[] selectionArgs = { username };

        // Thực hiện xóa sản phẩm từ database
        int rowsDeleted = database.delete("USER", selection, selectionArgs);

        // Kiểm tra xem có sản phẩm nào được xóa không
        if (rowsDeleted > 0) {
            return true; // Xóa thành công
        }
        return false;
    }

    @Override
    public boolean updateUser(UserSQL user) {
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("fullName",user.getFullName());

        int rowsAffeted = database.update("USER",values,"userName = ?",new String[]{user.getUserName()});
        if(rowsAffeted > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public List<UserSQL> getAllUser() {
        //Tạo 1 list để lấy dữ liệu
        List<UserSQL> userList = new ArrayList<>();
        String sql = "SELECT * FROM USER";


        Cursor cursor = database.rawQuery(sql, null);
        if(((Cursor)cursor).moveToFirst())
        {
            do {
                @SuppressLint("Range") UserSQL userSQL = new UserSQL(
                        cursor.getString(cursor.getColumnIndex("userName")),
                        cursor.getString(cursor.getColumnIndex("fullName"))
                );
                userList.add(userSQL);
            }
            while (cursor.moveToNext());
        }
        while (cursor.moveToNext());
        cursor.close();
        return userList;
    }

    @Override
    public boolean deleteAllUser() {
        String sql = "DELETE * FROM USER";
        int check = database.delete("USER",null,null);

        if (check > 0)
        {
            return  true;
        }

        return false;
    }
}
