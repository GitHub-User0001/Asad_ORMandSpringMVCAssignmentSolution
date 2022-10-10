<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Relationship Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<%-- <p>${customer }</p>--%>
	<div>

		<a href="/CustomerManagement/customer/add">Add Customer</a>

	</div>
	<table class="table">
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${customer}" var="customer">
			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td><a
					href="/CustomerManagement/customer/update?customerId=${customer.id}">Update</a>


					<a
					href="/CustomerManagement/customer/delete?customerId=${customer.id}"
					onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>