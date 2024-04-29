package com.example.andorid_watch.Domain.services.Manager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.andorid_watch.Domain.Models.Category;
import com.example.andorid_watch.Domain.services.CategoryService;
import com.example.andorid_watch.Domain.services.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryManager {
    private CategoryService categoryAPIServices;
    private Context context;
    public CategoryManager(Context context) {
        this.context = context;
        categoryAPIServices = RetrofitClient.getRetrofitInstance().create(CategoryService.class);
    }
    public void getAllCategory( Callback<List<Category>> callback) {
        Call<List<Category>> call = categoryAPIServices.getAllCategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("getAllCategory_Json",response.body().toString());
                    callback.onResponse(call,Response.success(response.body()));
                } else {
                    Toast.makeText(context, "Lấy danh sách sản phẩm thất bại !",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                callback.onFailure(call,t);
            }
        });
    }
}
