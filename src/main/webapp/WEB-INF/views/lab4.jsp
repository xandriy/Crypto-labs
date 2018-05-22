<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 4</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>


<body>
	<p>Lab 4</p>
    <form action="/lab4/get-data" method="POST">
        <div class="formData">
  <textarea name="firstArea" rows="8" cols="45">${firstArea}</textarea>
            <div class="enteredData">
               <input type = number value = "${textSize}" name = "textSize" hidden="true"><br>
                <input type="radio" name="choice" value="code" checked>Coding<br>
                <input type="radio" name="choice" value="decode">Decoding<br> <br>
                <input type="submit" value="Execute">
            </div>
            
            <textarea name="secondArea" rows="8" cols="40" disabled>${secondArea}</textarea>
        </div>
    </form>
</body>
</html>