package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Product;
import com.booleanuk.api.repositories.ProductsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("products")
public class ProductsController {
    private ProductsRepository theProducts;


    public ProductsController() {
        this.theProducts = new ProductsRepository();
    }

    @GetMapping
    public ArrayList<Product> getAllProducts(){
        return this.theProducts.getAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product newProduct) {
        return this.theProducts.addProduct(newProduct);
    }

    @GetMapping("{id}")
    public Product getSpecificProduct(@PathVariable int id) {
        return this.theProducts.getOne(id);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updateProduct) {
        return theProducts.updateProduct(id, updateProduct);
    }

    @DeleteMapping("{id}")
    public Product deleteProduct(@PathVariable int id) {
        return theProducts.deleteProduct(id);
    }


}
