<c:set var="credentials" scope="request" value='${session.getAttribute("credentials")}'/>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Main Page</title>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>


	<nav class="navbar navbar-light bg-faded">
  		<ul class="nav navbar-nav">
  			<li class="nav-item">
	      		<a href="/?lang=FR">French</a> | <a href="/?lang=EN">English</a>
	    	</li>
	    	<li class="nav-item">
	      		<a class="nav-link" href="#">Create a project</a>
	    	</li>
	    	<li class="nav-item">
	      		<a class="nav-link" href="#">View my projects</a>
	    	</li>
	    	<li class="nav-item">
	      		<a class="nav-link" href="#">Top Up Credit</a>
	    	</li>
	    	
	    	<li class="nav-item">
	      		<a class="nav-link" href="#">Create a project</a>
	    	</li>
	    	
	    	<li class="nav-item">
	      		<a class="nav-link" href="/login?logout">Logged as ${credentials.username}</a>
	    	</li>
  
  	</ul>
	</nav>
	
    <p th:text="#{main.hello} + ', ' + ${name}"/>
    
</body>
</html>