package com.example.andorid_watch.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.andorid_watch.Domain.services.Manager.ProductManager;
import com.example.andorid_watch.Presentation.Adapter.AdapterProduct;
import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.R;
import com.example.andorid_watch.Domain.services.ProductService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private ImageView image1,image2,image3,image4,image5;
    private String categoryId;

    private RecyclerView mRecyclerView;
    private AdapterProduct mAdapter;
    private ProductManager productManager;
    private List<Product> mProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // khai báo đối tượng productManager
        productManager = new ProductManager(this);
        mAdapter = new AdapterProduct(this,productManager);
        mAdapter.loadProduct();

        setUpLink();
        mRecyclerView = findViewById(R.id.view1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProductList = new ArrayList<>();
        mRecyclerView.setAdapter(mAdapter);
        //------------- Xử lý load theo danh mục
        //Lấy id của các category
        image1 =findViewById(R.id.image_1);
        image2 =findViewById(R.id.image_2);
        image3 =findViewById(R.id.image_3);
        image4 =findViewById(R.id.image_4);
        image5 =findViewById(R.id.image_5);
//     xu ly su kien
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryId = "1";
                mAdapter.loadProductByCategory(categoryId);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryId = "2";
                mAdapter.loadProductByCategory(categoryId);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryId = "3";
                mAdapter.loadProductByCategory(categoryId);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryId = "4";
                mAdapter.loadProductByCategory(categoryId);
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryId = "5";
                mAdapter.loadProductByCategory(categoryId);
            }
        });

        EditText search =findViewById(R.id.search);
        search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    String keyword = search.getText().toString().trim(); // Lấy từ khóa tìm kiếm và loại bỏ các khoảng trắng thừa
                    mAdapter.searchProducts(keyword);
                    return true;
                }
                return false;
            }
        });


    }
//phương thức tạo intent
    private void setUpLink() {
        ImageView imageView = findViewById(R.id.image_Login);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                direct(LoginActivity.class);
            }
        });
        ImageView imageRegister = findViewById(R.id.image_Register);

        imageRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                direct(SignUp.class);
            }
        });
        ImageView cart1 = findViewById(R.id.image_Cart);

        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                direct(CartActivity.class);

            }
        });
        ImageView image_profile = findViewById(R.id.image_profile);

        image_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                direct(ProfileActivity.class);
            }
        });
    }
    //Hàm direct để chuyển hướng
    private void direct(Class cls)
    {
        intent = new Intent(MainActivity.this,cls);
        startActivity(intent);
    }
}