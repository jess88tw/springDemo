<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>我是主頁面</title>
		<link rel="stylesheet" href="/css/main.css">
		<script type="text/javascript" src="/js/CRUD.js"></script>
	</head>

	<body>
		<div class="container">
			<div class="header">
				<h2>For Run in JSP: ${message}</h2>
				<br />
				<li>必須包含頁面 { 輸入、確認、結果 }</li>
				<li>DB沒有限制</li>
				<li>CRUD</li>
				<li>提交 github 檢查</li>
			</div>
			<div id="homeSelector" class="selector">
				<input id="rdoType1" type="radio" name="rdo1" value="create" onclick="selectCRUD (event)" />
				<label for="rdoType1">新增資料</label>
				<input id="rdoType2" type="radio" name="rdo1" value="search" onclick="selectCRUD (event)" />
				<label for="rdoType2">查詢資料</label>
				<input id="rdoType3" type="radio" name="rdo1" value="update" onclick="selectCRUD (event)" />
				<label for="rdoType3">更新資料</label>
				<input id="rdoType4" type="radio" name="rdo1" value="delete" onclick="selectCRUD (event)" />
				<label for="rdoType4">刪除資料</label>
			</div>
			<form id='homeForm' class="form" method="POST">
				<div class="form-control">
					<label for="id" id="idLabel">ID</label>
					<input type="hidden" placeholder="number only" id="id" name="id" />
					<i class="fas fa-check-circle"></i>
					<i class="fas fa-exclamation-circle"></i>
					<small>Error message</small>
				</div>
				<div class="form-control">
					<label for="name" id="nameLabel">Name</label>
					<input type="hidden" placeholder="not null" id="name" name="name" />
					<i class="fas fa-check-circle"></i>
					<i class="fas fa-exclamation-circle"></i>
					<small>Error message</small>
				</div>
				<button type="submit" value="submit">Submit</button>
			</form>
			<script type="text/javascript" src="/js/Validate.js"></script>
		</div>
	</body>

	</html>