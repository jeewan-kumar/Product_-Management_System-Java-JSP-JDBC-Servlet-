<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
    <h2>Update Product</h2>
    <%-- Display error message if product not found --%>
    <% 
        String error = request.getParameter("error");
        if (error != null && error.equals("notFound")) { 
    %>
        <p style="color: red;">Product not found. Please enter a valid product ID.</p>
    <% } %>
    <form action="updateproduct" method="post">
        <label for="productId">Product ID:</label><br>
        <input type="text" id="productId" name="productId" required><br><br>
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        <label for="description">Description:</label><br>
        <input type="text" id="description" name="description" required><br><br>
        <label for="price">Price:</label><br>
        <input type="number" id="price" name="price" step="0.01" required><br><br>
        <label for="quantity">Quantity:</label><br>
        <input type="number" id="quantity" name="quantity" required><br><br>
        <input type="submit" value="Update Product">
    </form>
</body>
</html>
