<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/><p>
<div class="container">
	<h3>아이디 중복체크</h3>
	<hr/>
	<div class="text-center">
		<c:if test="${isDuplicateId == 'NO'}"><font color="red"><b>${mid}는 사용 가능한 아이디 입니다.</b></font></c:if>
		<c:if test="${isDuplicateId == 'YES'}">
			<font color="red"><b>${mid}는 사용할 수 없는 아이디입니다.</b></font>
		
		</c:if>
	</div>
</div>
<p><br/><p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>