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
<title>My Account</title>
</head>
<style>
.bg-4 { 
    background-color: #2f2f2f;
    color: #ffffff;
}
.bg-5{
	width: 400px;
}
</style>
<body>
	<div class="container-fluid bg-3 text-center"> 
	  <h3>My Account</h3><br>
	  <h2><small>ID:${userId}</small></h2><br>
				<form:form modelAttribute="book" method="POST" name="form1" action="">		      
					      <img src="../images/login2.jpg" alt="image" class="img-circle" width="100" height="100"><br>
					      	
					    		<h2><small>Name:${user.username}</small></h2><br>
					    		
					    		<h2><small>Password:${user.password}</small></h2><br>
					    		
					    		<h2><small>Email:${user.email}</small></h2><br>
					    		
					      <button type="submit" class="btn btn-warning" onclick="form1.action='${pageContext.request.contextPath }/borrowbookcontrol/updateuserinfo/${userId}/${user.role}'">Update</button>
					      <br><br>	
					      <button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
			    </form:form>
	</div>

</body>
</html>