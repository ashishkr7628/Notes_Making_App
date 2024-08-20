<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp"%>

<style type="text/css">


p{

align-content: center;
align-items: center;





}</style>
</head>
<body>
	<%@ include file="components/homeNavbar.jsp"%>
	<%if(userName==null){
		
		response.sendRedirect("login.jsp");
		
	}
		%>
	
	

<h1 class="text-success position-absolute top-50 start-50 translate-middle">Welcome to Homepage</h1>

</body>
</html>