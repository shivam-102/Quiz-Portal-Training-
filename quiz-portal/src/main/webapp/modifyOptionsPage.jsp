<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Options</title>
</head>
<body>
<form action="modifyoptions" method="post">

<p>Enter the Question Number you want to Modify:</p><input type="number" name="questionNumber"><br>


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
		
		<input type="submit" name="submit option">
</form>
</body>
</html>