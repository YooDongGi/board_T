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
        <title>게시판</title>
        <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/jquery.slim.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/scripts.js"></script>
        <link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" ></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" ></script>
        
        <%-- <link href="${cp }/css/bootstrap.min.css" rel="stylesheet"> --%>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="${cp }/js/bootstrap.js"></script>
		
       	<!-- <script src="assets/demo/datatables-demo.js"></script>  -->
       	<script>
       		$(function() {
       			$('.postno').on('click', function() {
       				var post_no = $(this).data("pno");
       				console.log(post_no);
       				$('#p_no').val(post_no);
       				$('#frm').submit();
       			})
       		})
       	</script>
    </head>
    <body class="sb-nav-fixed">
    	<form id="frm" action="${pageContext.request.contextPath }/boardView">
    		<input type="hidden" id="p_no" name="p_no" value="" />
    	</form>
        <%@include file="/common/header.jsp" %>
        <div id="layoutSidenav">
            <%@include file="/common/left.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">게시판</h1>
                        <div class="card mb-4">
                            <div class="card-body">
                            	공지사항
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                게시판
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
									<a class="btn btn-primary" href="/boardRegist?b_no=${page.b_no }">글쓰기</a><br><br>                                
                                    <table class="table table-bordered" id="dataTable">
                                        <thead>
                                            <tr>
                                                <th style="width:10%;">글번호</th>
                                                <th style="width:30%;">제목</th>
                                                <th>작성자</th>
                                                <th>작성일시</th>
                                                <th>조회수</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${postList }" var="post">
                                        		
                                            	<c:choose>
                                            		<c:when test="${post.p_act  == 1}">
			                                            <tr class="postno" data-pno="${post.p_no }">
			                                                <td>${post.p_no }</td>
			                                                <td>${post.title }</td>
			                                                <td>${post.userid }</td>
			                                                <td><fmt:formatDate value="${post.p_date }" pattern="yyyy-MM-dd"/> </td>
			                                                <td>${post.views }</td>
			                                            </tr>
			                                        </c:when>
			                                        <c:otherwise>
			                                        	<tr>
			                                                <td>${post.p_no }</td>
			                                                <td>[삭제된 게시글입니다]</td>
			                                                <td>${post.userid }</td>
			                                                <td><fmt:formatDate value="${post.p_date }" pattern="yyyy-MM-dd"/> </td>
			                                                <td>${post.views }</td>
			                                            </tr>
			                                        </c:otherwise>
                                            	</c:choose>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-sm-12 col-md-7">
									<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
										<ul class="pagination">
											<li class="paginate_button page-item previous disabled" id="dataTable_previous">
												<a href="#" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
											</li>
											<c:forEach begin="1" end="${pagination }" var="i">
												<c:choose>
													<c:when test="${page.page == i}">
														<li class="paginate_button page-item active">
															<span class="page-link">${i }</span>
														</li>
													</c:when>
													<c:otherwise>
														<li class="paginate_button page-item">
															<a href="${pageContext.request.contextPath }/boardList?boardno=${page.b_no }&page=${i}" aria-controls="dataTable" class="page-link">${i }</a>
														</li>		
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<li class="paginate_button page-item next" id="dataTable_previous">
												<a href="#" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">NEXT</a>
											</li>
										</ul>
									</div>
								</div>
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
