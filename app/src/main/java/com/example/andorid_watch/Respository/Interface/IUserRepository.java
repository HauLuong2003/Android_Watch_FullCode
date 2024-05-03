package com.example.andorid_watch.Respository.Interface;


import com.example.andorid_watch.Domain.Models.UserSQL;

import java.util.List;

public interface IUserRepository {
    boolean insertUser(UserSQL user);
    boolean deleteUser(String username);
    boolean updateUser(UserSQL user);
    List<UserSQL> getAllUser();

    boolean deleteAllUser();
}
