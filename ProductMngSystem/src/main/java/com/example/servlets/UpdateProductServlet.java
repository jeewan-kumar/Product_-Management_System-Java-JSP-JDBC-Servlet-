package com.example.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.example.dao.ProductDao;
import com.example.dao.ProductDaoImpl;
import com.example.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String newName = request.getParameter("name");
        String newDescription = request.getParameter("description");
        double newPrice = Double.parseDouble(request.getParameter("price"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDao productDao = new ProductDaoImpl();
        Product existingProduct = null;
        try {
            existingProduct = productDao.getProductById(productId);
            if (existingProduct != null) {
                // Update the existing product
                existingProduct.setName(newName);
                existingProduct.setDescription(newDescription);
                existingProduct.setPrice(newPrice);
                existingProduct.setQuantity(newQuantity);
                productDao.updateProduct(existingProduct);
                // Redirect to a success page or display a success message
                response.sendRedirect("updateSuccess.jsp");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Product not found or an error occurred, redirect to updateProduct.jsp with error message
        response.sendRedirect("updateProduct.jsp?error=notFound");
    }
}
