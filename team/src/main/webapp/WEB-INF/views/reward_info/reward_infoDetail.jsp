<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>

</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>리워드목록</h2>

	<table border="1" width="100%">
		<tr>
		    <th>프로젝트 사진</th>
			<th>회사명</th>
			<th>리워드 프로젝트명</th>
			<th>카테고리</th>
			<th>게시일자</th>
			<th>마감일자</th>
			<th>목표투자액</th>
			<th>현재투자액</th>
			<th>투자율</th>
			<th>투자자 수</th>
			<th>조회수</th>
			<th>좋아요 수</th>
		</tr>
		<tr>
		    <td><img src="${path}/images/${list.pro_thumbnail}" width="100%" height="100%"></td>
			<td>${list.company_name}</td>
			<td>${list.reward_name}</td>
			<td>${list.reward_category}</td>
			<td><fmt:formatDate value="${list.start_date}"
					pattern="yyyy-MM-dd" /></td>
			<td><fmt:formatDate value="${list.end_date}"
					pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatNumber value="${list.reward_max}"
					pattern="#,###원" /></td>
			<td><fmt:formatNumber value="${list.reward_now}"
					pattern="#,###원" /></td>
			<td><fmt:formatNumber value="${list.reward_ratio}"
					pattern="##%" /></td>
			<td>${list.reward_investor}명</td>
			<td>${list.pro_view}명</td>
			<td>${list.pro_like}<a href="${path}/reward_info/pro_like.do?rno=${list.rno}">  +</a></td>
		</tr>
	</table>
	<br>

	<h2>단계별 투자</h2>
	<table border="1" width="90%">
		<tr>
			<th>아이템일련번호</th>
			<th>상품명</th>
			<th>단위 리워드 가격</th>
			<th>옵션</th>
			<th>남은 수량</th>
		</tr>

			<c:forEach var="var" items="${step}">			
		<tr>
				<td>${var.r_id}</td>
				<td><a href="${path}/reward_info/item_infoDetail/${var.r_id}">${var.item_name}</a></td>
				<td><fmt:formatNumber value="${var.price_unit}"
					pattern="#,###원" /></td>
				<td>${var.item_option}</td>
				<td>${var.rest_amount}개</td>
		</tr>
			</c:forEach>
	</table>
   <a href="${path}/reward_info/pay_view/${list.rno}">펀딩하기</a>

</body>
</html>
