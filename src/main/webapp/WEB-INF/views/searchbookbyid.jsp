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
<title>Search Book By Keywords</title>
</head>
<body>
<form:form modelAttribute="book" method="POST" action="" name="form1">
	<div class="tab-pane text-center" id="searchby">
			    <h1><strong>Search Book by Keywords</strong></h1><br>	    
			    <div class="panel panel-info">
					  <div class="panel-body">				

							<form:input path="bookId" name="bookId" placeholder="ID"/>
							<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchbyid'">Search</button>
							<br><br>
							
							<form:input path="bookName" name="bookName" placeholder="name"/>
							<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchbyname'">Search</button>
							<br><br>
							
							<input  name="minprice" placeholder="minprice"/>-
							<input  name="maxprice" placeholder="maxprice"/>
							<button type="submit" class="btn btn-primary" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchbyprice'">Search</button>
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