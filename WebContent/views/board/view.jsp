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
			<div id="board" class="board-form">
				<form id="updateForm" method="post" action="/mysite/board">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글보기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td>${list.get(0).title}</td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<div class="view-content">${list.get(0).content}</div>
							</td>
						</tr>
					</table>
					<input type="hidden" name="title" value="${list.get(0).title}" />
					<input type="hidden" name="content" value="${list.get(0).content}" />
					<input type="hidden" name="boardNo" value="${list.get(0).boardNo}" />
					<input type="hidden" name="a" value="updateForm" />

					<div class="bottom">
						<a href="/mysite/board">글목록</a>
						<c:if
							test='${not empty authUser && authUser.no == list.get(0).memberNo}'>
							<input type="submit" value="글수정">
						</c:if>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/views/include/navigation.jsp" flush="false"></jsp:include>
	<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>