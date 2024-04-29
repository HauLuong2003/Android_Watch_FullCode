package com.example.andorid_watch.Domain.services.Manager;

import android.content.Context;

import com.example.andorid_watch.Domain.services.RetrofitClient;
import com.example.andorid_watch.Domain.services.UserAPIServices;

public class UserManager {
    private final UserAPIServices userAPIServices;
    private Context context;
    public UserManager(Context context) {
        this.context = context;
        userAPIServices = RetrofitClient.getRetrofitInstance().create(UserAPIServices.class);
    }
}
