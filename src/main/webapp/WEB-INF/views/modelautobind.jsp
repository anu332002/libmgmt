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

<title>Log in Fenway Library</title>
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
				<h1><span class="glyphicon glyphicon-user"></span></h1>
					<h1><strong>Log in </strong></h1>
					<form:errors path="*"></form:errors><br> <!-- add -->
			</div> 
			<div>    
		             	  <form:input path="username" placeholder="name"/><br/><br/>
		             	  <form:errors path="username"></form:errors><br/><br/>
		        		  <form:input type="password" path="password" placeholder="password (5-15)"/><br/><br/>
		        	      <form:errors path="password"></form:errors><br/><br/>
		        	      <form:input path="email" type="email" placeholder="email"/><br/><br/>
		        		  <form:errors path="email"></form:errors><br/><br/>
		        <strong>   Role: <form:radiobutton path="role" value="0"/>Admin
		     		      <form:radiobutton path="role" value="1"/>User <br/><br/>
  		        </strong>
				<input type="submit" value="Login" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/logincheck'"/>
				<br/>
				<h4><small>Not a member yet?</small></h4>
		        <input type="submit" value="Create Account" onclick="form1.action='modelautobind'"/> <!-- databind/modelautobind -->
			</div> 
		</div>
		</table>
	</form:form> 
</div> 
</body>
</html>