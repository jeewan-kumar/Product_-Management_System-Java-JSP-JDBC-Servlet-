package com.example.servlets;

import com.example.dao.ProductDao;
import com.example.dao.ProductDaoImpl;
import com.example.model.Product;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("serial")
//@WebServlet("/getProductById")
public class GetProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDao productDao = new ProductDaoImpl();
        Product product = null;
        try {
            product = productDao.getProductById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Forward to an error page or handle the exception as needed
            request.setAttribute("errorMessage", "An error occurred while retrieving the product.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }
        if (product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("getProductById.jsp").forward(request, response);
        } else {
            // Product not found, handle appropriately (e.g., redirect or display error message)
            response.sendRedirect("productNotFound.jsp");
        }
    }
}
