<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions in the Quiz</title>
</head>
<body>
<h2>Question in this List</h2>
<table border="1">
<tr>
<th>Code</th>
<th>Questions List</th>
</tr>
<c:forEach var="question" items="${quiz.questionsList}">
<td>${question}</td>
</c:forEach>
</table>
</body>
</html>