package com.example.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.example.dao.ProductDao;
import com.example.dao.ProductDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/deleteproduct")
public class DeletProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");
        
        if (productIdStr == null || productIdStr.isEmpty()) {
            // Handle case where productId parameter is missing
            response.sendRedirect("deleteProduct.jsp?error=missingProductId");
            return;
        }

        try {
            int productId = Integer.parseInt(productIdStr);
            ProductDao productDao = new ProductDaoImpl();
            boolean deleted = productDao.deleteProduct(productId);

            if (deleted) {
                // Product deleted successfully
                response.sendRedirect("deleteSuccess.jsp");
            } else {
                // Product not found or deletion failed
                response.sendRedirect("deleteProduct.jsp?error=productNotFound");
            }
        } catch (NumberFormatException e) {
            // Handle case where productId parameter is not a valid integer
            response.sendRedirect("deleteProduct.jsp?error=invalidProductId");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
