<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jsp"%>
<div class="content">
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
				<button type="button" class="btn btn-default">
					<i class="fa fa-trash-o"></i> Delete
				</button>
				<button type="button" class="btn btn-default">
					<i class="fa fa-print"></i> Update
				</button>
			</div>
		</div>
	</div>
</div>
<!-- JQuery 사용 -->

<script>
	$(document).ready(function() {
		$(".btn-success").click(function() {
			alert(" '목록이동' 버튼 클릭! ");
			//목록으로 이동
			location.href="/board/list";
		});
	});
</script>
<%@ include file="../include/footer.jsp"%>