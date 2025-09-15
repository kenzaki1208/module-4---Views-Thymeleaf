package org.example.demo_views_and_thymeleaf.practice.service;

import org.example.demo_views_and_thymeleaf.practice.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void remove(int id);
    void update(int id, Customer customer);
}
