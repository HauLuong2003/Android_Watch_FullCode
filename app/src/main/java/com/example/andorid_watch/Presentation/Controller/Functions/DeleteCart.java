package com.example.andorid_watch.Presentation.Controller.Functions;



import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandCart;

import java.util.List;

public class DeleteCart extends CommandCart {
    private String productId;

    //Constructor
    public DeleteCart(ICartServices cartServices, String productId)
    {
        super(cartServices);
        this.productId = productId;
    }

    @Override
    public boolean execute()
    {
        return cartServices.deleteCart(productId);
    }
    @Override
    public List<Product> getAllCart()
    {
        return  null;
    }

    @Override
    public Product getProduct() {
        return null;
    }
}
