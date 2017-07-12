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
<title>Add Book Success</title>
</head>
<body>
<form:form modelAttribute="book" method="POST" action="" name="form1">
<table class="table table-striped">
   <caption><h3>New Book Has Been Added Successfully! Information is as following.</h3></caption>
   <thead>
      <tr>
         <th>Book Name</th>
         <th>Book Author</th>
         <th>Book Price</th>
         <th>Book Number</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>${book.bookName}</td>
         <td>${book.bookAuthor}</td>
         <td>${book.price}</td>
         <td>${book.num}</td>
      </tr>
   </tbody>
</table>
<div class="text-center">
<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/addbook'">Continue Adding Books</button>
<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
</div>
</form:form>
</body>
</html>