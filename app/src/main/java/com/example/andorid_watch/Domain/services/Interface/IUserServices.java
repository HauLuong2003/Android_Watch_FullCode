package com.example.andorid_watch.Domain.services.Interface;



import com.example.andorid_watch.Domain.Models.UserSQL;

import java.util.List;

public interface IUserServices {
    boolean insertUser(UserSQL user);
    boolean deleteUser(String userName);
    boolean updateUser(UserSQL user);
    List<UserSQL> getAllUser();
    boolean deleteAllUser();
}
