//package com.example.andorid_watch.Presentation.Adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.util.Log;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.andorid_watch.Domain.services.Manager.UserManager;
//import com.example.andorid_watch.Presentation.Activity.LoginActivity;
//import com.example.andorid_watch.R;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class LoginAdapter {
//    private Context context;
//    private UserManager userManager;
//    private TextView textViewUsername, textViewPassword;
//    public  LoginAdapter(Context context, UserManager userManager){
//        this.context = context;
//        this.userManager = userManager;
//    }
//    public void login(){
//        //lấy id của giao diện
//        textViewUsername = ((LoginActivity) context).findViewById(R.id.email);
//        textViewPassword = ((LoginActivity) context).findViewById(R.id.password);
//
//        //gán biến
//        String username = textViewUsername.getText().toString();
//        String password = textViewPassword.getText().toString();
//
//        if(username.isEmpty() || password.isEmpty()){
//            Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//        }else {
//            userManager.login(username, password, new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//
//
//                    // Lưu session vào SharedPreferences sau khi đăng nhập thành công
//                    SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("username", username); // Lưu tên người dùng
//                    // Lưu các thông tin khác nếu cần
//                    editor.apply();
//
//
//
//                    //--------- Xử lý sqlite
//                    //Tao doi tuong userSQL
//                    String username = response.body().getUsername();
//                    String fullname = response.body().getFullname();
//
//                    // Kiểm tra có lấy dc dữ liệu k
//                    Log.d("user_fullname_json",username + " and " +fullname);
//                    UserSQL userSQL = new UserSQL(username,fullname);
//
//                    //Thêm đối tượng userSQl vào sqlite
//                    boolean checkResult_Login = commandProcessor.executeUser(new InsertUser(userServices,userSQL));
//
//                    if(checkResult_Login)
//                    {
//                        Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(context, MainActivity.class);
//                        context.startActivity(intent);
//                    }
//                    else
//                    {
//                        Toast.makeText(context, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    Toast.makeText(context, "Quang", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//
//    }
//}
