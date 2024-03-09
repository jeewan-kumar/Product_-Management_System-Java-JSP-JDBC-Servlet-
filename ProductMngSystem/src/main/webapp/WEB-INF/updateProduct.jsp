<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Update Product</title>
</head>
<body>
	<h2>Update Product</h2>
    <form action="updateProduct" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <label>Name:</label> <input type="text" name="name" value="${product.name}" required><br>
        <label>Description:</label> <input type="text" name="description" value="${product.description}"><br>
        <label>Price:</label> <input type="text" name="price" value="${product.price}" required><br>
        <label>Quantity:</label> <input type="text" name="quantity" value="${product.quantity}" required><br>
        <input type="submit" value="Update Product">
    </form>
    <a href="listProducts">Back to List</a>
</body>
</html>