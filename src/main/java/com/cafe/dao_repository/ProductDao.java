package com.cafe.dao_repository;

import com.cafe.POJO.Product;
import com.cafe.wrapper.ProductWrapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<ProductWrapper> getAllProducts();

    @Modifying
    @Transactional
    Integer updateProductStatus(@Param("status") String status, @Param("id") Integer id);
    //v Producte je na to vytvorená query


    List<ProductWrapper> getProductByCategory(@Param("id") Integer id);
    //v Producte je na to vytvorená query

    ProductWrapper getProductById(@Param("id") Integer id);
    //v Producte je na to vytvorená query


}
