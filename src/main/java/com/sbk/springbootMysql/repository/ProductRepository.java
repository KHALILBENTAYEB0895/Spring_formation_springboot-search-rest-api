package com.sbk.springbootMysql.repository;

import com.sbk.springbootMysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
      @Query("SELECT p FROM Product p WHERE "+
              " p.name LIKE CONCAT('%',:query,'%')"+
              "OR p.description LIKE CONCAT('%',:query,'%')")
    List<Product> searchProducts(String query);
    @Query(value = "SELECT * FROM products p WHERE "+
            " p.name LIKE CONCAT('%',:query,'%')"+
            "OR p.description LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<Product> searchProductsSQL(String query);

    List<Product> findByNameOrDescription(String name, String description);
}