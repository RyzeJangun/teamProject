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

	<table border="1" width="120%">
		<tr>
		    <th>아이템 선택</th>
			<th>아이템일련번호</th>
			<th>상품명</th>
			<th>단위 리워드 가격</th>
			<th>옵션</th>
		
			<th>배송비</th>
			<th>배송예정일</th>
			<th>혜택률</th>
			<th>리워드 수량</th>
			<th>총 리워드금액</th>
			<th>총 결제금액</th>
		</tr>
              <c:forEach var="pay_reward" items="${pay_reward}">
		<tr>    
		        <td><input type="text" name="rno" value="${pay_reward.rno}"><input type="text" name="reward_name" value="${pay_reward.reward_name}"><input type="text" name="company_name" value="${pay_reward.company_name}"><input type="text" name="r_id" value="${var.r_id}"></td>	 	           	
				<td>${pay_reward.r_id}</td>
				<td><input type="text" name="item_name" value="${pay_reward.item_name}" readonly></td>
				<td><input type="text" name="price_unit" value="${pay_reward.price_unit}" readonly>원</td>
				<td><input type="text" name="item_option" value="${pay_reward.item_option}" readonly></td>
				
				<td><input type="text" name="delivery_fee" value="${pay_reward.delivery_fee}" readonly/>원</td>
				<td><input type="text" name="delivery_date" value="<fmt:formatDate value="${pay_reward.delivery_date}"
					pattern="yyyy-MM-dd" />" readonly></td>
				<td><input type="text" name="dc_ratio" value="${pay_reward.dc_ratio}" readonly>%</td>
				<td><input type="text" name="item_amount" value="${pay_reward.item_amount}"></td>
				<td><input type="text" name="total_reward" value="${pay_reward.total_reward}"/>원</td>
				<td><input type="text" name="total_money" value="${pay_reward.total_money}"/></td>
				<td><input type="text" name="userid" value="${pay_reward.userid}" /><input type="text" name="name" value="${pay_reward.name}" /><input type="text" name="uno" value="${pay_reward.uno}" /></td>	  
		</tr>
 </c:forEach>
	</table>
</body>
</html>