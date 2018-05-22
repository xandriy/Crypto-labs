<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 1</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>


<body>
	<p>Lab 1</p>
    <form action="/lab1/get-data" method="POST">
        <div class="formData">

            <textarea name="firstArea" rows="8" cols="45">${firstArea}</textarea>
            <div class="enteredData">
                <label>Enter step:</label><br>
                <input name = "step" type="number" placeholder="Введіть крок" required="required" value="${step}"><br><br>
                <label>Choose action:</label><br>
                <input type="radio" name="choice" value="code" checked>Coding<br>
                <input type="radio" name="choice" value="decode">Decoding<br> <br>
                <input type="submit" value="Execute">
            </div>
            <textarea name="secondArea" rows="8" cols="40" disabled>${secondArea}</textarea>
        </div>
    </form>

</body>
</html>