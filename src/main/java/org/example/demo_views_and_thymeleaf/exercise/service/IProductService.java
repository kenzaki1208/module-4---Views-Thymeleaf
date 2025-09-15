package org.example.demo_views_and_thymeleaf.exercise.service;

import org.example.demo_views_and_thymeleaf.exercise.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void remove(int id);
    void update(int id, Product product);
}
