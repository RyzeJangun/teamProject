<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
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

/*$(function(){
	$("#userid").blur(function(){
		var userid=$("#userid").val();
	    $.ajax({
	        type:"GET",
	        data:num,
	        url:"${path}/reward_info/reward_add.do?r_id="+r_id,
	        success: function(num){
	            if(num == 1){
	            	$("#userid_check").text("아이디가 중복됩니다.");
	            	$("#userid_check").css('color', 'red');   
	            	$('#userid_check').focus();
	            }else if(num == 0 && userid != ""){
	                $("#userid_check").text("사용 가능한 아이디 입니다.");
	            	$("#userid_check").css('color', 'green');  
	            	$('#userid_check').focus(); 
	            }  //end if	            
	        }//end sucess
	    });//end ajax
	});//end function
});*/

/*function renameForModelAttribute() {
	var index= $("#index").val();
    $("#form").click( function (index) {
        $(this).find("input[name=rno]").attr("name", "test[" + index + "].rno");
        $(this).find("input[name=r_id]").attr("name", "test[" + index + "].r_id");
        $(this).find("input[name=item_name]").attr("name", "test[" + index + "].item_name");
        $(this).find("input[name=price_unit]").attr("name", "test[" + index + "].price_unit");
        $(this).find("input[name=item_option]").attr("name", "test[" + index + "].item_option");
        $(this).find("input[name=delivery_fee]").attr("name", "test[" + index + "].delivery_fee");
        $(this).find("input[name=delivery_date]").attr("name", "test[" + index + "].delivery_date");
        $(this).find("input[name=item_amount]").attr("name", "test[" + index + "].item_amount");
        $(this).find("input[name=total_reward]").attr("name", "test[" + index + "].total_reward");
        $(this).find("input[name=total_money]").attr("name", "test[" + index + "].total_money");
        $(this).find("input[name=userid]").attr("name", "test[" + index + "].userid");
        
    }
}*/
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

function checkboxArr() {
    var checkArr = [];     // 배열 초기화
    $("input[name='r_id']:checked").each(function(i)) {
        checkArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
    }
 
    $.ajax({
        url: 'r_id'
        , type: 'post'
        , dataType: 'text'
        , data: {
            valueArrTest: checkArr
        }
    });
}





function add () {
	var hm = document.form.item_amount;
	var price_unit=document.form.price_unit.value;
	var delivery_fee=document.form.delivery_fee.value;
	var total_reward = document.form.total_reward;
	var total_money=document.form.total_money;
	hm.value ++ ;
	total_reward.value = eval(hm.value) * eval(price_unit);
	total_money.value= eval(hm.value) * eval(price_unit) + eval(delivery_fee);
	
}

function del () {
	var hm = document.form.item_amount;
	var price_unit=document.form.price_unit.value;
	var delivery_fee=document.form.delivery_fee.value;
	var total_reward = document.form.total_reward;
	var total_money=document.form.total_money;
		if (hm.value > 0) {
			hm.value -- ;
			total_reward.value = eval(hm.value) * eval(price_unit);
			total_money.value= eval(hm.value) * eval(price_unit) + eval(delivery_fee);
		}
}

</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h1>${reward_name.reward_name}</h1>
<form name="form" method="post" action="${path}/reward_info/reward_payment.do">
	<table border="1" width="120%">
		<tr>
		    <th>아이템 선택</th>
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
		        <td><input type="checkbox" name="r_id"><input type="hidden" name="rno" value="${var.rno}"><input type="hidden" name="reward_name" value="${reward_name.reward_name}"><input type="hidden" name="company_name" value="${reward_name.company_name}"><input type="hidden" name="r_id" value="${var.r_id}"></td>	 	           	
				<td>${var.r_id}</td>
				<td><input type="text" name="item_name" value="${var.item_name}" readonly></td>
				<td><input type="text" name="price_unit" value="${var.price_unit}" readonly>원</td>
				<td><input type="text" name="item_option" value="${var.item_option}" readonly></td>
				<td>${var.rest_amount}</td>
				<td><input type="text" name="delivery_fee" value="${var.delivery_fee}" readonly/>원</td>
				<td><input type="text" name="delivery_date" value="<fmt:formatDate value="${var.delivery_date}"
					pattern="yyyy/MM/dd" />" readonly></td>
				<td><input type="text" name="dc_ratio" value="${var.dc_ratio}" readonly>%</td>
				<td>
                    <input type="button" value=" - " onclick="del()">
                    <input type="text" name="item_amount" value="0">
                    <input type="button" value=" + " onclick="add()"></td>
				<td><input type="text" name="total_reward" value="0"/>원</td>
				<td><input type="text" name="total_money" value="0"/></td>
				<td><input type="hidden" name="userid" value="${user_info.userid}" /><input type="hidden" name="name" value="${user_info.name}" /><input type="hidden" name="uno" value="${user_info.uno}" /></td>	  
		</tr>
 			</c:forEach>
		 <tr align="center"><th colspan="12">배송지 주소</th><th></th></tr>
		<tr align="center">
		 <td colspan="11"><input placeholder="우편번호" name="delivery_postcode" id="delivery_postcode" type="text" readonly="readonly"></td><td rowspan="3"><button type="button" class="btn btn-default"
					onclick="execPostCode();">
					<i class="fa fa-search"></i> 우편번호 찾기
				</button></td>
		 </tr>
		 <tr align="center">
		 <td colspan="11"><input placeholder="도로명 주소" name="delivery_road" id="delivery_road" type="text" readonly="readonly"></td>
		 </tr>
		 <tr align="center">
		 <td colspan="11"><input placeholder="세부 주소" name="delivery_detail" id="delivery_detail" type="text"></td>
		 </tr>
	<tr><td colspan="12" align="center"><button type="submit">구매하기</button></td></tr>
	</table>
	</form>
	
</body>
</html>