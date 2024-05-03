package com.example.andorid_watch.Presentation.Controller.Functions;



import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandCart;

import java.util.List;

public class ListCart extends CommandCart {
    public ListCart(ICartServices cartServices)
    {
        super(cartServices);
    }

    @Override
    public boolean execute()
    {
        return false;
    }

    @Override
    public List<Product> getAllCart()
    {
        return cartServices.getAllCart();
    }

    @Override
    public Product getProduct() {
        return null;
    }
}
