<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
viewUpdateStatus : ${viewUpdateStatus } <br>
cri : ${cri }
<div class="content">
	<h1>read.jsp</h1>
	<form role="form" action="" method="get" class="fm">
		<input type="hidden" name="bno" value="${boardVO.bno }">
		<!-- 페이징처리정보 -->
	   <input type="hidden" name="page" value="${cri.page }">
	   <input type="hidden" name="pageSize" value="${cri.pageSize }">
	</form>
	<div class="box">
		<div class="box box-primary">
			<div class="box-body no-padding">
				<div class="mailbox-read-info">
					<h3>${boardVO.title }</h3>
					<h5>
						작성자 : ${boardVO.writer } <span class="mailbox-read-time pull-right"><fmt:formatDate value="${boardVO.regdate }" pattern="yy.MM.dd" />&nbsp;&nbsp;&nbsp;</span> <span class="mailbox-read-time pull-right">조회수 ${boardVO.viewcnt }&nbsp;&nbsp;&nbsp;</span>
					</h5>
				</div>
				<div class="mailbox-read-message">${boardVO.content }</div>
			</div>
			<div class="box-footer">
				<div class="pull-right">
					<button type="submit" class="btn btn-success">목록이동</button>
				</div>
				<button type="button" class="btn btn-default" id="delete">
					<i class="fa fa-fw fa-trash"></i>Delete
				</button>
				<button type="button" class="btn btn-default" id="update">
					<i class="fa fa-fw fa-pencil-square-o"></i>Update
				</button>
			</div>
		</div>
	</div>
</div>
<!-- JQuery 사용 -->
<script>
	$(document).ready(function() {

		//bno를 저장하는 폼태그 정보
		//console.log($("form[role='form']"));
		var formObj = $("form[role='form']");

		$("#update").click(function() {
			alert(" 수정하기 버튼 클릭 ! ");
			formObj.attr("action", "/board/modify");
			formObj.submit();
		});
		
		$("#delete").click(function() {
			confirm(" 삭제하시겠습니까? ");
			formObj.attr("action", "/board/delete");
			formObj.submit();
		});


		$(".btn-success").click(function() {
			alert(" '목록이동' 버튼 클릭! ");
			//목록으로 이동
			location.href="/board/listCri?page=${cri.page}&pageSize=${param.pageSize}";
		});
	});
</script>
<%@ include file="../include/footer.jsp"%>