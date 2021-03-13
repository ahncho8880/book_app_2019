<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<title>게시판 글쓰기</title>
<script>
$(document).ready(function() {
   var formObj = $("form[role='form']");

   $(".write_post").on("click",function() {

      formObj.attr("action", "write_post");
      formObj.attr("method", "post");
      formObj.submit();
   });

});
</script>
</head>
<%
   boolean logon = false;
   String userID = (String) session.getAttribute("LOGIN");
   out.print(userID);
   if (userID != null)
      logon = true;
%>
<body>

    <form role='form'>
   <div class="container">
      <div class="row">
<!-- <form action="write_post" method="POST"> -->
   
      <input type="hidden" name="eId" value='${eId}' />
      <input type="hidden" name="ebNum" value='${ebNum}' />
      <input type="hidden" name="eNum" value='${eNum}' />
      
         <table class="table table-striped" style="text-align: center; border: 1 px solid #dddddd">
            <thead>
               <tr>
                  <th colspan="2" style="background-color: #eeeeee; text-align: center;">글쓰기</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td><input type="text" class="form-control" placeholder="글 제목" name="eSubject" maxlength="50" value="${writebean.eSubject}"></td>
               </tr>
               <tr>
                  <td><textarea class="form-control" placeholder="글 내용" name="eContent" maxlength="2048" style="height: 350px;" value="${writebean.eContent}"></textarea></td>                  
               </tr>
            </tbody>
         </table>

         <input type="submit" class='write_post' value="등록">         
         <input type=button class="btn btn-primary" value="목록" onClick="history.back();"> 
         <!-- <input type="submit" class="btn btn-primary pull-right" value="글쓰기"> -->
      </div>
   </div>
   </form>   
</body>
</html>