<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp" %>

<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>
	<c:forEach var="boardVO" items="${list}">
	<tr>
		<td><c:out value="${boardVO.bno }"></c:out></td>
		<td><a href="/board/readPage?bno=${boardVO.bno}" ><c:out value="${boardVO.title }"></c:out></a></td>
		<td><c:out value="${boardVO.writer }"></c:out></td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate }"></fmt:formatDate></td>
		<td><span class="badge bg-red"><c:out value="${boardVO.viewcnt }"/></span></td>
	</tr>	
	</c:forEach>
	
</table>
<div class="text-center">
	<ul class="pagination">
		<c:if test="${pageMaker.prev }">
			<li><a href="listPage?page=${pageMaker.startPage -1 }">&laquo;</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
		 	<li <c:out value="${pageMaker.cri.page==idx?' class=active':' '}"/>>
		 	<a href="listPage?page=${idx }">${idx}</a>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage>0}">
			<li><a href="listPage?page=${pageMaker.endPage +1 }">&raquo;</a></li>
		</c:if>
	</ul>
</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>