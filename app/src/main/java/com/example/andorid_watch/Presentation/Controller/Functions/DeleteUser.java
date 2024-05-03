package com.example.andorid_watch.Presentation.Controller.Functions;


import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Domain.services.Interface.IUserServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandUser;

import java.util.List;

public class DeleteUser extends CommandUser {
    private String username;
    public DeleteUser(IUserServices userServices, String username)
    {
        super(userServices);
        this.username = username;
    }
    @Override
    public boolean execute()
    {
        return userServices.deleteUser(username);
    }

    @Override
    public List<UserSQL> getAllUser()
    {
        return null;
    }
}
