package com.example.andorid_watch.Domain.services.Implementation;

import android.content.Context;


import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Respository.Implementation.CartRepository;
import com.example.andorid_watch.Respository.Interface.ICartRepository;

import java.util.List;

public class CartServices implements ICartServices {

    private ICartRepository cartRepository;
    public CartServices (Context context)
    {
        cartRepository = new CartRepository(context);
    }

    @Override
    public boolean insertCart(Product product) {
        if(product != null)
        {
            return cartRepository.insertCart(product);
        }
        return false;
    }

    @Override
    public boolean deleteCart(String id_Product) {
        if(! id_Product.isEmpty())
        {
            return cartRepository.deleteCart(id_Product);
        }
        return false;
    }

    @Override
    public boolean updateCart(Product product) {
        if(product != null)
        {
            return cartRepository.updateCart(product);
        }
        return false;
    }

    @Override
    public List<Product> getAllCart() {
        return cartRepository.getAllCart();
    }

    @Override
    public boolean deleteAllCart() {
        return cartRepository.deleteAllCart();
    }

    @Override
    public Product getProductById(String productId) {
        if(productId != null)
        {
            return cartRepository.getProductById(productId);
        }
        return null;
    }


}
