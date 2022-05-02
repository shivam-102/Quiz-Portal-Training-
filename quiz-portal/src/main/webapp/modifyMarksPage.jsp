<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="modifymarks" method="post">
  <p>Enter the Question Number you want to Modify:</p><input type="number" name="questionNumber"><br>
  <p>Enter the new marks you want to replace:</p><input type="number" name="newMarks"><br>
  
  <input type="submit" name="Submit modify Question">
  </form>
</body>
</html>