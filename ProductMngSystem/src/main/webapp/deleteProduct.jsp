<%@ page import="com.example.dao.ProductDao" %>
<%@ page import="com.example.dao.ProductDaoImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Product Details</title>
</head>
<body>
    <h2>Delete Product Details by ID</h2>
    <form action="deleteProduct.jsp" method="post">
        Enter ID: <input type="text" name="productId">
        <input type="submit" value="Delete">
    </form>
    
    <% 
    String id = request.getParameter("productId");
    if(id != null && !id.isEmpty()) {
        try {
            int productId = Integer.parseInt(id);
            ProductDao dao = new ProductDaoImpl();
            boolean deleted = dao.deleteProduct(productId);
            
            if(deleted) {
    %>
                <p>Product with ID <%= productId %> has been deleted successfully.</p>
    <% 
            } else {
    %>
                <p>Failed to delete product with ID <%= productId %>.</p>
    <% 
            }
        } catch (NumberFormatException e) {
    %>
            <p>Error: Invalid ID format. Please enter a valid integer ID.</p>
    <% 
        } catch (Exception e) {
            e.printStackTrace();
    %>
            <p>Error occurred: <%= e.getMessage() %></p>
    <% 
        }
    }
    %>
</body>
</html>
