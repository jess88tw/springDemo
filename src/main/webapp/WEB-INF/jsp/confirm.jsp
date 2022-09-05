<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>你要確定誒</title>
		<link rel="stylesheet" href="/css/main.css">
	</head>

	<body>
		<div class="container">
			<div class="header">
				<h2>For Run in JSP: ${message}</h2>
			</div>
			<div id="confirmBody" class="confirm">
				<p>${msg}: </p>
				<p>===> ID: {${id}}, NAME: {${name}} ?</p>
			</div>
			<form id='confirmForm' class="form" action="/example${path}" method="POST">
				<div class="form-control">
					<input type="hidden" id="id" name="id" value="${id}">
				</div>
				<div class="form-control">
					<input type="hidden" id="name" name="name" value="${name}">
				</div>
				<button type="submit" value="submit">Submit</button>
			</form>
			<button id="backToHomeButton" type="submit" value="disSubmit">Back to home</button>
			<script type="text/javascript" src="/js/BackToHome.js"></script>
			<script>
				if ("${path}" == "/result/update") {
					document.getElementById("id").type = "text";
					document.getElementById("id").readOnly = true;
					document.getElementById("name").type = "text";
				}
			</script>
		</div>
	</body>

	</html>