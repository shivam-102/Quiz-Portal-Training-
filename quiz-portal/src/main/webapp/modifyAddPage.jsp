<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question to the Quiz</title>
</head>
<body>
<form action="addQuestionToQuiz" method="post">
<p> Enter the quiz code on which modification has to be done</p>
<input type="number" name="code"><br>
<p>Please enter the questionId you want to add:</p>
<input type="number" name="questionToAdd"><br>
<input type="submit" name="submit">
</form>
</body>
</html>