<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<form action="searchStudent">
		<br /> <input type="text" name="search" />
		<button>Search</button>
		<br /> ${mess }
	</form>
	<form action="filterClass">
		<p>Filter</p>
		<select name="classs">
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
		</select>
		<button>OK</button>
	</form>
	<table border="1">

		<tr>
			<th>ID</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Class</th>
			<th>Note</th>
		</tr>
		<c:forEach items="${liststu }" var="lsstu">
			<tr>
				<td>${lsstu.idstudent}</td>
				<td>${lsstu.fullname}</td>
				<td>${lsstu.email}</td>
				<td>${lsstu.phone}</td>
				<td>${lsstu.classs}</td>
				<td>${lsstu.note}</td>
				<td><a
					href="<c:url value='/editStudent/${lsstu.idstudent }' />">Edit</a></td>
				<td><a
					href="<c:url value='/deleteStudent/${lsstu.idstudent }' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/createStudent' />">Create Student</a>

</body>
</html>