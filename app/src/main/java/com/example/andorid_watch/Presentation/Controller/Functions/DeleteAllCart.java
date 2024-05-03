package com.example.andorid_watch.Presentation.Controller.Functions;



import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandCart;

import java.util.List;

public class DeleteAllCart extends CommandCart {

    public DeleteAllCart(ICartServices cartServices)
    {
        super(cartServices);
    }
    @Override
    public boolean execute() {
        return cartServices.deleteAllCart();
    }

    @Override
    public List<Product> getAllCart() {
        return null;
    }

    @Override
    public Product getProduct() {
        return null;
    }
}
