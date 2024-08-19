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

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update Profile</p>
						
						

						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" value ="${user.name}" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" value ="${user.age}"  required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" value ="${user.mobile}"  required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" value ="${user.email}"  required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" value ="${user.password}"  required>
							</div>
							
							<input type="hidden" name="id" value="${user.id}">
							<button type="submit" class="btn bg-primary text-white col-md-12 " >Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>