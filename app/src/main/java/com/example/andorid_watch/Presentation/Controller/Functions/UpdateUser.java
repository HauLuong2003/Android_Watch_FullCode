package com.example.andorid_watch.Presentation.Controller.Functions;



import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Domain.services.Interface.IUserServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandUser;

import java.util.List;

public class UpdateUser extends CommandUser {
    private UserSQL userSQL;

    public UpdateUser (IUserServices userServices, UserSQL userSQL)
    {
        super(userServices);
        this.userSQL = userSQL;
    }

    //Methods
    @Override
    public boolean execute()
    {
        return userServices.updateUser(userSQL);
    }
    @Override
    public List<UserSQL> getAllUser()
    {
        return null;
    }
}
