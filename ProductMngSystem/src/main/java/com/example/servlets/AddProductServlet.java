package com.example.servlets;

import java.io.IOException;

import com.example.dao.ProductDao;
import com.example.dao.ProductDaoImpl;
import com.example.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);

        ProductDao productDao = new ProductDaoImpl();
        try {
            productDao.addProduct(product);
            response.sendRedirect(request.getContextPath() + "/listProducts.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            
            response.sendRedirect("addProduct.jsp?error=true");
        }
    }
}
