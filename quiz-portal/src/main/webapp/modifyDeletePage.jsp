<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question To Delete</title>
</head>
<body>
<form action="deleteQuestionfromQuiz" method="post">
<p> Enter the quiz code on which modification has to be done</p>
<input type="number" name="code"><br>
<p>Please enter the questionId you want to delete:</p>
<input type="number" name="questionToDelete"><br>
<input type="submit" name="submit">
</form>
</body>
</html>