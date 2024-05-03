package com.example.andorid_watch.Respository.Interface;


import com.example.andorid_watch.Domain.Models.Product;

import java.util.List;

public interface ICartRepository {
    boolean insertCart(Product product);
    boolean deleteCart(String id_Product);
    boolean updateCart(Product product);
    List<Product> getAllCart();
    boolean deleteAllCart();
    Product getProductById(String productId);
}
