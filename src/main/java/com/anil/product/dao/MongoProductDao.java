package com.anil.product.dao;

import com.anil.product.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoProductDao implements IProductDao {

    Connection mongoConnection;

    @Override
    public Collection<Product> getAllProducts() {
        return new ArrayList<Product>(){
            {
                add(new Product(1,"Gozluk","12","A"));
            }

        };
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void removeProductById(int id) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void insertProduct(Product product) {

    }
}
