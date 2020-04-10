<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>리워드목록</h2>

<table border="1" width="100%">
	<tr>
	    <th>프로젝트 사진</th>
		<th>회사명</th>
		<th>리워드 프로젝트명</th>
		<th>카테고리</th>
		<th>게시일자</th>
		<th>종료일자</th>
		<th>남은 일수</th>
		<th>목표투자액</th>
		<th>현재투자액</th>
		<th>투자율</th>	
	</tr>
<c:forEach var="row" items="${list}"> 
	<tr>
	    <td><img src="${path}/images/${row.pro_thumbnail}" width="100%" height="100%"></td>
		<td>${row.company_name}</td>
		<td><a href="${path}/reward_info/reward_infoDetail/${row.rno}">${row.reward_name}</a></td>
		<td>${row.reward_category}</td>
		<td><fmt:formatDate value="${row.start_date}" pattern="yyyy-MM-dd" /></td>
		<td><fmt:formatDate value="${row.end_date}" pattern="yyyy-MM-dd" /></td>
		<td>미구현</td>
		<td><fmt:formatNumber value="${row.reward_max}"
					pattern="#,###원" /></td>
		<td><fmt:formatNumber value="${row.reward_now}"
					pattern="#,###원" /></td>
		<td>${row.reward_ratio}%</td>							
	</tr>
</c:forEach>	
</table>
</body>
</html>
