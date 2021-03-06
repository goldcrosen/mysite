<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
<div id="header">
	<h1>MySite</h1>
	<ul>
		<c:choose>
			<c:when test='${empty authUser }'>
				<li><a href="/mysite/member?a=loginform">로그인</a><li>
				<li><a href="/mysite/member?a=joinform">회원가입</a><li>
			</c:when>
			<c:otherwise>
				<li><a href="updateMember">회원정보수정</a><li>
				<li><a href="/mysite/member?a=logout">로그아웃</a><li>
				<li>${authUser.name}님 환영합니다.</li>
			</c:otherwise>	
		</c:choose>	
	</ul>
</div>