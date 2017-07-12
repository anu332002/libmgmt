<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Library Admin Home</title>
</head>
<style>
.bg-1 { 
    background-color: #dddddd;
    color: #000000;
}
</style>
<body class="body-adminhome bg-1">
<form:form modelAttribute="book" method="POST" action="" name="form1">
	<div class="container-fluid text-center">
	  <h2>Hi, ${user.username}</h2>
	  <h4>Welcome to Library Administration Center!</h4>
	      <h4><span class="glyphicon glyphicon-log-out"></span></h4>
	      <button type="submit" class="btn btn-primary btn-sm" onclick="form1.action='${pageContext.request.contextPath }'">Log Out</button>
	  <br>
	  <br><br>
		  <div class="row">
				    <div class="col-sm-4">
				      <h2><span class="glyphicon glyphicon-user"></span></h2>
				      <h3><strong>My Account</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/checkadmininfo'">Check My Information</button>
				    </div>
				    
				    <div class="col-sm-4">
				      <h2><span class="glyphicon glyphicon-book"></span></h2>
				      <h3><strong>Add New Book</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/addbook'">Add</button>
				    </div>
				    <div class="col-sm-4">
				      <h2><span class="glyphicon glyphicon-search"></span></h2>
				      <h3><strong>Search All Books</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchallbooks/${userId}'">Search</button>
				    </div>
		 </div>
		 <br><br>
	     <br><br>
	     <br><br>
		 <div class="row">
		 			<div class="col-sm-4">
				      <h2><span class="glyphicon glyphicon-list-alt"></span></h2>
				      <h3><strong>Book Information Query</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchsomebooks'">Query</button>
				    </div>
				    <div class="col-sm-4">
				      <h2><span class="glyphicon glyphicon-folder-open"></span></h2>
				      <h3><strong>Search All Readers</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/searchreaders/${userId}'">Check</button>
				    </div>
				    <div class="col-sm-4">
				      <h2><span class="glyphicon glyphicon-bookmark"></span></h2>
				      <h3><strong>Reader Information Query</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/queryreaderinfo/${userId}'">Check</button>
				    </div>				    
		  </div>
		  <div class="row">
		  			<div class="col-sm-12">
				      <h2><span class="glyphicon glyphicon-minus"></span></h2>
				      <h3><strong>Check Reservation</strong></h3>
				      <button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/reservebookcontrol/checkreserve/${userId}'">Check</button>
				    </div>
		  </div>
	</div>
</form:form>
</body>
</html>