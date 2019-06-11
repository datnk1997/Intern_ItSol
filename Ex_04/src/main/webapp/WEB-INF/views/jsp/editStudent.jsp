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
	<h1>Edit Student</h1>
	<form action="/editStudent" method="post">
		<input type="hidden" name="id" value="${student.idstudent }">
		<p>Full Name</p>
		<input type="text" name="fname" value="${student.fullname }">
		<p>Email</p>
		<input type="text" name="email" value="${student.email }">
		<p>Phone</p>
		<input type="text" name="phone" value="${student.phone }">
		<p>Class</p>
		<input type="text" name="classs" value="${student.classs}">
		<p>Note</p>
		<input type="text" name="note" value="${student.note }">
		<button>Submit</button>
	</form>
</body>
</html>