<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="/include/include-user-header.jspf"%>
</head>
<body>
	<div id="container">
		<jsp:include page="/views/include/header.jsp" flush="false"></jsp:include>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post"
					action="/mysite/member?a=login">
					<input type="hidden" name="a" value="login" /> <label
						class="block-label" for="email">이메일</label> <input id="email"
						name="email" type="text" value=""> <label
						class="block-label">패스워드</label> <input name="password"
						type="password" value="" />

					<c:if test='${param.result == "error"}'>
						<p>로그인이 실패 했습니다.</p>
					</c:if>
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<jsp:include page="/views/include/navigation.jsp" flush="false"></jsp:include>
		<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>