<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="/include/include-header.jspf"%>
</head>
<body>
	<div id="container">
		<c:import url="/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${list}" var="vo">
						<tr>
							<td>${vo.boardNo}</td>
							<td><a href="/mysite/board?a=view&boardNo=${vo.boardNo}">${vo.title}</a></td>
							<td>${vo.memberName}</td>
							<td>${vo.viewCnt}</td>
							<td>${vo.regDate}</td>
							<c:if test="${not empty authUser  && authUser.no == vo.memberNo}">
								<td><a href="/mysite/board?a=delete&boardNo=${vo.boardNo}"
									class="del">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div class="bottom">
					<c:if test='${not empty authUser}'>
						<a href="/mysite/board?a=writeForm&memberNo=${authUser.no}"
							id="new-book">글쓰기</a>
					</c:if>
				</div>
			</div>
		</div>
		<c:import url="/views/include/navigation.jsp"></c:import>
		<c:import url="/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>