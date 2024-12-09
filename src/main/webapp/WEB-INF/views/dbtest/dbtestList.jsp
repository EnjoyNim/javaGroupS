<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>dbtestList.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<style>
		#userInput th {
			text-align:center;
			background-color:#eee;
		}
	</style>
	
	<script type="text/javascript">
		'use strict';
		
		$(document).ready(function(){
			$("#userInput").hide();
			$("#btnShow").show();
			$("#btnHide").hide();
			
			$("#btnShow").click(function(){
				$("#userInput").show();
				$("#btnShow").hide();
				$("#btnHide").show();
			});
			
			$("#btnHide").click(function(){
				$("#userInput").hide();
				$("#btnShow").show();
				$("#btnHide").hide();
			});
		});
	
		function idCheck(){
			let mid = myform.mid.value;
			if(mid.trim()==""){
					alert("아이디를 입력하세요");
					return false;
			}
			
			let url = "${ctp}/dbtest/dbtestCheckForm?mid="+mid;
			window.open(url, "idCheckForm", "width=500px, height=250px");
			
		}
		
	</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/><p>
<div class="container">
		<h2 class="text-center">회원 리스트</h2>
		<hr/>
		<div>
			<!-- 메뉴(회원 가입폼 보이기/숨기기) -->
			<input type="button" value="회원가입창보이기" id="btnShow" class="btn btn-success mb-2" />
			<input type="button" value="회원가입창가리기" id="btnHide" class="btn btn-primary mb-2" />
		
		</div>
		<div id="userInput">
			 <!-- 회원 가입폼 -->
				<form name="myform" method="post" action="${ctp}/dbtest/dbtestInputOk">
					<table class="table table-bordered">
      <tr>
        <th>아이디</th>
        <td>
        		 <!-- 부트스트랩5 부터는 class="input-group" 하면 태그안에 요소들이 한줄이 된단다. --> 
        	<div class="input-group">
        		<span class="input-group-text bg-secondary">글자</span>
        		<input type="text" name="mid" id="mid" class="form-control" autofocus placeholder="아이디를 입력하세요"/>
        		<input type="button" value="아이디중복체크" onclick="idCheck()" class="btn btn-success"/>
        	</div>
        
        </td>
      </tr>
      <tr>
        <th>비밀번호</th><td><input type="password" name="pwd" id="pwd" class="form-control" placeholder="비밀번호를 입력하세요"/></td>
      </tr>
      <tr>
        <th>성명</th><td><input type="text" name="name" id="name" class="form-control" placeholder="성명을 입력하세요"/></td>
      </tr>
      <tr>
        <th>나이</th><td><input type="number" name="age" id="age" class="form-control" placeholder="나이를 입력하세요"/></td>
      </tr>
      <tr>
        <th>성별</th>
        <td>
          <input type="radio" name="gender" id="gender1" value="남자"/>남자 &nbsp;
          <input type="radio" name="gender" id="gender2" value="여자" checked />여자
        </td>
      </tr>
      <tr>
        <th>주소</th><td><input type="text" name="address" id="address" class="form-control" placeholder="주소를 입력하세요"/></td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
          <input type="submit" value="회원가입" class="btn btn-success mr-3" />
          <input type="reset" value="다시입력" class="btn btn-warning mr-3" />
        </td>
      </tr>
    </table>
	</form>
		</div>
		
		  <table class="table table-hover text-center">
    <tr class="table-secondary">
      <th>번호</th>
      <th>아이디</th>
      <th>비밀번호</th>
      <th>성명</th>
      <th>나이</th>
      <th>성별</th>
      <th>주소</th>
      <th>비고</th>
    </tr>
    <c:forEach var="vo" items="${vos}" varStatus="st">
      <tr>
        <td>${st.count}</td>
        <td>${vo.mid}</td>
        <td>${vo.pwd}</td>
        <td>${vo.name}</td>
        <td>${vo.age}</td>
        <td>${vo.gender}</td>
        <td>${vo.address}</td>
        <td>
          <span onclick="location.href='${ctp}/user/userUpdate?idx=${vo.idx}';" class="badge text-bg-warning" style="cursor:pointer">수정</span> /
          <a href="javascript:delCheck(${vo.idx})"><span class="badge text-bg-danger">삭제</span></a>
        </td>
      </tr>
    </c:forEach>
    <tr><td colspan="8" class="m-0 p-0"></td></tr>
  </table>
		
</div>
<p><br/><p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>