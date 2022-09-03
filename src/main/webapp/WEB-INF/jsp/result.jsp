<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果就是這樣囉</title>
</head>
<body>
	<h2>For Run in JSP: ${message}</h2>
    <p>${msg}: </p>
    <p>===> ID: {${id}}, NAME: {${name}}</p>
    <button id="backToHomeButton" type="submit" value="">完成</button>
    <script>
   		document.getElementById("backToHomeButton").onclick = () => location.href = "/example/home";
	</script>
</body>
</html>