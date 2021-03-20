<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지 조회</h6>
				<c:if test="${member == null }"> 
					<div align="right"> <button type = button class="btn btn-success" onclick = "location.href='/user/login'">로그인</button></div> 
				</c:if>
	
				<c:if test="${member != null }">
					<div align="right"> <button type = button class="btn btn-danger" onclick = "location.href='/logout'">로그아웃</button></div>
				
				</c:if>
	</div>
          
  <div class="mb-3">
  	<label for="user_id" class="form-label"><b>작성자</b></label>
    <input type="text" readonly="readonly" class="form-control" name="user_id" value="${view.user_id }">
  </div>
  
  <div class="mb-3">
  	<label for="post_title" class="form-label"><b>제목</b></label>
  	<input type="text" class="form-control" name="post_title" value = "${view.post_title }"readonly="readonly">
  </div>
   
  <div class="mb-3">
  	<label for="post_contact" class="form-label"><b>내용</b></label>
  	<textarea class="form-control" readonly="readonly" name="post_content" rows="5">${view.post_content }</textarea>
  </div>
   
  <div class="mb-3">
   	<label for="post_date" class="form-label"><b>작성일</b></label>
  	<fmt:formatDate	pattern="yyyy-MM-dd HH:mm" value="${view.post_date }"/>
  	
  </div>
   
  <div>
   	<label for="post_updatedate" class="form-label"><b>수정일</b></label>
  	<fmt:formatDate	pattern="yyyy-MM-dd HH:mm" value="${view.post_updatedate }" />
  </div>
        
  </div>
        <c:if test="${sessionScope.userId eq view.user_id }">
      <input type = "button" value = "수정" class = "btn btn-success" 
      onclick="location.href='/community/update?post_no=${view.post_no}'"/>
      

      <input type="button" value = "삭제" id = "del"class="btn btn-danger" 
      onclick="location.href='/community/delete?post_no=${view.post_no}'"/>
      
      </c:if>
			
      
      

      <input type="button" value = "게시글리스트" class="btn btn-success" style="float:right;" 
      onclick="location.href='/community/list'"/>
      
      <script>
      $("#del").click(function(){
       alert("삭제되었습니다.")
      });
      </script>
      
</body>
</html>
