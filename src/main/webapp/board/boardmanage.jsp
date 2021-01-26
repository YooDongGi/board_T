<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>게시판 관리</title>
        <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/scripts.js"></script>
        <script>
        	$(function() {
        		
        		$(".updateBtn").on('click',function() {
        		})
        		
        	})	
        </script>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="/common/header.jsp" %>
        <div id="layoutSidenav">
            <%@include file="/common/left.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">게시판 관리</h1><br><br>
                        <div class="card mb-4">
                            <div class="card-body">
                            	<h3>게시판 추가</h3><br>
                            	<form action="${pageContext.request.contextPath }/boardAdd" method="post">
	                            	게시판 이름 : <input type="text" name="boardnm">
	                            	<input type="submit" class="addBtn" value="추가">
	                            </form>
                            	<hr><br>
                            	<h3>게시판 설정</h3><br>
	                           	<ol>
	                            	<c:forEach items="${boardList }" var="board" varStatus="loop">
		                            		<li>
	                            				<form action="${pageContext.request.contextPath }/manage" method="post">
	                            					<input type="hidden" name="b_nm" value="${board.b_nm }">
				                            		${board.b_nm }
				                            		<select name="act">
				                            			<c:choose>
				                            				<c:when test="${board.b_act == 1 }">
					                            				<option value="1" selected>활성화</option>
					                            				<option value="0">비활성화</option>
				                            				</c:when>
				                            				<c:otherwise>
				                            					<option value="1">활성화</option>
					                            				<option value="0" selected>비활성화</option>
				                            				</c:otherwise>
				                            			</c:choose>
				                            		</select>
				                            		<input type="submit" class="updateBtn" value="변경">
				                            		<br><br>
	                            				</form>
		                            		</li>
	                            	</c:forEach>
	                           	</ol>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
       
    </body>
</html>