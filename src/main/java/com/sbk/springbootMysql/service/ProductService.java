package com.sbk.springbootMysql.service;

import com.sbk.springbootMysql.entity.Product;

import java.util.List;

public interface ProductService  {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
