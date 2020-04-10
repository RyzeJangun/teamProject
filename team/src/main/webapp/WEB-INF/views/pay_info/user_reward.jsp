<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<table border="1" width="100%">
		<tr>
			<th>회사명</th>
			<th>리워드 프로젝트명</th>
			<th>카테고리</th>
			<th>마감일자</th>
			
		</tr>
		<tr>
			<td>${list.company_name}</td>
			<td><a href="${path}/reward_info/user_reward.do/${pay_reward.rno}">${list.reward_name}</a></td>
			<td>${list.reward_category}</td>
			<td><fmt:formatDate value="${list.end_date}"
					pattern="yyyy-MM-dd" /></td>
		</tr>
	</table>
</body>
</html>