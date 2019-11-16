<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var result = '${msg}';
	console.log(result);
	if(result=='SUCCESS'){
		alert("처리완료");
	}
</script>
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
		<td><a href="/board/read?bno=${boardVO.bno}" ><c:out value="${boardVO.title }"></c:out></a></td>
		<td><c:out value="${boardVO.writer }"></c:out></td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate }"></fmt:formatDate></td>
		<td><span class="badge bg-red"><c:out value="${boardVO.viewcnt }"/></span></td>
	</tr>	
	</c:forEach>
	
</table>

<%@include file="../include/footer.jsp" %>
</body>
</html>