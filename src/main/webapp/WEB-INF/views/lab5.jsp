<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 5</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>


<body>
	<p>Lab 5</p>
    <form action="/lab5/get-data" method="POST">
        <div class="formData">

            <textarea name="firstArea" rows="8" cols="45">${firstArea}</textarea>
            <div class="enteredData">
                <label>Enter step:</label><br>
                <input name = "key"  placeholder="Enter key" required="required" value="${key}"><br><br>
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