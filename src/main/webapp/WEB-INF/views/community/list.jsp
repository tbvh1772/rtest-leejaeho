<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<style>
.right-button {
	float: right;
	display: block;
}

.align-center {
	text-align: center;
}
</style>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<head>

<meta charset="UTF-8">
<title>list here</title>

</head>

<body>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지</h6>
				<c:if test="${member == null }"> 
					<div align="right"> <button type = button class="btn btn-success" onclick = "location.href='/user/login'">로그인</button></div> 
				</c:if>
	
				<c:if test="${member != null }">
				<div align="right"> <button type = button class="btn btn-danger" onclick = "location.href='/logout'">로그아웃</button></div>
				
				</c:if>
	</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					width="100%" cellspacing="0">

					<thead style="text-align: center">
						<!-- 1.목록이름 -->
						<tr>
							<th>글제목</th>
							<th>글내용</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<!-- 테이블내용 -->
					<c:forEach items="${list }" var="list">
						<tr style="text-align: center; width: 100%;">
							<td  style="width: 25%; font-size: 1.2em">
							<a href="/community/view?post_no=${list.post_no }">
							<c:out value="${list.post_title }" /></td></a>
							<td style="width: 30%"><c:out value="${list.post_content }" /></td>
							<td style="width: 15%"><c:out value="${list.user_id }" /></td>
							<td style="width: 15%"><fmt:formatDate
									pattern="yyyy-MM-dd HH:mm" value="${list.post_date }" /></td>
							<td style="width: 15%"><fmt:formatDate
									pattern="yyyy-MM-dd HH:mm" value="${list.post_updatedate}" /></td>
						</tr>
					</c:forEach>
				</table>

				<c:if test="${member != null }">
					<button type = "button" class="btn btn-info btn-md" onclick = "location.href='/community/write'" style="float:right;">글쓰기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				
				<button type = "button" class="btn btn-info btn-md" onclick = "location.href='/'" style="float:right;">홈</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<!-- 3.페이징처리 -->
				<!-- 이전 -->

				
					<c:if test="${pageMaker.prev }">
						<a href="/community/list?pageNum=${pageMaker.startPage -1}&amount=${pageMaker.cri.amount}">Previous</a>
					</c:if>

					<!-- 번호 -->
					
					<c:forEach var="num" begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }">
						<c:if test="${pageMaker.cri.pageNum == num }">
						${num }
						</c:if>
						<c:if test="${pageMaker.cri.pageNum != num }">
						<a href="/community/list?pageNum=${num }&amount=${pageMaker.cri.amount}">
							${num }</a>
							</c:if>

					</c:forEach>

					<!-- 다음 -->
					<c:if test="${pageMaker.next }">

						<a
							href="/community/list?pageNum=${pageMaker.endPage+1 }&amount=${pageMaker.cri.amount}">Next</a>

					</c:if>
				


			</div>
		</div>
	</div>


	<!-- /.container-fluid -->


	<!-- End of Main Content -->

</body>
</html>








