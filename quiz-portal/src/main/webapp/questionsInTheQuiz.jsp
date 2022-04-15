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
<th>Question Id</th>
<th>Question</th>
<th>Difficulty</th>
<th>Marks</th>
</tr>
<c:forEach var="title" items="${quiz.questionsList}">
<tr>
<td>${title.questionId}</td>
<td>${title.question}</td>
<td>${title.difficulty}</td>
<td>${title.marks}</td>
</tr>
</c:forEach>
</table>
</body>
</html>