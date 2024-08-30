package com.booleanuk.api.repositories;

import com.booleanuk.api.models.Product;

import java.util.ArrayList;

public class ProductsRepository {
    private ArrayList<Product> products;

    public ProductsRepository() {
        this.products = new ArrayList<>();
        this.products.add(new Product("Shampoo", "Health", 20));
        this.products.add(new Product("Bread", "Food", 30));
        this.products.add(new Product("Yoghurt", "Food", 15));

    }

    public ArrayList<Product> getAll() {
        return this.products;
    }

    public Product addProduct(Product newProduct) {
        this.products.add(newProduct);
        return newProduct;
    }

    public Product getOne(int id) {
        for (Product product : this.products) {
            if (product.getId()==id) {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct(int id, Product updatedProduct) {
        ArrayList<Product> allProducts = getAll();

        for (Product product : allProducts) {
            if (product.getId() == id) {
                product.setName(updatedProduct.getName());
                product.setCategory(updatedProduct.getCategory());
                product.setPrice(updatedProduct.getPrice());
                return product;
            }
        }
        return null;

    }

    public Product deleteProduct(int id) {
        ArrayList<Product> allProducts = getAll();
        allProducts.removeIf(product -> product.getId() == id);
        return null;
    }


}
