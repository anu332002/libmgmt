<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Search By Book Name</title>
</head>
<body>
<form:form modelAttribute="book" method="POST" action="" name="form1">
<table class="table table-bordered">
<caption><h3>Hi,${user.username}! Here is your search result.</h3></caption> <!-- ${userId} --> <!-- Role is : ${user.role} -->
<br>
<thead>
<tr>
	<th>Book ID</th>
	<th>Book Name</th>
	<th>Book Author</th>
	<th>Book Price</th>
	<th>Book Number</th>
	<th>Operation</th>
</tr>
</thead>
<tbody>
	<c:forEach var="book" items="${list}">
		<tr>
			<td>${book.bookId}</td>
			<td>${book.bookName}</td>
			<td>${book.bookAuthor}</td>
			<td>${book.price}</td>
			<td>${book.num}</td>	
			<td>
			<button type="submit" class="btn btn-primary btn-sm" onclick="form1.action='${pageContext.request.contextPath }/borrowbookcontrol/borrowbookcheck/${book.bookId}/${userId}'">Borrow</button>
			<button type="submit" class="btn btn-primary btn-sm" onclick="form1.action='${pageContext.request.contextPath }/reservebookcontrol/reservebookcheck/${book.bookId}/${userId}'">Reserve</button>
			</td>	
		</tr>
	</c:forEach>
</tbody>
</table>           
        
	<br><br>
<div class="text-center">
<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchbookbyid/${userId}'">Back to Previous Page</button>
</div>	
</form:form>
</body>
</html>