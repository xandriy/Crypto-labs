<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 6-7</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>


<body>
	<p>Lab 6-7</p>
    <form action="/lab6-7/get-data" method="POST">
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
    
    <c:if test="${countOpenLetters != null}">
    <p>Count of every letter open text</p>
     	<div class="chart">
    		<c:forEach items="${countOpenLetters}" var = "letter">
    			 <div class="item">
    			 	<p>${letter.value}</p>
    			 	<c:forEach var = "i" begin="1" end = "${letter.value}">
    			 		 <div class="block"></div>
    			 	</c:forEach>
    			 	<p>${letter.key}</p>
    			 </div>
    		</c:forEach>
    	</div>
    	<br>
    	<p>Count of every letter crypted text</p>
    	<div class="chart">
    		<c:forEach items="${countCodeLetters}" var = "letter">
    			 <div class="item">
    			 	<p>${letter.value}</p>
    			 	<c:forEach var = "i" begin="1" end = "${letter.value}">
    			 		 <div class="block"></div>
    			 	</c:forEach>
    			 	<p>${letter.key}</p>
    			 </div>
    		</c:forEach>
    	</div>
    </c:if>
</body>
</html>