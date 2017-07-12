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
<title>Return Books</title>
</head>
<body>
<form:form modelAttribute="borrowbook" method="POST" action="" name="form1">
<table class="table table-bordered">
<caption><h3>Hi,${user.username}! Here are all books in borrowing.</h3></caption> <!-- ${userId} -->
<thead>
<tr>
	<th>BorrowBook ID</th>
	<th>Borrow Date</th>
	<th>Book ID</th>
	<th>Operation</th>
</tr>
</thead>
<tbody>
	<c:forEach var="borrowbook" items="${list}">
		<tr>
			<td>${borrowbook.borrowbookId}</td>
			<td>${borrowbook.borrowDate}</td>
			<td>${borrowbook.bookId}</td>	
			<td>
			<button type="submit" class="btn btn-primary btn-sm" onclick="form1.action='${pageContext.request.contextPath }/borrowbookcontrol/choosereturnbook/${borrowbook.borrowbookId}'">Return</button>
			</td>	
		</tr>
	</c:forEach>
</tbody>
</table>
<div class="text-center">
<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
</div>
</form:form>
</body>
</html>