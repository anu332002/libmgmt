<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login Page</title>
</head>
<body class="body-log">
<div class="text-center">
	 <header class="text-center">
	  	<br/><br/>
	  	<h1>Welcome to Fenway Library!</h1>
	 </header>
	<form:form modelAttribute="user" method="POST" action="" name="form1">    <!-- databind/modelautobind -->
	<table align="center">
		<div>  
			<div class="panel-heading">
				<br/>
				<span class="glyphicon glyphicon-user"></span>
					<h1><small>Log in </small></h1>
			</div> 
			<div>    
		             	  <form:input path="username" placeholder="name"/><br/><br/>
		        		  <form:password path="password" placeholder="password"/><br/><br/>
		        	      <form:input path="email" type="email" placeholder="email"/><br/><br/>
		        <strong>   Role: <form:radiobutton path="role" value="0"/>Admin
		     		      <form:radiobutton path="role" value="1"/>User <br/><br/>
  		        </strong>
				<input type="submit" value="Login" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/logincheck'"/>
				<br/>
			</div> 
		</div>
		</table>
	</form:form> 
</div> 
</body>
</html>