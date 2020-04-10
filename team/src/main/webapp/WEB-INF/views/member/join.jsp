<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- views/member/write.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>회원가입</title>
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
           
           
           $("[name=postcode]").val(data.zonecode);
           $("[name=road_addr]").val(fullRoadAddr);
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       }
    }).open();
}



/* $(document).ready(function(){
	
}) */
$(function(){
	$("#userid").blur(function(){
		var userid=$("#userid").val();
	    $.ajax({
	        type:"GET",
	        url:"${path}/member/userid_check.do?userid="+userid,
	        success: function(num){
	            if(num == 1){
	            	$("#userid_check").text("아이디가 중복됩니다.");
	            	$("#userid_check").css('color', 'red');   
	            }else if(num == 0 && userid != ""){
	                $("#userid_check").text("사용 가능한 아이디 입니다.");
	            	$("#userid_check").css('color', 'green');   
	            }else if(userid == ""){
	                $("#userid_check").text("아이디 입력요망");
	            	$("#userid_check").css('color', 'blue');   
	            }//end if
	        }//end sucess
	    });//end ajax
	});//end function

	//비밀번호 확인
	$("#confirm_passwd").keyup(function(){
	   if($('#passwd').val() != $('#confirm_passwd').val()){
		    $("#passwd_check").text("비밀번호가 일치하지 않습니다.");
		    $("#passwd_check").css('color', 'red');
	        $('#confirm_passwd').focus();
	   }else if($('#passwd').val() == $('#confirm_passwd').val()){			    	
	    	$("#passwd_check").text("비밀번호가 일치합니다.");
	    	$("#passwd_check").css('color', 'green');
	        $('#confirm_passwd').focus();
	   }	    
	});


function check() {
	//아이디 체크
	var userid = document.getElementById("userid");
	if (userid.value == "") {
		alert("아이디는 필수 입력입니다.");
		userid.focus();
		return;
	}
	//비밀번호 체크
	var passwd = document.getElementById("passwd");
	if (passwd == "") {
		alert("비밀번호는 필수 입력입니다.");
		passwd.focus();
		return;
	}
	

	//이름 체크
	var name = document.getElementById("name");
	if (name.value == "") {
		alert("이름을 입력하세요.");
		name.focus();
		return;
	}
	
	//이메일 체크
	var email = document.getElementById("email");
	if (email.value == "") {
		alert("이메일을 입력하세요.");
		email.focus();
		return;
	}
	
	//주소 체크
	var addr1 = document.getElementById("addr1");
	if (addr1.value == "") {
		alert("우편번호 찾기를 누르세요.");
		addr1.focus();
		return;
	}
	document.form1.submit();
}

</script>

</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<div class="container">
		<h2>회원등록</h2>
		<form name="form1" method="post" action="${path}/member/join.do">
			<div class="form-group">
				아이디 <input class="form-control" placeholder="아이디" name="userid"
					id="userid" type="text" />
			</div>
			<div class="form-group">
				<div id="userid_check"></div>
			</div>
			<div class="form-group">
				비밀번호 <input class="form-control" placeholder="비밀번호" name="passwd"
					id="passwd" type="password" />
			</div>

			<div class="form-group">
				비밀번호 재확인 <input class="form-control" placeholder="비밀번호"
					 id="confirm_passwd" type="password" />
			</div>
			<div class="form-group">
				<div id="passwd_check"></div>
			</div>

			<div class="form-group">
				성명 <input class="form-control" placeholder="성명" name="name"
					id="name" type="text" />
			</div>

			<div class="form-group">
				<input class="form-control" placeholder="생년월일" name="birth"
					id="birth" type="date" />
			</div>


			<div class="form-group">
				<select class="form-control" name="gender" id="gender">
					<option value="">성별을 고르시오.</option>
					<option value="남자">남자</option>
					<option value="여자">여자</option>
				</select>
			</div>

			<div class="form-group">
				이메일 <input placeholder="(영문대소문자,숫자를 사용한 8자~15자 이내로 입력하시오.)"
					name="email1" id="email1" type="text" /> @ <input
					placeholder="직접 입력" name="email2" id="email2" type="text" />
			</div>
			
				<div class="form-group">
				전화번호 <input class="form-control" placeholder="성명" name="hp"
					id="hp" type="tel" pattern="(010)-\d{3,4}-\d{4}" title="010-####-####" />
			</div>


			<div class="form-group">
				주소<br> <input class="form-control"
					style="width: 40%; display: inline;" placeholder="우편번호"
					name="postcode" id="addr1" type="text" readonly="readonly">
				<button type="button" class="btn btn-default"
					onclick="execPostCode();">
					<i class="fa fa-search"></i> 우편번호 찾기
				</button>
			</div>
			<div class="form-group">
				<input class="form-control" style="top: 5px;" placeholder="도로명 주소"
					name="road_addr" id="addr2" type="text" readonly="readonly" />
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="상세주소" name="detail_addr"
					id="addr3" type="text" />
			</div>
	
	<!-- <input type="submit" class="btn btn-lg btn-success btn-block" value="확인"> -->
	<input type="submit" class="btn btn-lg btn-success btn-block"
		onclick=check() value="확인">
	</form>
	</div>
</body>
</html>
