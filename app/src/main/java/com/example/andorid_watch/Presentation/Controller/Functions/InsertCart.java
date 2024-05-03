package com.example.andorid_watch.Presentation.Controller.Functions;


import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Presentation.Controller.Command.CommandCart;


import java.util.List;

public class InsertCart extends CommandCart {
    private Product product;

    //Constructor
    public InsertCart(ICartServices cartServices, Product product) {
        super(cartServices);
        this.product = product;
    }

    @Override
    public boolean execute() {
        return cartServices.insertCart(product);
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
