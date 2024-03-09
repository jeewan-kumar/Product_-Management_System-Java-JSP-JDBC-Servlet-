<%@ page import="com.example.dao.ProductDao" %>
<%@ page import="com.example.dao.ProductDaoImpl" %>
<%@ page import="com.example.model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find Product By ID</title>
</head>
<body>
    <h2>Find Product By ID</h2>
    <form action="" method="get">
        <label for="productId">Enter Product ID:</label><br>
        <input type="text" id="productId" name="productId" required><br><br>
        <input type="submit" value="Find">
    </form>

    <%-- Display product information if found --%>
    <% 
    String productIdParam = request.getParameter("productId");
    if (productIdParam != null && !productIdParam.isEmpty()) {
        int productId = Integer.parseInt(productIdParam);
        ProductDao productDao = new ProductDaoImpl();
        Product product = productDao.getProductById(productId); 
        if (product != null) { 
%>
    <h3>Product Details:</h3>
    <p>ID: <%= product.getId() %></p>
    <p>Name: <%= product.getName() %></p>
    <p>Description: <%= product.getDescription() %></p>
    <p>Price: <%= product.getPrice() %></p>
    <p>Quantity: <%= product.getQuantity() %></p>
<% 
        } else {
            // Handle case where product is not found
            out.println("Product not found.");
        }
    } else {
        // Handle case where product ID parameter is not provided
        out.println("Product ID parameter is missing.");
    }
%>
    
    <%-- Display error message if product is not found --%>
    <% 
        String errorMessage = (String) request.getAttribute("errorMessage"); 
        if (errorMessage != null) { 
    %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>
</body>
</html>
