package com.example.andorid_watch.Domain.services.APIServices;

import com.example.andorid_watch.Domain.Models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("categories")
    Call<List<Category>> getAllCategory();
}
