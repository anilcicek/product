package com.anil.product.dao;

import com.anil.product.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



@Repository
@Qualifier("productData")
public class ProductDao implements IProductDao {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<Integer,Product>(){
            {
                put(1,new Product(1,"Gozluk",12,"ACCESSORY"));
                put(2,new Product(2,"Tshirt",22,"CLOTHING"));
                put(3,new Product(3,"Kot",32,"CLOTHING"));
                put(4,new Product(4,"Saat",15,"ACCESSORY"));
                put(5,new Product(5,"Çanta",60,"BAG"));
                put(6,new Product(6,"Parfüm",80,"ACCESSORY"));
                put(7,new Product(7,"Ayakakbi",120,"SHOE"));
            }
        };

    }

    @Override
    public Collection<Product> getAllProducts(){
        return this.products.values();
    }

    @Override
    public  Product getProductById(int id){

        return this.products.get(id);
    }

    @Override
    public  void removeProductById(int id){

         this.products.remove(id);
    }

    @Override
    public void updateProduct(Product product){
        Product prod = new Product();
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        products.put(product.getId(),product);

    }

    @Override
    public  void insertProduct(Product product){

        products.put(product.getId(),product);
    }
}
