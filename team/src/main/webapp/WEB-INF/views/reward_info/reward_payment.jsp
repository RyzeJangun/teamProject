<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
// 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=delivery_postcode]").val(data.zonecode);
           $("[name=delivery_road]").val(fullRoadAddr);
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       }
    }).open();
}
function check(){
	document.form1.submit();
}

/*$(function() {
	$("#btnPay").click(function(){
		var rest_amount = $("#now_fund").val();
		var item_amount = $("#account").val();
		var total_reward = $("#account").val();
		var total_money = $("#account").val();
		var now_fund = $("#now_fund").val();
		var account = $("#account").val();
		if(eval(now_fund) > eval(account)){
			alert("투자 금액이 계좌 금액보다 많습니다.");
			return;	
		}
		document.form1.action="${path}/board/buy_success/${list.bno}";
		document.form1.submit();
	});
});*/

/* $(document).ready(function(){
	
}) */
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h1>${list.reward_name}</h1>
<form name="form1" method="post" action="${path}/reward_info/reward_payment.do">
	<table border="1" width="90%">
		<tr>
		    <th>프로젝트번호</th>
			<th>아이템일련번호</th>
			<th>상품명</th>
			<th>단위 리워드 가격</th>
			<th>옵션</th>
			<th>남은 수량</th>
			<th>배송비</th>
			<th>배송예정일</th>
			<th>혜택률</th>
			<th>리워드 수량</th>
			<th>총 리워드금액</th>
			<th>총 결제금액</th>
		</tr>
              <c:forEach var="var" items="${pay_view}">
		<tr>	 	
		        <td><input type="text" name="rno" value="${var.rno}" readonly></td>	        	
				<td><input type="text" name="r_id" value="${var.r_id}" readonly></td>
				<td><input type="text" name="item_name" value="${var.item_name}" readonly></td>
				<td><input type="text" name="price_unit" value="<fmt:formatNumber value="${var.price_unit}"
					pattern="#,###원" />" readonly></td>
				<td><input type="text" name="item_option" value="${var.item_option}" readonly></td>
				<td><input type="text" name="rest_amount" value="${var.rest_amount}" readonly></td>
				<td><input type="text" name="delivery_fee" value="<fmt:formatNumber value="${var.delivery_fee}"
					pattern="#,###원" />" readonly></td>
				<td><input type="text" name="delivery_date" value="<fmt:formatDate value="${var.delivery_date}"
					pattern="yyyy-MM-dd" />" readonly></td>
				<td><input type="text" name="dc_ratio" value="${var.dc_ratio}" readonly></td>
				<td><input type="number" name="item_amount" /></td>
				<td><input type="text" name="total_reward" /></td>
				<td><input type="text" name="total_money" /></td>	  
		</tr>
		     </c:forEach>
		 <tr>    	<td><input type="text" name="uno" value="${dto1.uno}" readonly></td>
		<td><input type="text" name="userid" value="${dto1.userid}" readonly></td>
		<td><input type="text" name="name " value="${dto1.name}" readonly></td></tr>
		<tr align="center"><th colspan="10">배송지 주소</th><th></th></tr>
		<tr align="center">
		 <td colspan="10"><input placeholder="우편번호" name="delivery_postcode" id="delivery_postcode" type="text" readonly="readonly"></td><td rowspan="3"><button type="button" class="btn btn-default"
					onclick="execPostCode();">
					<i class="fa fa-search"></i> 우편번호 찾기
				</button></td>
		 </tr>
		 <tr align="center">
		 <td colspan="10"><input placeholder="도로명 주소" name="delivery_road" id="delivery_road" type="text" readonly="readonly"></td>
		 </tr>
		 <tr align="center">
		 <td colspan="10"><input placeholder="세부 주소" name=" delivery_detail" id="delivery_detail" type="text"></td>
		 </tr>		
	</table>
	<button type="button" onclick="check()">구매하기</button><input type="submit" value="구매하기">
	</form>
</body>
</html>