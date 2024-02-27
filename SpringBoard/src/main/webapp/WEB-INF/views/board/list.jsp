<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<div class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">Bordered Table</h3>
		</div>
		<div class="box-body">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th style="width: 10px">bno</th>
						<th>title</th>
						<th>writer</th>
						<th style="width: 40px">viewcnt</th>
						<th>regdate</th>
					</tr>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.bno}</td>
							<td><a href="/board/read?bno=${board.bno }">${board.title}</a></td>
							<td>${board.writer}</td>
							<td><span>${board.viewcnt }</span></td>
							<td>${board.regdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				<li><a href="#">«</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">»</a></li>
			</ul>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>