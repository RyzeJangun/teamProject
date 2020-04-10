<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#userid").val(); //태그의 value 속성값
		var passwd=$("#passwd").val();
		if(userid==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus(); //입력 포커스 이동
			return; //함수 종료
		}
		if(passwd==""){
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return;
		}
		//폼 데이터를 서버로 제출
		document.form1.action="${path}/member/login.do";
		document.form1.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

<h1 style="text-align: center;"><img src="images/music_16-wallpaper-1920x1080.jpg" width="60%" height="60%"></h1>
		<br><br>
<div class="container" id="container">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-success">

			<div class="panel-body">
			<form name="form1" method="post">
				<div><input type="text" class="form-control" name="userid" id="userid" placeholder="아이디">
				</div><br>
				<div><input type="password" class="form-control" name="passwd" id="passwd" placeholder="비밀번호">
				</div><br>
				<div><input type="button" class="form-control btn btn-danger" id="btnLogin" value="로그인"></div>
				<div><br>
				<c:if test="${param.message == 'nologin' }">
				<div style="color:red; text-align: center;">
					로그인 하신 후 사용하세요.
				</div>				
			</c:if>
			<c:if test="${message == 'error' }">
				<div style="color:red; text-align: center;">
					아이디 또는 비밀번호가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${message == 'logout' }">
				<div style="color:blue; text-align: center;">
					로그아웃 처리되었습니다.
				</div>
			</c:if>
				</div>				
				</form><br>
				<div class="container-fluid" style="text-align: center;">
  	 	<div class="row">
    	<div class="col-md-4">
    		<a href="#">아이디 찾기 </a>
			</div>
			<div class="col-md-4">
			<a href="#">비밀번호 찾기 </a>
			</div>
			<div class="col-md-4">
			<a href="">회원가입</a>
			</div>
			</div>
			</div>	

			</div>
		</div>
	</div>

</div>
</body>
</html>
