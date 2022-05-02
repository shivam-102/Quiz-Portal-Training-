<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addQuestion" method="post" >

		<p>Enter the Question:</p>
		<input type="text" name="question">
		<br>

		<p>Enter the difficulty:</p>
		<select name="difficulty" required>
			<option selected>Difficulty</option>
			<option value="Easy">Easy</option>
			<option value="Medium">Medium</option>
			<option value="Hard">Hard</option>
		</select>
		<br>

		<p>Enter the marks:</p>
		<input type="number" name="marks">
		<br>
		
		<div >
          <label for="option 1">Option 1</label> <input type="text"
               placeholder="Option 1"
               name="option[0].value"> 
               <label for="answer">Is
               it the answer?</label> <select
               name="option[0].answer">
               <option value="true">Yes</option>
               <option value="false" selected>No</option>
            </select> 
           

		</div>
		<div >
          <label for="option 2">Option 2</label> <input type="text"
               placeholder="Option 2"
               name="option[1].value"> 
               <label for="answer">Is
               it the answer?</label> <select
               name="option[1].answer">
               <option value="true">Yes</option>
               <option value="false" selected>No</option>
            </select> 
           

		</div>
		<div >
          <label for="option 3">Option 3</label> <input type="text"
               placeholder="Option 3"
               name="option[2].value"> 
               <label for="answer">Is
               it the answer?</label> <select
               name="option[2].answer">
               <option value="true">Yes</option>
               <option value="false" selected>No</option>
            </select> 
           

		</div>
		<div >
          <label for="option 4">Option 4</label> <input type="text"
               placeholder="Option 4"
               name="option[3].value"> 
               <label for="answer">Is
               it the answer?</label> <select
               name="option[3].answer">
               <option value="true">Yes</option>
               <option value="false" selected>No</option>
            </select> 
           

		</div>
		<input type="submit" name="Add Question">

	</form:form>
</body>
</html>