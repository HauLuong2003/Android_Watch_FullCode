package com.example.andorid_watch.Presentation.Controller.Functions;



import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandCart;

import java.util.List;

public class GetProductById extends CommandCart {
    private String productId;
    public GetProductById(ICartServices cartServices, String productId)
    {
        super(cartServices);
        this.productId = productId;
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public List<Product> getAllCart() {
        return null;
    }

    @Override
    public Product getProduct() {
        return cartServices.getProductById(productId);
    }
}
