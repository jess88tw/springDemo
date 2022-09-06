<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>結果就是這樣囉</title>
        <link rel="stylesheet" href="/css/main.css">
    </head>

    <body>
        <div class="container">
            <div class="header">
                <h2>For Run in JSP: ${message}</h2>
            </div>
            <div id="rightBody" class="textBody">
                <p>${msg}: </p>
                <p>===> ID: {${id}}, NAME: {${name}}</p>
            </div>
            <div id="wrongBody" class="textBody" style="display: none">
                <p>${msg}</p>
            </div>
            <button id="backToHomeButton" type="submit" value="">完成</button>
        </div>
        <input type="hidden" id="empty" name="empty" value="${id}">
        <script type="text/javascript" src="/js/BackToHome.js"></script>
        <script type="text/javascript" src="/js/SetResultValues.js"></script>
    </body>

    </html>