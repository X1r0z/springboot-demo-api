package com.example.demo.service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Result get(){
        return new Result(this.productMapper.selectAllProducts());
    }

    public Result get(Integer id){
        Product product = this.productMapper.selectProductById(id);
        if (product != null){
            return new Result(product);
        } else {
            return new Result(-1, "product doesn't exist");
        }
    }
    public Result get(String name){
        Product product = this.productMapper.selectProductByName(name);
        if (product != null){
            return new Result(product);
        } else {
            return new Result(-1, "product doesn't exist");
        }
    }
    public Result add(Product product){
        if (this.productMapper.selectProductByName(product.getName()) == null){
            if (product.getName() != null && product.getDesc() != null){
                return new Result(this.productMapper.insertProduct(product));
            } else {
                return new Result(-1, "name or desc can't be null");
            }
        } else {
            return new Result(-1, "product has already existed");
        }
    }

    public Result remove(Integer id){
        if (this.productMapper.selectProductById(id) != null){
            return new Result(this.productMapper.deleteProductById(id));
        } else {
            return new Result(-1,"product doesn't exist");
        }
    }

    public Result update(Product product){
        if (this.productMapper.selectProductById(product.getId()) != null){
            if (product.getName() != null && product.getDesc() != null){
                return new Result(this.productMapper.updateProduct(product));
            } else {
                return new Result(-1, "name or desc can't be null");
            }
        } else {
            return new Result(-1,"product doesn't exist");
        }

    }
}

