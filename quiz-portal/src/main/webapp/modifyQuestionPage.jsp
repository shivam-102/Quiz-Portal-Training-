<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="modifyquestion" method="post">
   <p>${message}</p>
  <p>Enter the Question Number you want to Modify:</p><input type="number" name="questionNumber"><br>
  <p>Enter the new Question you want to replace:</p><input type="text" name="newQuestion"><br>
  
  <input type="submit" name="Submit modify Question">
</form>
</body>
</html>