<%@page import="com.org.dto.User"%>


<% String path = request.getContextPath(); %>
<% String userName =(String)session.getAttribute("userName"); %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.jsp">Note Making</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=path %>/viewUser">Profile</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="notes/add_Notes.jsp">Add Notes</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=path %>/view_Notes">View Notes</a></li>	
					
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="logout">logout</a></li>
				</ul>

			</div>
		</div>
	</nav>