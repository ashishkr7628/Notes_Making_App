<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrapCss.jsp"%>
</head>
<body>
<%@ include file="../components/homeNavbar.jsp"%>

<div class="row">
<c:forEach items="${list }" var="n">
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">${n.title}</h5>
        <p class="card-text">${n.body}</p>
        <a href="updateNotes?id=${n.id }" class="btn btn-primary">Edit</a>
        <a href="deleteNotes?id=${n.id }" class="btn btn-primary">Delete</a>
      </div>
    </div>
  </div>
  </c:forEach>
</div>



</body>
</html>