<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<link href="resources/bootstrap/css/4-col-portfolio.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>search</title>
<style type="text/css">
 	.card-img-ahn{
	width: 254px; height: 350px;
    border-top-left-radius: calc(0.25rem - 1px);
 	border-top-right-radius: calc(0.25rem - 1px);
}
</style>
</head>
<body>
	<!-- navi -->
	<%@include file="navi.jsp"%>

	<!-- container -->
	<div class="container">

		<!-- Page Heading -->
		<h1 class="my-4">
			<small><%=request.getAttribute("kind")%></small>
		</h1>
		<div class="row">
		     <c:forEach items="${bookSearchList }" var="bookSearchList">
        <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href='bookinfoAction?num=${bookSearchList.bNum }&pagenum=1&contentnum=10'><img class="card-img-ahn" src="resources/bootstrap/images/${bookSearchList.bImg }" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href='bookinfoAction?num=${bookSearchList.bNum }&pagenum=1&contentnum=10'>${bookSearchList.bName }</a>
              </h4>
              <p class="card-text">${bookSearchList.bWriter }</p>
            </div>
          </div>
        </div>
        </c:forEach>
		</div>
		<!-- /.row -->

		<!-- Pagination -->
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
					class="sr-only">Next</span>
			</a></li>
		</ul>
	</div>
	<div class="footer-a">
		<%@include file="footer.jsp"%>
	</div>
	<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
</body>
</html>