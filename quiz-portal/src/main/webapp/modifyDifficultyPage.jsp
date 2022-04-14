<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Difficulty Modification Page</title>
</head>
<body>
<form action="modifydifficulty" method="post">
  <p>Enter the Question Number you want to Modify:</p><input type="number" name="questionNumber"><br>
  <p>Enter the new Difficulty you want to assign:</p><select name="newDifficulty" required>
			<option selected>Difficulty</option>
			<option value="Easy">Easy</option>
			<option value="Medium">Medium</option>
			<option value="Hard">Hard</option>
		</select><br>
  
  <input type="submit" name="submitQuestionModification ">
</form>
</body>
</html>