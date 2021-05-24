<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="메모" name="title"/>
</jsp:include>

<style>
div#memo-container{width:60%; margin:0 auto;text-align:center;}
</style>
<div id="memo-container">
    <form action="${pageContext.request.contextPath}/memo/insertMemo.do" class="form-inline" method="post">
        <input type="text" class="form-control col-sm-10" name="memo" placeholder="메모" required/>&nbsp;
        <button class="btn btn-outline-success" type="submit" >저장</button>
    </form>
    <br />
    <!-- 메모목록 -->
	<table class="table">
	    <tr>
	      <th>번호</th>
	      <th>메모</th>
	      <th>날짜</th>
	      <th>삭제</th>
	    </tr>
	    <c:if test="${empty list}">
	    <tr colspan="4"> 작성된 메모가 없습니다.</tr>
	    </c:if>
	    <c:if test="${not empty list}">
		    <c:forEach var="memo" items="${list}">
			<tr>
			      <td>${memo.no}</td>
			      <td>${memo.memo}</td>
			      <td><fmt:formatDate value="${memo.regDate}" pattern="yy/MM/dd(E) HH:mm:ss"/></td>
			      <td><button type="button" class="btn btn-outline-danger" onclick="deleteMemo(${memo.no})">삭제</button></td>
			</tr>
		    </c:forEach>
	    </c:if>
	</table>
<form name ="hiddenFrm" id="hiddenFrm"
	action="${pageContext.request.contextPath}/memo/deleteMemo.do" 
	method="POST">
	<input id="hidden" type="hidden" name="no"/>
</form>
</div>
<script>

function deleteMemo(no){
	if(confirm(no+"번을 정말 삭제하시겠습니까?")){
		var $frm = $(document.hiddenFrm);
		$frm.find("[name = no]").val(no);
		$frm.submit();
		}
	
}

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
