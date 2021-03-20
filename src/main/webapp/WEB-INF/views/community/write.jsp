<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head> 

<link
   href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
   rel="stylesheet" id="bootstrap-css">
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
   src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   
<meta charset="UTF-8">
<title>insert here</title>

   <!-- 게시글 제목없으면 작성안되게 유효성검사 -->
<script language="javascript">
	function validate() {
		
		var title = document.getElementById("post_title");
		var content = document.getElementById("post_content");
		
		if (title.value == "") { //제목를 기입하지 않은 경우
			alert("제목을 입력해 주세요");
			title.focus();
			title.value = "";
			return false;
		}
		
		if (content.value == "") { //제목를 기입하지 않은 경우
			alert("내용을 입력해 주세요");
			content.focus();
			content.value = "";
			return false;
		}
	}


</script>

</head>

<body>
<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지 등록</h6>
				<c:if test="${member == null }"> 
					<div align="right"> <button type = button class="btn btn-success" onclick = "location.href='/user/login'">로그인</button></div> 
				</c:if>
	
				<c:if test="${member != null }">
				<div align="right"> <button type = button class="btn btn-danger" onclick = "location.href='/logout'">로그아웃</button></div>
				
				</c:if>
	</div>
   
    <form action=/community/write method="post" onsubmit = "return validate();" enctype="multipart/form-data">
        <div class="form-group">
              <label for="exampleFormControlInput1">글제목</label>
            <input type="text" class="form-control" id="post_title" name="post_title" placeholder="제목을 작성해주세요.">
            
          </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="user_id" name="user_id" value="${user_id}" readonly="readonly">
          </div>
          <div class="form-group">
            <label for="exampleFormControlTextarea1">글내용</label>
            <textarea class="form-control" id="post_content" name="post_content" rows="10"  ></textarea>
            	
          </div>
        
        <div class="file-group">
            <input type="file" name="uploadFile">
        </div>
            <br>&nbsp;<button type="submit" class="btn btn-info">등록하기</button>
    </form>
    
    </div>
<input type="button" value = "게시글리스트" class="btn btn-success" style="float:right;" 
      onclick="location.href='/community/list'"/>
    



</body>
</html>