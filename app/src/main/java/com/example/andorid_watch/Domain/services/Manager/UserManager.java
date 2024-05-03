package com.example.andorid_watch.Domain.services.Manager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.andorid_watch.Domain.Models.LoginRequest;
import com.example.andorid_watch.Domain.Models.User;
import com.example.andorid_watch.Domain.services.APIServices.RetrofitClient;
import com.example.andorid_watch.Domain.services.APIServices.UserAPIServices;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserManager {
    private final UserAPIServices userAPIServices;
    private Context context;
    public UserManager(Context context) {
        this.context = context;
        userAPIServices = RetrofitClient.getRetrofitInstance().create(UserAPIServices.class);
    }
    public void createUser(User user, Callback<User> callback) {
        Call<User> call = userAPIServices.createUser(user);
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("createUser_Json", new Gson().toJson(response.body()));
                    Toast.makeText(context, "Đăng ký thành công !",Toast.LENGTH_SHORT).show();
                    callback.onResponse(call, Response.success(response.body()));
                } else {

                    Toast.makeText(context, "Đăng ký thất bại !",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(call,t);
            }
        });
    }
    public void login(String username, String password, Callback<User> callback) {
        Call<User> call = userAPIServices.loginUser(new LoginRequest(username,password));
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("login_Json",new Gson().toJson(response.body()));
                    callback.onResponse(call, Response.success(response.body()));
                } else {
                    Toast.makeText(context, "Đăng nhập thất bại !",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(call,t);
            }
        });
    }
    public void getUserInfor(String userName, Callback<User> callback){
        // Gọi API để lấy thông tin người dùng
        Call<User> call = userAPIServices.getUserInfor(userName);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Gọi callback onResponse() với thông tin người dùng
                    Log.d("getUserInfor_Json", new Gson().toJson(response.body()));
                    callback.onResponse(call, response);
                } else {
                    // Gọi callback onFailure() nếu không có dữ liệu hoặc lỗi
                    callback.onFailure(call, new Throwable("Lấy thông tin cá nhân thất bại!"));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Gọi callback onFailure() nếu xảy ra lỗi trong quá trình gọi API
                callback.onFailure(call, t);
            }
        });
    }
    public  void updateUserInfor(String userName,User user ,Callback<User> callback){
        Call<User> call = userAPIServices.updateUserInfor(userName,user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    Log.d("updateInfor_Json", new Gson().toJson(response.body()));
//                    callback.onResponse(call, Response.success(response.body()));
//                } else {
//                    Toast.makeText(context, "Cập nhật thất bại !",Toast.LENGTH_SHORT).show();
//                }
                Log.d("updateInfor_Json", new Gson().toJson(response.body()));
                callback.onResponse(call, Response.success(response.body()));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(call,t);
            }
        });
    }
}
