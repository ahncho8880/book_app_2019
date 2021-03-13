<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String[] arr = {"First Slide","Second Slide","Third Slide"};
	String[] move = {"carousel-item active","carousel-item","carousel-item"};
    request.setAttribute("slide", arr);
	request.setAttribute("slide2", move);
	int slideNo=0;
%>
<style>
.col-md-6 {
	max-width: 33%;
}

.w-100 {
	width: 45% !important;
}

.leftp {
	float: left;
}

.carousel-caption {
	left: 55%;
	bottom: -10px;
	color: #000000;
	font-family: monospace;
	font-size: 11px;
	text-align: -webkit-auto;
}

.carousel-indicators {
	right: -133px;
	bottom: -5px;
}

.carousel-indicators li {
	background-color: #d9d9d9;
}

.carousel-indicators .active {
	background-color: #6d6d6d;
}

.middle {
	transition: .5s ease;
	opacity: 0;
	position: absolute;
	top: 50%;
	left: 22%;
	transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	text-align: center;
}

.carousel-item:hover .d-block w-100 {
	opacity: 0.3;
}

.carousel-item:hover .middle {
	opacity: 1;
}

.text {
	background-color: rgba(0, 0, 0, 0.8);
	color: white;
	font-size: 15px;
	padding: 7px 12px;
}
</style>
	<c:forEach items="${bookinfo}" var="bookinfo">
		<%-- <tr>
			<td>${bookinfo.bNum}</td>
			<td>${bookinfo.bWriter}</td>
			<td>${bookinfo.bSynop}</td>
			<td><a href='read?num=${bookinfo.bNum}'>${bookinfo.bName}</a>
			</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
					value="${bookinfo.bReg}" /></td>
		</tr> --%>
	</c:forEach>
	<div class="container">

		<div class="row">

			<section class="col-md-6">
			<p>New</p>
			<div id="carousel1_indicator" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel1_indicator" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel1_indicator" data-slide-to="1"
						class="active"></li>
					<li data-target="#carousel1_indicator" data-slide-to="2"
						class="active"></li>
				</ol>
				
				<div class="carousel-inner">
					<c:forEach items="${newbookinfo}" var="newbookinfo" varStatus="status" >
						
						<div class="${slide2[status.index]}" >
							<a href='bookinfoAction?num=${newbookinfo.bNum }&pagenum=1&contentnum=10'> <img class="d-block w-100"
								src="resources/bootstrap/images/${newbookinfo.bImg }" alt=	"${slide[status.index] }">
							</a>
							<p class="carousel-caption d-none d-md-block">${newbookinfo.bSynop }</p>
						</div>
						
					</c:forEach>
				</div>
			</div>
			</section>



			<section class="col-md-6">
			<p>Hot</p>
			<div id="carousel1_indicator" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel1_indicator" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel1_indicator" data-slide-to="1"></li>
					<li data-target="#carousel1_indicator" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
				<c:forEach items="${hitbookinfo}" var="hitbookinfo" varStatus="status2" >
					<div class="${slide2[status2.index ] }">
					<a href='bookinfoAction?num=${hitbookinfo.bNum }&pagenum=1&contentnum=10'>
						<img class="d-block w-100"
							src="resources/bootstrap/images/${hitbookinfo.bImg }" alt="${slide[status2.index ] }">
					</a>
						<p class="carousel-caption d-none d-md-block">${hitbookinfo.bSynop }</p>
					</div>
				</c:forEach>
				</div>
			</div>
			</section>




			<section class="col-md-6">
			<p>Top3</p>
			<div id="carousel1_indicator" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel1_indicator" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel1_indicator" data-slide-to="1"></li>
					<li data-target="#carousel1_indicator" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100"
							src="resources/bootstrap/images/book7.jpg" alt="First slide">
						<p class="carousel-caption d-none d-md-block">과거 심리학으로부터 많은
							도움을 받았고, 독자들에게도 실제 도움이 되길 바라는 마음을 담아 펴낸 책</p>
					</div>
				</div>
			</div>
			</section>

		</div>
	</div>
<br>
<br>
<br>