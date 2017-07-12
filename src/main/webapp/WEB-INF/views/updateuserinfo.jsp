<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Update User Info</title>
</head>
<style>
.bg-1 { 
    background-color: #f0f0f0;
    color: #000000;
}
</style>
<body>
<form:form modelAttribute="user" method="POST" action="" name="form1">

	    <div class="tab-pane text-center bg-1" id="myprofile">
			    <h1><strong>Update My Information</strong></h1><br>	
			    <h3><strong>ID: ${userId}</strong></h3><br><br>	    
			    <div class="panel panel-info">
					  <div class="panel-body">				
							<h4><strong>Name: ${user.username}</strong></h4><br>
							<form:input path="username" placeholder="name"/>
							<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/updatename/${userId}/${user.role}'">Update</button>
							<br><br>
							<h4><strong>Password: ${user.password}</strong></h4><br/>
							<form:input path="password" placeholder="password"/>
							<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/updatepassword/${userId}/${user.role}'">Update</button>
							<br><br>
							<h4><strong>Email:${user.email}</strong></h4><br>
							<form:input path="email" placeholder="email"/>
							<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/updateemail/${userId}/${user.role}'">Update</button>	
					  		<br><br>
					  </div>
					  <div class="panel-footer">					  		
							<br><br>
							<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
					  </div>
				</div>		    
	    </div>  
</form:form>
</body>
</html>