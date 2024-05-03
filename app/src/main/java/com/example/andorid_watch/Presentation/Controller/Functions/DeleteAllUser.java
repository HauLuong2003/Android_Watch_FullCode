package com.example.andorid_watch.Presentation.Controller.Functions;



import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Domain.services.Interface.IUserServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandUser;

import java.util.List;

public class DeleteAllUser extends CommandUser {

    public DeleteAllUser(IUserServices userServices)
    {
        super(userServices);
    }
    @Override
    public boolean execute() {
        return userServices.deleteAllUser();
    }

    @Override
    public List<UserSQL> getAllUser() {
        return null;
    }
}
