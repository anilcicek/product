package com.anil.product.controller;

import com.anil.product.base.RequestInfoType;
import com.anil.product.entity.Product;
import com.anil.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") int id){

        return  productService.getProductById(id);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void removeProductById(@PathVariable("id") int id){

          productService.removeProductById(id);
    }

    @RequestMapping(method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody Product product){

        productService.updateProduct(product);
    }

    @RequestMapping(method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertProduct(@RequestBody Product product){

        productService.insertProduct(product);
    }

    @RequestMapping( method = RequestMethod.GET ,value ="/inquireProducts/{searchKey}/{searchVal}")
    public Collection<Product> inquireProductBySearchKey(@PathVariable String searchVal, @PathVariable String searchKey){

        RequestInfoType requestInfoType = new RequestInfoType();
        return productService.inquireProductBySearchKey(searchKey,searchVal,requestInfoType);

    }

    @RequestMapping( method = RequestMethod.GET ,value ="/inquireProductsByPrice/{searchKey}/{searchVal}/{direcion}")
    public Collection<Product> inquireProductsByPrice(@PathVariable String searchVal, @PathVariable String searchKey, @PathVariable String direcion){

        RequestInfoType requestInfoType = new RequestInfoType();
        return productService.inquireProductByPrice(searchKey,searchVal,direcion,requestInfoType);

    }




}
