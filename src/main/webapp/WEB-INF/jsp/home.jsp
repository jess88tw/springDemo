<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我是主頁面</title>
</head>
<script>
    function selectCRUD () {
    	switch (event.target.value) {
    		case "create":
    			document.getElementById("homeForm").action = "/example/confirm/create";
    			document.getElementById("name").type = "text";
    			break;
    		case "search":
    			document.getElementById("homeForm").action = "/example/result/search";
    			document.getElementById("name").type = "hidden";
    			break;
    		case "update":
    			document.getElementById("homeForm").action = "/example/confirm/update";
    			document.getElementById("name").type = "hidden";
    			break;
    		case "delete":
    			document.getElementById("homeForm").action = "/example/confirm/delete";
    			document.getElementById("name").type = "hidden";
    			break;
    	};
	};
</script>
<body>
	<h2>For Run in JSP: ${message}</h2>
	<ol type="I">
		<li>本頁面包含輸入、確認、結果頁面</li>
		<li>DB不限</li>
		<li>須包含 新 刪 修 查 功能</li>
		<li>程式碼需上傳 github</li>
		<li>於 codeReview 時 demo 功能</li>
	</ol><hr/>
	
	<input id="rdoType1" type="radio" name="rdo1" value="create" onclick = "selectCRUD ()" />
    <label for="rdoType1">新增資料</label>
    <input id="rdoType2" type="radio" name="rdo1" value="search" onclick = "selectCRUD ()" />
    <label for="rdoType2">查詢資料</label>
    <input id="rdoType3" type="radio" name="rdo1" value="update" onclick = "selectCRUD ()" />
    <label for="rdoType3">更新資料</label>
    <input id="rdoType4" type="radio" name="rdo1" value="delete" onclick = "selectCRUD ()" />
    <label for="rdoType4">刪除資料</label><br />
    
    <form id='homeForm' method="POST">
        ID: <input type='text' id='id' name='id'><br>
        NAME: <input type='text' id='name' name='name'><br>
        <button type="submit" value="提交">送出</button>
    </form>
</body>
</html>