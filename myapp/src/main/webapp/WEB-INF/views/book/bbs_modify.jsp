<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>

<link href="resources/bootstrap/css/DetailPage.css" rel="stylesheet" type="text/css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="resources/bootstrap/css/custom.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>글 수정</title>
<script>
$(document).ready(function() {
   var formObj = $("form[role='form']");

   $(".modify_post").on("click",function() {

      formObj.attr("action", "modify_post");
      formObj.attr("method", "post");
      formObj.submit();
   });

});
</script>
</head>
<body>
         <%@include file="navi2.jsp" %>    
   

   <form role='form'>
      <input type="hidden" name="eNum" value='${detailBean.eNum}'/>
      <input type="hidden" name="ebNum" value='${detailBean.ebNum}'/>
      <input type="hidden" name="eId" value='${detailBean.eId}'/>
   
      <div class="container">
         <div class="row">

      
            <table class="table table-striped" style="text-align: center; border: 1 px solid #dddddd">
               <thead>
                  <tr>
                     <th colspan="3" style="background-color: #eeeeee; text-align: center;">독후감</th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td>제목</td>
                     <td><input type="text" class="form-control"
                        placeholder="글 제목" name="eSubject" maxlength="50"
                        value="${detailBean.eSubject}"></td>
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
                     <td><textarea class="form-control" placeholder="글 내용"
                           name="eContent" maxlength="2048" style="height: 350px;" value="${detailBean.eContent}">${detailBean.eContent}</textarea></td>
                  </tr>
               </tbody>
            </table>
            <input type="submit" class='modify_post' value="수정"> 
            <input type=button value="목록" onClick="history.back();">

         </div>
      </div>
   </form>   
   <%@include file="footer.jsp" %>
</body>
</html>