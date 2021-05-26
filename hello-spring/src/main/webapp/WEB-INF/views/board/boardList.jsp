﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시판" name="title"/>
</jsp:include>
<style>
/*글쓰기버튼*/
input#btn-add{float:right; margin: 0 0 15px;}
tr[data-no]{
	cursor: pointer
}
</style>
<script>
function goBoardForm(){
	location.href = "${pageContext.request.contextPath}/board/boardForm.do";
}
$(() =>{
	$("tr[data-no]").click(e=>{
		//화살표함수안에서 this는 e.target이 아니다.
		//console.log(e.target); // 클릭한 td태그 -> 부모tr로 이벤트전파(bubbling)
		var $tr = $(e.target).parent();
		var no = $tr.data("no");
		location.href = "${pageContext.request.contextPath}/board/boardDetail.do?no="+no;
	});
});
</script>
<section id="board-container" class="container">
	<input type="button" value="글쓰기" id="btn-add" class="btn btn-outline-success" onclick="goBoardForm();"/>
	<table id="tbl-board" class="table table-striped table-hover">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th> <!-- 첨부파일 있을 경우, /resources/images/file.png 표시 width: 16px-->
			<th>조회수</th>
		</tr>
		<c:if test="${empty list}">
	    <tr colspan="6"> 작성된 게시물이 없습니다.</tr>
	    </c:if>
	    <c:if test="${not empty list}">
		    <c:forEach var="board" items="${list}">
			<tr data-no="${board.no}">
			    <td>${board.no}</td>
			    <td>${board.title}</td>
			    <td>${board.memberId}</td>
			    <td><fmt:formatDate value="${board.regDate}" pattern="yy/MM/dd(E) HH:mm:ss"/></td>
				<td>
			    <c:if test="${board.hasAttachment}">
			    	<img src="${pageContext.request.contextPath}/resources/images/file.png" width ="16px" alt="" />
				</td>			    
			    </c:if>
			    <td>${board.readCount}</td>
			</tr>
		    </c:forEach>
	    </c:if>
	</table>
	${pageBar}
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
