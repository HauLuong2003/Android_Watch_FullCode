package com.example.andorid_watch.Domain.services.Interface;



import com.example.andorid_watch.Domain.Models.Product;

import java.util.List;

public interface ICartServices {
    boolean insertCart(Product product);
    boolean deleteCart(int id_Product);
    boolean updateCart(Product product);
    List<Product> getAllCart();
    boolean deleteAllCart();
    Product getProductById(String productId);
}
