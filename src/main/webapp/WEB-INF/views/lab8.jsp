<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 8</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>


<body>
	<p>Lab 8</p>
    <form action="/lab8/get-data" method="POST">
        <div class="formData">

            <div class="enteredData">
            	<input name = "codeText" hidden="true">
             	<label>Enter vector:</label><br>
                <input name = "initVector"  placeholder="Enter vector" required="required" value="${initVector}"><br><br>
                <label>Enter key:</label><br>
                <input name = "key"  placeholder="Enter key" required="required" value="${key}"><br><br>
                <label>Choose action:</label><br>
                <input type="radio" name="choice" value="code" checked>Coding<br>
                <input type="radio" name="choice" value="decode">Decoding<br> <br>
                <input type="submit" value="Execute">
            </div>
        </div>
    </form>

</body>
</html>