<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Account List</h1>
		<table border="1">

			<th>Account Number</th>
			<th>Amount</th>
			<th>Account Type</th>
			<th>User Id</th>
			
			<c:forEach var="account" items="${listAccount}">
				<tr>

					<td>${account.accountNum}</td>
					<td>${account.amount}</td>
					<td>${account.accountType}</td>
					<td>${account.userId}</td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/><a href="/">Go to Login</a>
	</div>
</body>
</html>