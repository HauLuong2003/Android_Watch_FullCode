package com.example.andorid_watch.Domain.services.Manager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.APIServices.ProductService;
import com.example.andorid_watch.Domain.services.APIServices.RetrofitClient;
import com.google.gson.Gson;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductManager {
    private final ProductService productAPIServices;
    private Context context;

    public ProductManager(Context context) {
        this.context = context;
        productAPIServices = RetrofitClient.getRetrofitInstance().create(ProductService.class);
    }

    public void getAllProduct(Callback<List<Product>> callback) {
        Call<List<Product>> call = productAPIServices.getAll();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("getAllProduct_Json", response.body().toString());
                    callback.onResponse(call, Response.success(response.body()));
                } else {
                    Toast.makeText(context, "Lấy danh sách sản phẩm thất bại !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getProductById(String productId, Callback<Product> callback) {
        Call<Product> call = productAPIServices.getById(Integer.parseInt(productId));
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("getProductById_Json", response.body().toString());
                    callback.onResponse(call, Response.success(response.body()));
                } else {
                    Toast.makeText(context, "Lấy sản phẩm thất bại !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    ///Xem danh sách sản phẩm trong category
    public void getProductInCategory(String cid, Callback<List<Product>> callback) {
        Call<List<Product>> call = productAPIServices.getProductInCategory(cid);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    Log.d("getProductByCategory_Json", new Gson().toJson(response.body()));
                    callback.onResponse(call, Response.success(response.body()));
                } else {
                    Toast.makeText(context, "Lấy danh sách sản phẩm thất bại !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
    public void searchProducts(String keyword,Callback<List<Product>> callback) {
        Call<List<Product>> call = productAPIServices.Search(keyword);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponse(call, Response.success(response.body()));
                }
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, "tim kiem that bai!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
