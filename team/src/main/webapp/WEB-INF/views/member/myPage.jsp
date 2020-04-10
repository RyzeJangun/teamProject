<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="${path}/member/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/member/delete.do";
			document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>회원정보 수정</h2>
<form name="form1" method="post">
<table border="1" width="400px">
	<tr>
		<td>회원번호</td>
		<td><input name="userid" value="${user_info.uno}" readonly></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input name="userid" value="${user_info.userid}" readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td> 
	</tr>
	<tr>
		<td>이름</td>
		<td><input name="name" value="${user_info.name}"></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><input name="birth" value="<fmt:formatDate value="${user_info.birth}" 
			pattern="yyyy-MM-dd" />"></td>
	</tr>
	<tr>
		<td>성별</td>
		<td><input name="gender" value="${user_info.gender}"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input name="email1" value="${user_info.email1}">@<input name="email2" value="${user_info.email2}"></td>
	</tr>
		<tr>
		<td>전화번호</td>
		<td><input name="hp" value="${user_info.hp}"></td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td><input name="postcode" value="${user_info.postcode}"></td>
	</tr>
	<tr>
		<td>도로명주소</td>
		<td><input name="road_addr" value="${user_info.road_addr}"></td>
	</tr>
	<tr>
		<td>세부주소 </td>
		<td><input name="detail_addr" value="${user_info.detail_addr}"></td>
	</tr>
	
	<tr>
		<td>회원가입일자</td>
		<td>

		
		<fmt:formatDate value="${user_info.join_date}" 
			pattern="yyyy-MM-dd" />
			
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="수정" id="btnUpdate">
			<input type="button" value="삭제" id="btnDelete">
			<div style="color: red;">${message}</div>	
		</td>
	</tr>
</table>
</form>

<h1>내 가상계좌</h1>
<table>
<tr>
<td>${user_info.ac_number}</td>
</tr>
</table>
<table>
	<c:choose>
		<c:when test="${user_info.ac_number == '' && user_info.ac_number == null}">
			<tr>
				<td>계좌번호</td>
				<td>계좌번호 등록하세요.</td>
				<td><a href="${path}/member/ac_sign_route/${user_info.uno}">계좌 등록하기</a></td>
			</tr>	
		</c:when>
		<c:otherwise>
			<tr>
				<td>계좌번호</td>
				<td>${user_info.ac_number}</td>
				<td><a href="#">계좌충전</a></td>
			</tr>
		</c:otherwise>	
</c:choose>
		</table>
</body>
</html>
	