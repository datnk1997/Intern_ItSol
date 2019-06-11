<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Student</h1>
	<form action="createStudent" method="post">
		<p>Full Name</p>
		<input type="text" name="fname">
		<p>Email</p>
		<input type="text" name="email">
		<p>Phone</p>
		<input type="text" name="phone">
		<p>Class</p>
		<select name="classs">
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
		</select>
		<p>Note</p>
		<input type="text" name="note">
		<button>Submit</button>
	</form>
</body>
</html>