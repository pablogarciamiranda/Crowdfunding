<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<c:url value='/resources/templates/css/login.css' />" rel="stylesheet"/>
</head>
<body>
	<p>
		<a href="/login?lang=FR">French</a> | <a href="/login?lang=EN">English</a>
	</p>
    <form th:action="@{/login}" method="POST">
    	<input type="text" name="username"/>
    	<br/>
    	<input type="password" name="password"/>
    	<br/>
    	<input type="submit" name="submit" th:value="#{login.login}" />
    </form>
</body>
</html>