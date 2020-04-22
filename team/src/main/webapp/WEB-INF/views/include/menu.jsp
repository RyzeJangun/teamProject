<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- views/include/menu.jsp -->
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>

<a href="${path}">Home</a> |
<a href="${path}/member/join_route.do">회원가입</a> |
<a href="${path}/fund_info/user_fund_route.do">투자정보</a> |
<a href="${path}/reward_info/reward_infoList.do">리워드 정보</a> |
<a href="${path}/reward_info/user_reward.do">내가 투자한 리워드 정보</a> |
<c:if test="${sessionScope.admin_userid != null}">
	<a href="${path}/member/memberList_route.do">회원정보목록</a> | 
</c:if>
 
<c:if test="${sessionScope.userid != null}">
	<a href="${path}/member/userInfo.do">내정보</a> | 
</c:if>


<div style="text-align:right;">
	<c:choose>
		<c:when test="${sessionScope.userid == null }">
			<!-- 로그인하지 않은 상태 -->
			<a href="${path}/member/login_route.do">로그인</a> |
			<a href="${path}/admin/login.do">관리자 로그인</a> 
		</c:when>
		<c:otherwise>
			<!-- 로그인한 상태 -->
			${sessionScope.userid}님이 로그인중입니다.
			<a href="${path}/member/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>

<hr>  
    