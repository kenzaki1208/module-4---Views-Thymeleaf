package org.example.demo_views_and_thymeleaf.exercise.service;

import org.example.demo_views_and_thymeleaf.exercise.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone XVI", 20000000, "iphone XVI is the best choice",20));
        products.put(2, new Product(2, "xiaomi redmit note 12", 24000000,"xiaomi never let you down", 12));
        products.put(3, new Product(3, "Samsung Galaxy S12", 30000000,"Samsung always on top", 9));
        products.put(4, new Product(4, "OPPO Reno Series 5G", 32000000,"oppo is the choice cannot to be missed", 17));
        products.put(5, new Product(5, "Huawei Pura 70 Ultra", 36000000,"Huawei is always the first choice", 16));
        products.put(6, new Product(6, "ASUS ROG phone 7", 40000000,"Asus is the top choice", 3));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }
}
