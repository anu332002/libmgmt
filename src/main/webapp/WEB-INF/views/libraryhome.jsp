<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Welcome to Fenway Library</title>
</head>
<style>
.bg-1 { 
    background-color: #d8d8d8;
    color: #000000;
}
</style>
<body>
<form:form modelAttribute="book" method="POST" action="" name="form1">
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#a">Fenway Library</a>
		    </div>
	    <ul class="nav navbar-nav">   	
		      <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
		      <li><a href="#help" data-toggle="tab">Help</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	    	<li>
	      		<a href="#myprofile" data-toggle="tab">My Account
	      		<span class="glyphicon glyphicon-user" ></span>
	      		</a>
	      	</li>
	      	<li>	      		
	      		<button type="submit" class="btn btn-link" onclick="form1.action='${pageContext.request.contextPath }'">Log out</button>
	      	</li>
	    </ul>
	  </div>
	</nav>
	
	<div class="tab-content">		
	<!-- form -->

		<div class="tab-pane active bg-1" id="home">			
			<div class="container text-center">
			  <br>
			  <h1><span class="glyphicon glyphicon-home"></span></h1>
			  <h2>Hi, ${user.username}! Welcome to Fenway Library!</h2> <!--${userId} can get ID -->
			  <p><em>Here we provide you with plenty of books.</em></p>
			  <p>If there is any question, we are always at your service.</p>
			  <br>			  
			  <div class="row">
				    <div class="col-sm-4 text-center">
					      <p><h3><strong>Display All books</strong></h3></p><br>
					 <!--  <img src="../images/book.jpg" alt="1" class="img-circle" width="180" height="180"> -->
					      <h1><span class="glyphicon glyphicon-book"></span></h1><br>
					      <button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/usersearchallbooks/${userId}'">Search</button>				      		      
				    </div>
				    <div class="col-sm-4">
					      <p><h3><strong>Borrow History</strong></h3></p><br>
					<!--  <img src="../images/book2.jpg" alt="2" class="img-circle" width="180" height="180"> -->	 
						  <h1><span class="glyphicon glyphicon-list"></span></h1><br>
						  <button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/borrowbookcontrol/userborrowhistory/${userId}'">Search</button>
				    </div>
				    <div class="col-sm-4">
					      <p><h3><strong>Return Books</strong></h3></p><br>
					<!--  <img src="../images/book3.jpg" alt="3" class="img-circle" width="180" height="180"> --> 
						  <h1><span class="glyphicon glyphicon-tags"></span></h1><br>
						  <button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/borrowbookcontrol/returnbook/${userId}'">Return</button>
				    </div>
				    <div class="col-sm-4">
					      <p><h3><strong>Reserved Books</strong></h3></p><br>
					<!--  <img src="../images/book5.jpg" alt="4" class="img-circle" width="180" height="180"> -->	
						  <h1><span class="glyphicon glyphicon-tasks"></span></h1><br>
						  <button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/reservebookcontrol/reservedbook/${userId}'">Search</button>
				    </div>
				    <div class="col-sm-4">
					      <p><h3><strong>Search Books by Keywords</strong></h3></p><br>
					<!--  <img src="../images/book6.jpg" alt="5" class="img-circle" width="180" height="180"> -->	
						  <h1><span class="glyphicon glyphicon-pencil"></span></h1><br>
						  <button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/bookcontrol/searchbookbyid/${userId}'">Search</button>
				    </div>
			  </div>			  			  
			</div>
		</div>
		
		<!-- /form -->
	    <div class="tab-pane text-center" id="help">
	    		<br/><br/>
		    	<h2><strong>Contact Us</strong></h2><br/><br/>
		    	<h3><span class="glyphicon glyphicon-envelope"></span></h3>
		    	<h4>Email Address: zhang.yuxi@husky.neu.edu</h4>
		    	<br/><br/>
		    	<h3><span class="glyphicon glyphicon-phone-alt"></span></h3>
		    	<h4>Tel: 617.959.3422</h4>
		    	<br><br>
	    </div>	    
	    <div class="tab-pane text-center" id="myprofile">
			    <br><br>
			    <h1>My Profile</h1>
			    <div class="panel panel-info">
					  <div class="panel-body">
					  	<h4>
						    <span class="glyphicon glyphicon-user"></span><br/><br>			    
						    Name: ${user.username}<br><br>
					    	Password: ${user.password}<br/><br>
					    	Email:${user.email}<br/><br>
					    	Role:${user.role}<br/><br>
						</h4>    
					  </div>
					  <div class="panel-footer">
					  	<button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/borrowbookcontrol/updateuserinfo/${userId}/${user.role}'">Update</button><br><br>
					    <button type="submit" class="btn btn-primary btn-lg" onclick="form1.action='${pageContext.request.contextPath }/logincontrol/returnhomepage/${userId}/${user.role}'">Back to Home Page</button>
					  </div>
				</div>		    
	    </div>    
	</div>
</form:form>
</body>
</html>