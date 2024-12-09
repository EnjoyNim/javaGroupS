<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	
	function sendIdToParent(){
		
		if(${isDuplicateId == 'NO'}){ // 중복아이디가 아니라면
			// let mid = '${mid}';
			// 부모창의 mid 입력칸에 값을 넣어줌
			// opener.document.getElementById("mid").value = mid;
		
		}else{	// 중복아이디라면 빈칸으로 해줌
			opener.document.getElementById("mid").value = '';
		}
		
		window.close();
		
	}
	
	</script>
</head>
<body>

<div class="container">
	<h3>아이디 중복체크</h3>
	<hr/>
	<div class="text-center">
	
		<c:if test="${isDuplicateId == 'NO'}"><font color="blue"><b>${mid}는 사용 가능한 아이디 입니다.</b></font></c:if>
		
		<c:if test="${isDuplicateId == 'YES'}"><font color="red"><b>${mid}는 사용할 수 없는 아이디입니다.</b></font></c:if>
		
		<input type="button" value="닫기" onclick="sendIdToParent()">	
	</div>
</div>
</body>
</html>