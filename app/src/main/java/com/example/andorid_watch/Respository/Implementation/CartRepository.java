package com.example.andorid_watch.Respository.Implementation;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;


import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Respository.DB_Helper.DatabaseHelper;
import com.example.andorid_watch.Respository.Interface.ICartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartRepository implements ICartRepository {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    //Constructor
    public CartRepository(Context context){
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public boolean insertCart(Product product) {
        // Thêm gio hàng vào sqlite
        // Prepared Statement giống ContentValues
        // values put theo key và value
        ContentValues values = new ContentValues();
        values.put("id_product",product.getId());
        values.put("name_product",product.getName());
        values.put("price",product.getPrice());
        values.put("image",product.getImage());
        values.put("description",product.getDescription());

        long result = database.insert("CART", null, values);

        // Kiểm tra có thêm thành công ko
        if (result != -1)
        {
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteCart(int id_Product) {
        // Xóa giỏ hàng khỏi sqlite
        // Xác định điều kiện xóa dựa trên id_product
        String selection = "id_product = ?";
        String[] selectionArgs = {String.valueOf(id_Product)};

        // Thực hiện xóa sản phẩm từ database
        int rowsDeleted = database.delete("CART", selection, selectionArgs);

        // Kiểm tra xem có sản phẩm nào được xóa không
        if (rowsDeleted > 0) {
            return true; // Xóa thành công
        }
        return false; // Không có sản phẩm nào được xóa
    }


    @Override
    public boolean updateCart(Product product) {
        ContentValues values = new ContentValues();
        values.put("id_product",product.getId());
        values.put("name_product",product.getName());
        values.put("price",product.getPrice());
        values.put("image",product.getImage());
        values.put("description",product.getDescription());


        int rowsAffected = database.update("CART", values, "id_product = ?", new String[]{String.valueOf(product.getId())});
        if(rowsAffected > 0)
        {
            return  true;
        }
        return false;
    }

    @Override
    public List<Product> getAllCart() {
        //ResultSet
        // Tạo 1 list chứa các dữ liệu
        List<Product> productList = new ArrayList<>();

        //Lệnh truy vấn
        String sql = "SELECT * FROM CART";
        Cursor cursor = database.rawQuery(sql, null);
        if (((Cursor) cursor).moveToFirst())
        {
            do {
                @SuppressLint("Range") Product product = new Product(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name_product")),
                    cursor.getDouble(cursor.getColumnIndex("price")),
                    cursor.getString(cursor.getColumnIndex("image")),
                    cursor.getString(cursor.getColumnIndex("description"))
                );
                productList.add(product);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        //rs.close();
        return productList;
    }

    @Override
    public boolean deleteAllCart() {
        String sql = "DELETE * FROM CART";
        int check = database.delete("CART",null,null);

        if (check > 0)
        {
            return  true;
        }

        return false;
    }

    @SuppressLint("Range")
    @Override
    public Product getProductById(String productId) {
        Cursor cursor = null;
        Product product = null;

        try {
            String selection = "id_product = ?";
            String[] selectionArgs = {productId};

            cursor = database.query("CART", null, selection, selectionArgs, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                // Lấy thông tin của sản phẩm từ Cursor

                product = new Product(
                        cursor.getInt(cursor.getColumnIndex("id_product")),
                        cursor.getString(cursor.getColumnIndex("name_product")),
                        cursor.getDouble(cursor.getColumnIndex("price")),
                        cursor.getString(cursor.getColumnIndex("image")),
                        cursor.getString(cursor.getColumnIndex("description"))
                );
            }
        } catch (SQLiteException e) {
            Log.e("Sql_Error_getProductById", "Error while getting product by id: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return product;
    }
}
