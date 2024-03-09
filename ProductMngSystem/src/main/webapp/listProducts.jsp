<%@ page import="java.util.List" %>
<%@ page import="com.example.dao.ProductDao" %>
<%@ page import="com.example.dao.ProductDaoImpl" %>
<%@ page import="com.example.model.Product" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Products</title>
</head>
<body>
    <h2>List of All Products</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <% 
            ProductDao productDao = new ProductDaoImpl();
            List<Product> products = productDao.getAllProducts(); 
            for(Product product : products) {
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getDescription() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getQuantity() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
