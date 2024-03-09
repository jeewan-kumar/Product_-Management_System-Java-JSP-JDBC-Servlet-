package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Product;

public interface ProductDao {
    List<Product> getAllProducts() throws SQLException;
    Product getProductById(int id) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    boolean deleteProduct(int id) throws SQLException;
}
