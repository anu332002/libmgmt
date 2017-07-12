<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Book</title>
</head>
<body>
<form:form class="form-horizontal" role="form" modelAttribute="book" method="POST" name="form" action="">
	<div class="container-fluid text-center">
	  	<h2>Add New Book</h2>
	</div>  
   <div class="form-group">
      	  <label for="bookname" class="col-sm-2 control-label">Book Name</label>
	      <div class="col-sm-10">
	         <form:input type="text" class="form-control" id="bookname" path="bookName"/>
	      </div>
   </div>
   <div class="form-group">
	      <label for="bookauthor" class="col-sm-2 control-label">Book Author</label>
	      <div class="col-sm-10">
	         <form:input type="text" class="form-control" id="bookauthor" path="bookAuthor"/>
	      </div>
   </div>
	<div class="form-group">
	      <label for="price" class="col-sm-2 control-label">Book Price</label>
	      <div class="col-sm-10">
	         <form:input type="text" class="form-control" id="price" path="price"/>
	      </div>
   </div>
   <div class="form-group">
	      <label for="booknum" class="col-sm-2 control-label">Book Number</label>
	      <div class="col-sm-10">
	         <form:input type="text" class="form-control" id="booknum" path="num"/>
	      </div>
   </div>
   <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	         <button type="submit" class="btn btn-default" onclick="form.action='${pageContext.request.contextPath }/bookcontrol/addsuccess'">Confirm</button>
	      </div>
   </div>
   <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	         <button type="submit" class="btn btn-default" onclick="form.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
	      </div>
   </div>
</form:form>

</body>
</html>