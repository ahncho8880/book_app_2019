<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<title>게시판 글보기</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
   var formObj = $("form[role='form']");
   
   $(".modify").on("click",function() {
      formObj.attr("action", "modify");
      formObj.attr("method", "get");
      formObj.submit();      
   });
   
   $(".drop_post").on("click",function(){
      formObj.attr("action","drop_post");
      formObj.attr("method", "post");
      formObj.submit();
   });
    var temp = '${detailBean.eContent}';
   $("#content0").html(temp);
   
});
</script>
</head>
<body>
	<%@include file="navi2.jsp"%>
	<form role='form'>
		<input type="hidden" name="num" value='${detailBean.eNum}' /> <input
			type="hidden" name="ebNum" value='${detailBean.ebNum}' />
	</form>

	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1 px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">독후감</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>제목</td>
						<td colspan="2">${detailBean.eSubject}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${detailBean.eId}</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${detailBean.eReg_date}" /></td>
					</tr>
					<tr>
						<td>내용</td>
						<td id="content0" colspan="2"
							style="min-height: 200px; text-align: left;" />${detailBean.eContent}</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" class='modify' value="수정"> <input
				type="submit" class='drop_post' value="삭제"> <input
				type=button value="목록" onClick="history.back();">

		</div>
	</div>
	<br>
	<%@include file="newFooter.jsp"%>
</body>
<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.js"></script>
</html>