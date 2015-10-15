<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="/include/include-guestBook-header.jspf"%>
</head>
<body>
	<div id="container">
		<jsp:include page="/views/include/header.jsp" flush="false"></jsp:include>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="/mysite/guest">
					<input type="hidden" name="a" value="delete"> <input
						type='hidden' name="no" value="${param.no}"> <label>비밀번호</label>
					<input type="password" name="password"> <input
						type="submit" value="확인">
				</form>
				<a href="/mysite/guest">방명록 리스트</a>
			</div>
		</div>
		<jsp:include page="/views/include/navigation.jsp" flush="false"></jsp:include>
		<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>