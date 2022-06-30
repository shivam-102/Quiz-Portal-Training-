<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>Update the Question</head>
<body>
<form action="fetchQuestionById" method="post">
<p>Enter the question number which you want to modify:</p><br />
<input type="number" name="questionNumber"><br />
<input type="submit" name="submitQuestionNumber">
</form>

</body>
</html>