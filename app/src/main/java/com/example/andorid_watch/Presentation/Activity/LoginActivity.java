package com.example.andorid_watch.Presentation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andorid_watch.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView = findViewById(R.id.text_Resgister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                Intent intent = new Intent(LoginActivity.this, SignUp.class);

                // Khởi động Activity mới bằng Intent
                startActivity(intent);
            }
        });
        ImageView imageView = findViewById(R.id.image_arrow);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở Activity mới
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                // Khởi động Activity mới bằng Intent
                startActivity(intent);
            }
        });
    }
}