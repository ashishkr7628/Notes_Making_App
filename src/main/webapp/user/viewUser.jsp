<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrapCss.jsp"%>
</head>
<body>
<%@ include file="../components/homeNavbar.jsp"%>
	<%if(userName==null){
		
		response.sendRedirect("login.jsp");
		
	}
		%>

<% int userId=(int)session.getAttribute("userId"); %>
<div class="card position-absolute top-50 start-50 translate-middle" style="width: 18rem;">
  <div class="card-header">
    User Details
  </div>
  
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Name: ${user.name} </li>
    <li class="list-group-item">Age: ${user.age}</li>
    <li class="list-group-item">Mobile: ${user.mobile}</li>
    <li class="list-group-item">Email: ${user.email}</li>
    <li class="list-group-item">Password: ${user.password}</li>
    <li class="list-group-item" ><a href="updateUser?id=${user.id}"><button type="button" class="btn btn-primary btn-center" >Edit</button></a></li>
  </ul>
</div>

</body>
</html>