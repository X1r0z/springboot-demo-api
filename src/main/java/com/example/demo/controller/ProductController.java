package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Result;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public Result getProduct(){
        return this.productService.get();
    }

    @GetMapping("/get/{id}")
    public Result getProduct(@PathVariable("id") Integer id){
        return this.productService.get(id);
    }

    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product){
        return this.productService.add(product);
    }
    @GetMapping("/remove/{id}")
    public Result removeProduct(@PathVariable("id") Integer id){
        return this.productService.remove(id);
    }
    @PostMapping("/update")
    public Result updateProduct(@RequestBody Product product){
        return this.productService.update(product);
    }
}
