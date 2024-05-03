package com.example.andorid_watch.Presentation.Controller.Command;



import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;

import java.util.List;

public abstract class CommandCart {
    protected ICartServices cartServices;

    public CommandCart(ICartServices cartServices)
    {
        this.cartServices = cartServices;
    }
    //Methods
    public abstract boolean execute();
    public abstract List<Product> getAllCart();
    public abstract Product getProduct();

}
