<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab 3</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<body>
	<p>Lab 3</p>
    <form action="/lab3/get-data" method="POST">
        <div class="formData">

            <textarea name="firstArea" rows="8" cols="45">${firstArea}</textarea>
            <div class="enteredData"><br><br><br>
                <input type="submit" value="Decode">
            </div>
            <textarea name="secondArea" rows="8" cols="40" disabled>${secondArea}</textarea>
        </div>
    </form>
	<c:if test="${frequency != null}">
		<p>Step : ${step}</p>
		<div class="frequency">
        	<p>а: ${frequency[0]}</p>
        	<p>б: ${frequency[1]}</p>
        	<p>в: ${frequency[2]}</p>
        	<p>г: ${frequency[3]}</p>
        	<p>ґ: ${frequency[4]}</p>
        	<p>д: ${frequency[5]}</p>
        	<p>е: ${frequency[6]}</p>
        	<p>є: ${frequency[7]}</p>
        	<p>ж: ${frequency[8]}</p>
        	<p>з: ${frequency[9]}</p>
        	<p>и: ${frequency[10]}</p>
        	<p>і: ${frequency[11]}</p>
        	<p>ї: ${frequency[12]}</p>
        	<p>й: ${frequency[13]}</p>
        	<p>к: ${frequency[14]}</p>
        	<p>л: ${frequency[15]}</p>
        	<p>м: ${frequency[16]}</p>
        	<p>н: ${frequency[17]}</p>
        	<p>о: ${frequency[18]}</p>
        	<p>п: ${frequency[19]}</p>
        	<p>р: ${frequency[20]}</p>
        	<p>с: ${frequency[21]}</p>
        	<p>т: ${frequency[22]}</p>
        	<p>у: ${frequency[23]}</p>
        	<p>ф: ${frequency[24]}</p>
        	<p>х: ${frequency[25]}</p>
        	<p>ц: ${frequency[26]}</p>
        	<p>ч: ${frequency[27]}</p>
        	<p>ш: ${frequency[28]}</p>
        	<p>щ: ${frequency[29]}</p>
        	<p>ь: ${frequency[30]}</p>
        	<p>ю: ${frequency[31]}</p>
        	<p>я: ${frequency[32]}</p>
        	
        	
        </div>
	
	</c:if>
</body>
</html>