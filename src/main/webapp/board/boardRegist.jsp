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
        <title>게시글 1등록</title>
        <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/scripts.js"></script>
		<!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> -->
		<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
		<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js" defer></script>
		<script>
			$(function() {
				$('#summernote').summernote();	
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
                        <h1 class="mt-4">게시글 작성</h1><br><br>
                        <div class="card mb-4" style="height: 100vh">
                            <div class="card-body mb-7">
                            	<form action="${pageContext.request.contextPath }/boardRegist" method="post">
                            		<input type="hidden" name="userid" value="${S_USER.userid }">
                            		<input type="hidden" name="b_no" value="${param.b_no }">
	                            	<br><br>
	                            	<label class="col-sm-2 control-label">제목</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="title" name="title" placeholder="제목">
									</div>
	                            	<hr><br>
	                            	<div class="col-sm-8">
	                            		첨부파일
									</div><br><br>
	                            	<label class="col-sm-2 control-label">내용</label>
	                            	<div class="col-sm-8">
										<textarea class="form-control" id="summernote" name="content" placeholder="내용" cols="500" rows="12"></textarea>
	                        			<br><br>
	                        			<input class="btn btn-primary" type="submit" value="저장">
									</div>
								</form>
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