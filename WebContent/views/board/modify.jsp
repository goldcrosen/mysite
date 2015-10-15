<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="/include/include-header.jspf"%>
</head>
<body>
	<div id="container">
		<jsp:include page="/views/include/header.jsp" flush="false"></jsp:include>
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="/mysite/board">
					<input type="hidden" name="boardNo" value="${list.get(0).boardNo}" />
					<input type="hidden" name="a" value="update" />
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글수정</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title"
								value="${list.get(0).title}"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td><textarea id="content" name="content">${list.get(0).content}</textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="/mysite/board">취소</a> <input type="submit" value="수정">
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="/views/include/navigation.jsp" flush="false"></jsp:include>
		<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>