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
<title>Delete Reader Success</title>
</head>
<body>
<div class="text-center">
<br><br>
<h3>Delete User Successfully!</h3>
<br>
<form:form modelAttribute="user" method="POST" action="" name="form1">
<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/searchreaders/${userId}'">Return to Previous Page</button>
</form:form>
</div>
</body>
</html>