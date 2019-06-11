<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<form action="checkAccount" method="POST">
		<p>Account</p> <input type="text" name="account">
		<p>FirstName</p> <input type="text" name="firstname">
		<p>LastName</p> <input type="text" name="lastname">
		<p>Email</p> <input type="text" name="email">
		<br/><br/><button>Submit</button>
	</form>
	<h3>${mess}</h3>

</body>
</html>