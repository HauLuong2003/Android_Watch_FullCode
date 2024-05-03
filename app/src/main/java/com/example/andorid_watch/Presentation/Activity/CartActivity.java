package com.example.andorid_watch.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.andorid_watch.Presentation.Adapter.AdapterCart;
import com.example.andorid_watch.Respository.DB_Helper.DatabaseHelper;
import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.R;
import com.example.andorid_watch.Domain.services.APIServices.ProductService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterCart mAdapter;
    private DatabaseHelper dbHelper;
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mRecyclerView = findViewById(R.id.view_cart);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new DatabaseHelper(this);



        ImageView imageView = findViewById(R.id.image_arrow);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        getBundle(); // Call the method to fetch product data
    }

    protected void getBundle() {
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("productId")) {
            int productId = intent.getIntExtra("productId", -1);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/WebsiteWatch/rest/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ProductService productService = retrofit.create(ProductService.class);
            Call<Product> call = productService.getById(productId);
            call.enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> response) {
                    if (response.isSuccessful()) {
                        Product product = response.body();

                        mRecyclerView.setAdapter(mAdapter);
                    }
                }

                @Override
                public void onFailure(Call<Product> call, Throwable t) {
                    System.out.println("error: " + t.getMessage());
                }
            });
        }
    }


}
