package com.sbk.springbootMysql.repository;

import com.sbk.springbootMysql.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // create product
        Product product = new Product();
        product.setName("product1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("productx.png");
        // save product
        Product savedObject = productRepository.save(product);
        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
    @Test
    void updateUsingSave(){
        // find or retrieve an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        // update entity information
        product.setName("Laptop updated");
        product.setPrice(new BigDecimal(5000));
        // save updated entity
        productRepository.save(product);
    }
    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }
    @Test
    void deleteByIdMethod(){
        Long id = 6L;
        productRepository.deleteById(id);
    }
    @Test
    void deleteMethod(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription
                ("Kitt_with_fil", "Kitt description 6/12.3/6/");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}





























