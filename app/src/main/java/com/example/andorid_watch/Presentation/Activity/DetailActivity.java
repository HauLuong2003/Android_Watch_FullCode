package com.example.andorid_watch.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andorid_watch.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView name;
    TextView  price;
    ImageView image;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name = findViewById(R.id.productName);
        price = findViewById(R.id.productPrice);
        image = findViewById(R.id.productImage);
        description = findViewById(R.id.productDescription);

        ImageView imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();

        if (intent != null ) {

            int productId = intent.getIntExtra("PRODUCT_ID", -1); //nếu không có id trả về -1
            String productName = intent.getStringExtra("PRODUCT_NAME");
            Double productPrice = intent.getDoubleExtra("PRODUCT_PRICE",0);
            String productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION");
            String image1 = intent.getStringExtra("PRODUCT_IMAGE");
            // Hiển thị thông tin sản phẩm trên giao diện
            name.setText(productName);
            price.setText(String.valueOf(productPrice));
            String imageUrl =image1;
            Picasso.get().load(imageUrl).into(image);
            description.setText(productDescription);



        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                // Khởi động Activity mới bằng Intent
                startActivity(intent);
            }
        });
    }

}