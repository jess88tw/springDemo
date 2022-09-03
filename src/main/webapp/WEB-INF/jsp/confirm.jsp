<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>你要確定誒</title>
</head>
<body>
<%-- 	<%
    	String rqname = request.getParameter("name");
		String rqid = request.getParameter("id");
    %>
    <p>確定要新增 ID: { <%=rqid%> }, NAME: { <%=rqname%> }?</p> --%>
	<h2>For Run in JSP: ${message}</h2>
    <p>${msg}: </p>
    <p>===> ID: {${id}}, NAME: {${name}} ?</p>
    <form id='confirmForm' action="/example${path}" method="POST">
 		<input type="hidden" id="id" name="id" value="${id}">
		<input type="hidden" id="name" name="name" value="${name}">
        <button type="submit" value="提交">送出</button>
    </form>
    <button id="backToHomeButton" type="submit" value="取消">取消</button>
    <script>
   		document.getElementById("backToHomeButton").onclick = () => location.href = "/example/home";
   		if ("${path}" == "/result/update") {
   			document.getElementById("id").type="text";
   			document.getElementById("id").readOnly = true;
   			document.getElementById("name").type="text";
   		}
	</script>
</body>
</html>