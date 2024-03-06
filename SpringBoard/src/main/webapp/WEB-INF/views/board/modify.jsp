<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%-- ${boardVO } --%>
page : ${param.page }<br>
pageSize : ${param.pageSize }<br>
cri : ${cri }<br>
<h1>/board/register.jsp</h1>
<h2>수정하기</h2>
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">수정하기</h3>
	</div>
	<form role="form" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno }">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제 목</label> 
				<input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 작성하세요!" value="${boardVO.title}">
			</div>
			<div class="form-group">
				<label>이름</label> 
				<input type="text" name="writer" class="form-control" placeholder="이름을 입력하세요" value="${boardVO.writer}">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea name="content" class="form-control" rows="3" placeholder="내용을 입력하세요" >${boardVO.content}</textarea>
			</div>
		</div>
		<div class="box-footer">
			<button type="submit" class="btn btn-danger">글수정</button>
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>
