<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<%@ include file="components/bootstrapCss.jsp"%>
</head>
<body>

	<%@ include file="components/navbar.jsp"%>
	
	<c:if test="${not empty msg}">
	
	
	<h1 class="text-center text-success">${msg}</h1>
	
	
	
	
	</c:if>
	
	



</body>
</html>