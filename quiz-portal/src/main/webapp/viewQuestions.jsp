<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Available</title>
</head>
<body>
	<h1>Questions List</h1>
	<table border="1">
		<tr>
			<th>Question Id</th>
			<th>Question</th>
			<th>Difficulty</th>
			<th>Marks</th>
		</tr>

		<c:forEach var="question" items="${questions}">
		<tr>
			<td>${question.questionId}</td>
			<td>${question.question}</td>
			<td>${question.difficulty}</td>
			<td>${question.marks}</td>
			</tr>
			
	</c:forEach>
	
	</table>
</body>
</html>