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
        <style>
        	.comm td{
        		padding : 15px;
        	} 
        	
        </style>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="/common/header.jsp" %>
        <div id="layoutSidenav">
            <%@include file="/common/left.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">게시글</h1><br><br>
                        <c:if test="${post.userid == S_USER.userid }">
	                        <a class="btn btn-primary" href="/boardModify?p_no=${post.p_no }">수정</a>
	                        <a class="btn btn-primary" href="/boardDelete?p_no=${post.p_no }&b_no=${post.b_no }">삭제</a>
                        </c:if>
                        <a class="btn btn-primary" href="#">답글</a>
                        <br><br>
                        <div class="card mb-4" style="height: 100vh">
                            <div class="card-body mb-7">
                            	<br><br>
                            	<h4>${post.title }</h4>
                            	<p align="right">글쓴이 : ${post.userid } / 작성일 : <fmt:formatDate value="${post.p_date }" pattern="yy-MM-dd"/>  / 조회 수 : ${post.views }</p>
                            	<hr><br>
                            	<h3>${post.content }</h3><br><br>
                            </div>
                            <div class="card-body mb-6">
                            	<hr>
                            	<form action="${pageContext.request.contextPath }/commentAD" method="post">
                            		<input type="hidden" name="userid" value="${S_USER.userid }">
                            		<input type="hidden" name="p_no" value="${post.p_no }">
		                        	<textarea name="c_con" placeholder="댓글입력" rows="6" cols="100"></textarea>
			                    	<input class="btn btn-primary" type="submit" value="댓글등록">
		                    	</form>
		                    	<br><br><br>
		                    	<h5>댓글 목록</h5>
		                    	<br>
		                    	<table class="comm">
		                    		<tr>
		                    			<td style="min-width: 500px;"> 댓글 내용</td>
		                    			<td style="min-width: 200px;">작성자</td>
		                    			<td style="min-width: 200px;">작성날짜</td>
		                    			<td></td>
		                    		</tr>
			                    	<c:forEach items="${commentList }" var="comment">
			                    		<tr>
			                    			<c:choose>
												<c:when test="${comment.c_act == 1}">
			                    					<td>${comment.c_con }</td>
					                    			<td>${comment.userid }</td>
					                    			<td><fmt:formatDate value="${comment.c_date }" pattern="yy-MM-dd"/></td>
					                    			<td><c:if test="${comment.userid == S_USER.userid }">
					                    				<a href="${pageContext.request.contextPath }/commentAD?p_no=${post.p_no }&c_no=${comment.c_no}"> x </a></c:if></td>
												</c:when>
												<c:otherwise>
													<td>[삭제된 댓글입니다]</td>
													<td>${comment.userid }</td>
					                    			<td><fmt:formatDate value="${comment.c_date }" pattern="yy-MM-dd"/></td>
					                    			<td></td>
												</c:otherwise>			                  			
			                    			</c:choose>
			                    		</tr>
			                    	</c:forEach>
		                    	</table>
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