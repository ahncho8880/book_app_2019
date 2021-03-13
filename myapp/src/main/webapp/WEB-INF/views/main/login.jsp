<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" inital-scale="1">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="resources/bootstrap/css/custom.css">
<title>login</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#login").click(function(){
		
	});
});
</script>
</head>
<body>
	<%@include file="navi.jsp"%>
	<div class="container">
		<h1 class="form-heading">login Form</h1>
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Login</h2>
					</p>
				</div>
				<form id="Login" action="login" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" id="inputId"
							placeholder="Id" name="mID">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="Password" name="mPasswd">
					</div>
					<div class="forgot">
						<a href="#">Forgot password?</a>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
			<p class="botto-text">Designed by Sunil Rajput</p>
		</div>
	</div>
	</div>
	<!-- footer -->
	<div class="footer-a">
		<%@include file="footer.jsp"%>
	</div>
</body>
<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
</html>