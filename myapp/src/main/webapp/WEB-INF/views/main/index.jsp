<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<title>みんなの本</title>
<style type="text/css">

</style>
</head>
<body>
	<!-- navi -->
	<%@include file="navi.jsp" %>	
	<br>
	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center">みんなの本</h1>
			<p class="text-center">독후감 책사이트입니다</p>
			<p class="text-center">
				<a class="btn btn-primary btn-lg" href="#" role="button">enter</a>
			</p>
		</div>
	</div>
	<!-- footer -->
	<div class="threebox">
		<%@include file="so2.jsp"%>
	</div>
	<%@include file="newFooter.jsp"%>
</body>
	<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
</html>