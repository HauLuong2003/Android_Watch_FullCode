package com.example.andorid_watch.Presentation.Controller.Command;



import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.Models.UserSQL;

import java.util.List;

public class CommandProcessor {
    public boolean executeCart(CommandCart commandCart)
    {
        return commandCart.execute();
    }
    public boolean executeUser(CommandUser commandUser)
    {
        return commandUser.execute();
    }
    public List<Product> getAllCart(CommandCart commandCart)
    {
        return commandCart.getAllCart();
    }
    public List<UserSQL> getAllUser(CommandUser commandUser)
    {
        return commandUser.getAllUser();
    }
    public Product getProduct(CommandCart commandCart)
    {
        return commandCart.getProduct();
    }
}
