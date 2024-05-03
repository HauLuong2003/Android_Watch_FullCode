package com.example.andorid_watch.Domain.services.Implementation;

import android.content.Context;


import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Domain.services.Interface.IUserServices;
import com.example.andorid_watch.Respository.Implementation.UserRepository;
import com.example.andorid_watch.Respository.Interface.IUserRepository;

import java.util.List;

public class UserServices implements IUserServices {
    private IUserRepository userRepository;
    public  UserServices(Context context)
    {
        userRepository = (IUserRepository) new UserRepository(context);
    }
    @Override
    public boolean insertUser(UserSQL user) {
        if(user != null)
        {
            return userRepository.insertUser(user);
        }
        return false;
    }

    @Override
    public boolean deleteUser(String userName) {
        if(!userName.isEmpty())
        {
            return userRepository.deleteUser(userName);
        }
        return false;
    }

    @Override
    public boolean updateUser(UserSQL user) {
        if(user!= null){
            return userRepository.updateUser(user);
        }
        return false;
    }

    @Override
    public List<UserSQL> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public boolean deleteAllUser() {
        return userRepository.deleteAllUser();
    }
}
