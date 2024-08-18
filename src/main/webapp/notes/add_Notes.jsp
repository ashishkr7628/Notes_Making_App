<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrapCss.jsp"%>
</head>
<body>
<%@ include file="../components/homeNavbar.jsp"%>
<form class="form-floating" action="../add_notes" method="post">
<div class="card w-50 " >
  <div class="card-body">
    <h5 class="card-title">
  <label for="floatingInputValue">Title</label>
  <input type="text" class="form-control" id="floatingInputValue" placeholder="Enter your Title"  name="title">
</h5>
  <label for="floatingInputValue">Description</label>
    <p class="card-text">
  <input type="text" class="form-control" id="floatingInputValue" placeholder="Enter your Description" name="body" >
</p>
    <input type="submit">
  </div>
</div>
</form>
</body>
</html>