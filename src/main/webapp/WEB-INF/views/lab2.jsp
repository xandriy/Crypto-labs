<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 2</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>


<body>
	<p>Lab 2</p>
    <form action="/lab2/get-data" method="POST">
        <div class="formData">

            <textarea name="firstArea" rows="8" cols="45">${firstArea}</textarea>
            <div class="enteredData">
                <label>Enter key:</label><br>
                <input name="key" type="number" placeholder="Enter key" required="required" value="${key}"><br>
                <label>Enter number of loop:</label><br>
                <input name="loop" type="number" placeholder="Enter number of loop" required="required" value="${loop}"><br><br>
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