<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript">
function page(idx){
   var pagenum = idx;
   var contentnum = 10;
   location.href="${pageContext.request.contextPath}/bookinfoAction?num=${list[0].ebNum}&pagenum="+pagenum+"&contentnum="+contentnum+"#gobottom";
}
</script>

   <div class="container"  id="gobottom">
      <a class="btn btn-primary" style="text-align:center;" href='write_report?booknum=${list[0].ebNum}&eid=<%=userID %>&logon=<%=logon %>'>글쓰기</a>
      
      <table class="table table-hover">
      <thead>
         <tr>
            <th>No.</th>
            <th>타이틀</th>
            <th>작성자</th>
            <th>작성일자</th>
            <th><img style="max-width: 100%;"
               src="/resources/bootstrap/images/LIKE32X32.png"/> 좋아요</th>
            <th><img style="max-width: 100%;"
               src="/resources/bootstrap/images/DONTLIKE32X32.png"/> 싫어요</th>
         </tr>
      </thead>
      <% int i=1; %>
      <tbody>
         <c:forEach items="${list}" var="list">
            <tr>
               <td><%=i++ %></td>
               <td><a href='read?num=${list.eNum}&logon=<%=logon%>&booknum=${list.ebNum}'>${list.eSubject}</a></td>
               <td><a href='read?num=${list.eNum}&logon=<%=logon%>&booknum=${list.ebNum}'>${list.eId}</a></td>               
               <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.eReg_date}" /></td>
               <td>${list.eLike}</td>
               <td>${list.eunLike}</td>
            </tr>
         </c:forEach>
      </tbody>   
      <tfoot>
         <tr>
            <td colspan="2">
               <c:if test="${page.prev}">
                  <a style="text-decoration: none;" href="javascript:page(${page.getStartPage()-1});">&laquo;</a>
               </c:if>
               <c:forEach begin="${page.getStartPage()}" end="${page.getEndPage()}" var="idx">
                  <a style="text-decoration: none;" href="javascript:page(${idx});" >${idx}</a>
               </c:forEach>               
               <c:if test="${page.next}">
                  <a style="text-decoration: none;" href="javascript:page(${page.getEndPage()+1});">&raquo;</a>
               </c:if>
            </td>
         </tr>      
      </tfoot>
      </table>
   </div>