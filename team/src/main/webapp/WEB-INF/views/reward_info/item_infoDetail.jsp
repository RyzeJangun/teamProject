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
<table border="1" width="50%">
		<tr>
			<th>아이템일련번호</th>
			<th>상품명</th>
			<th>단위 리워드 가격</th>
			<th>옵션</th>
			<th>남은 수량</th>
			<th>배송비</th>
			<th>배송예정일</th>
			<th>혜택률</th>

		</tr>
              
		<tr>	 		        	
				<td><input type="text" name="r_id" value="${dto2.r_id}" readonly></td>
				<td><input type="text" name="item_name" value="${dto2.item_name}" readonly></td>
				<td><input type="text" name="price_unit" value="<fmt:formatNumber value="${dto2.price_unit}"
					pattern="#,###원" />" readonly></td>
				<td><input type="text" name="item_option" value="${dto2.item_option}" readonly></td>
				<td><input type="text" name="rest_amount" value="${dto2.rest_amount}" readonly></td>
				<td><input type="text" name="delivery_fee" value="<fmt:formatNumber value="${dto2.delivery_fee}"
					pattern="#,###원" />" readonly></td>
				<td><input type="text" name="delivery_date" value="<fmt:formatDate value="${dto2.delivery_date}"
					pattern="yyyy-MM-dd" />" readonly></td>
				<td><input type="text" name="dc_ratio" value="${dto2.dc_ratio}" readonly></td>	  
		</tr>
		</table>
</body>
</html>