package com.anil.product.dao;

import com.anil.product.entity.Product;

import java.util.Collection;

public interface IProductDao {
    Collection<Product> getAllProducts();

    Product getProductById(int id);

    void removeProductById(int id);

    void updateProduct(Product product);

    void insertProduct(Product product);
}
