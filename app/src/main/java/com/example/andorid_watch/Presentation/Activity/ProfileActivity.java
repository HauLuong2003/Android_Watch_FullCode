package com.example.andorid_watch.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.andorid_watch.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView imageView = findViewById(R.id.image_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);

                // Khởi động Activity mới bằng Intent
                startActivity(intent);
            }
        });
    }
}