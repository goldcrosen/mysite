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
			<div id="guestbook">
				<form action="/mysite/guest" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<c:choose>
								<c:when test='${authUser != null}'>
									<td><input type="text" value="${authUser.name}" name="name" readonly/></td>
								</c:when>	
								<c:otherwise>
									<td><input type="text" value="" name="name"/></td>
								</c:otherwise>
							</c:choose>	
							<td>비밀번호</td>
							<td><input type="password" name="password"/></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<br>
				<c:forEach items='${list}' var='vo'>
					<table width="500px" border="1" cellspacing="0" cellpadding="5px" style="text-align: center;">
						<tr>
							<td>${vo.no}</td>
							<td>${vo.name}</td>
							<td>${vo.date}</td>
							<td><a href="/mysite/guest?a=deleteForm&no=${vo.no}">삭제</a></td>
						</tr>
						<tr>
							<td colspan=4>${vo.message}</td>
						</tr>
					</table>
				</c:forEach>
			</div>
		</div>
		<jsp:include page="/views/include/navigation.jsp" flush="false"></jsp:include>
		<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>