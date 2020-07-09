package com.anil.product.command;

import com.anil.product.base.GeneralEnumaration;
import com.anil.product.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductSearchByPriceTest {

    @Test
    void getProductByPrice() {

        Map<Integer, Product> products = new HashMap<>();

        products.put(1,new Product(1,"Gozluk",12,"ACCESSORY"));
        products.put(2,new Product(2,"Tshirt",22,"CLOTHING"));
        products.put(3,new Product(3,"Kot",32,"CLOTHING"));

        if(GeneralEnumaration.ProductPriceSearchDirection.GREATER.getDirection().equals("GREATER")){

            List<Product> filteredList = products.values().stream().filter(p -> 25< p.getPrice()).collect(Collectors.toList());

        }else if(GeneralEnumaration.ProductPriceSearchDirection.LESS.getDirection().equals("LESS")){

            List<Product> filteredList = products.values().stream().filter(p -> 28> p.getPrice()).collect(Collectors.toList());
        }
    }
}