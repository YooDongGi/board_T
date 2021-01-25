<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">게시판 관리</div>
					<a class="nav-link"
						href="${pageContext.request.contextPath }/manage">게시판 관리</a>
					<div class="sb-sidenav-menu-heading">게시판 목록</div>
					<c:forEach items="${boardL }" var="board">
						<a class="nav-link collapsed"
							href="/boardList?boardno=${board.b_no }"> ${board.b_nm } </a>
					</c:forEach>
				</div>
			</div>
		</nav>
	</div>