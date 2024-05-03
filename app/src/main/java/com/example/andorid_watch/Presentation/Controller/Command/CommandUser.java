package com.example.andorid_watch.Presentation.Controller.Command;



import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Domain.services.Interface.IUserServices;

import java.util.List;

public abstract class CommandUser {
    protected IUserServices userServices;
    public CommandUser(IUserServices userServices)
    {
        this.userServices = userServices;
    }
    public abstract boolean execute();
    public abstract List<UserSQL> getAllUser();
}
