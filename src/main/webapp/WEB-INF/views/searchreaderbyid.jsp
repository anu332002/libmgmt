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
<title>Search Reader By Id</title>
</head>
<body>
<form:form modelAttribute="book" method="POST" action="" name="form1">
<h3>Here is the searching result!</h3><br>
<table class="table table-bordered">
<thead>
<tr>
	<th>User ID</th>
	<th>Reader Name</th>
	<th>Password</th>
	<th>Email</th>
	<th>Operation</th>
</tr>
</thead>
<tbody>
	
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.email}</td>
			<td>
			<button type="submit" class="btn btn-warning" onclick="form.action='${pageContext.request.contextPath }/usercontrol/deletereader/${user.id}'">Delete</button>
			<button type="submit" class="btn btn-warning" onclick="form.action='${pageContext.request.contextPath }//borrowbookcontrol/userborrowhistory/${user.id}'">Check Borrow History</button>
			</td>
		</tr>

</tbody>
</table>

	<br><br>
	<div class="text-center">
<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/queryreaderinfo/${userId}'">Back to Previous Page</button>
	</div>
</form:form>
</body>
</html>