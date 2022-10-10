<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Relationship Management </title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">CustomerManagement</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container">
		<h3>Customer Record</h3>
		<form action="/CustomerManagement/customer/save" method="POST">
			<input type="hidden" name="id" value="${customer.id}" />
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">FirstName</label> 
				<input type="text" name="firstName" value="${customer.firstName}"
					class="form-control" id="exampleInputEmail1">

			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">LastName</label>
				<input type="text" name="lastName" value="${customer.lastName}"
				    class="form-control" id="exampleInputPassword1">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Email</label>
				<input type="text" name="email" value="${customer.email }"
					class="form-control" id="exampleInputPassword1" >
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>