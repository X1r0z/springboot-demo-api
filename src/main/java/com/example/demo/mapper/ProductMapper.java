package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProductById(Integer id);
    Product selectProductByName(String name);
    List<Product> selectAllProducts();
    int insertProduct(Product product);
    int deleteProductById(Integer id);
    int updateProduct(Product product);
}
