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
<title>Display All Readers</title>
</head>
<body>
<form:form modelAttribute="book" method="POST" action="" name="form1">
	<table class="table table-bordered">
		<caption>Display All Readers in Library</caption>
		<thead>
		<tr>
			<th>Reader ID</th>
			<th>Reader Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Operation</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${pagelist}">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>
					<button type="submit" class="btn btn-warning" onclick="form.action='${pageContext.request.contextPath }/usercontrol/deletereader/${user.id}'">Delete</button>
					<button type="submit" class="btn btn-warning" onclick="form.action='${pageContext.request.contextPath }//borrowbookcontrol/admincheckborrowhistory/${user.id}'">Check Borrow History</button>
					</td>		
				</tr>
			</c:forEach>
		</tbody>
		</table>
		
		<tr>
	            <td colspan="6" align="center" bgcolor="#5BA8DE">Total records:${page.totalRecords}| Total pages:${page.totalPages}| Current page:${page.pageNo}<br>
	                
	                <button type="submit" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/searchreaders/${userId}?pageNo=${page.topPageNo }'">First Page</button>
	        
	                <c:choose>
	                  <c:when test="${page.pageNo!=1}">
	                    
	                      <button type="submit" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/searchreaders/${userId}?pageNo=${page.previousPageNo }'">Previous Page</button>	
	                    
	                  </c:when>
	                  <c:otherwise>
	                    
	                      
	                      <input type="button" disabled="disabled" name="previousPage" value="Previous Page" />
	                    
	                  </c:otherwise>
	                </c:choose>
	                <c:choose>
	                
	                  <c:when test="${page.pageNo != page.totalPages}">
	                    <button type="submit" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/searchreaders/${userId}?pageNo=${page.nextPageNo }'">Next Page</button>

	                  </c:when>
	                  <c:otherwise>
	                    
	                      <input type="button" disabled="disabled" name="nextPage" value="Next Page" />
	                    
	                  </c:otherwise>
	                </c:choose>
	                <button type="submit" onclick="form1.action='${pageContext.request.contextPath }/usercontrol/searchreaders/${userId}?pageNo=${page.bottomPageNo }'">Last Page</button>
	                
	            </td>
	      </tr>
        
	<br><br>
	<div class="text-center">
	<button type="submit" class="btn btn-success" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
	</div>
</form:form>
</body>
</html>