package com.example.andorid_watch.Domain.services;



import com.example.andorid_watch.Domain.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductService {

    @GET("products")
    Call<List<Product>> getAll();

    @GET("products/{id}")
     Call<Product> getById(@Path("id") int id);

    @GET("category/{id}")
    Call<Void> getProductCateID();
    @GET("product")
    Call<List<Product>> Search(@Query("search")String search);
    @GET("products/category/{id}")
    Call<List<Product>> getProductInCategory(@Path("id") String id);

}
