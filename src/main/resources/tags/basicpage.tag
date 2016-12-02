<%@ tag description="Structure of a basic page" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="css/login.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" />
</head>
<body>
	<p>
		<a href="/login?lang=FR">Français</a> | <a href="/login?lang=EN">English</a> |<a href="/login?lang=ES">Espanol</a>
	</p>
	
	
	<div class="login-page">
  <div class="form">

    <form class="login-form" th:action="@{/login}" method="POST">
      <input type="text" name="username" placeholder="username"/>
      <input type="password" name="password" placeholder="password"/>
      <input type="submit" name="submit" th:value="#{login.login}" />
      
    </form>
  </div>
</div>

</body>
</html>
