<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
	<h2>Add Product</h2>
    <form action="addproduct" method="post">
    	<label>ID:</label> <input type="text" name="id" required><br>
        <label>Name:</label> <input type="text" name="name" required><br>
        <label>Description:</label> <input type="text" name="description"><br>
        <label>Price:</label> <input type="text"name="price" required><br>
        <label>Quantity:</label> <input type="text" name="quantity" required><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>