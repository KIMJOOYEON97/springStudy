<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시판" name="title"/>
</jsp:include>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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

//onload함수
$(() =>{
	$("tr[data-no]").click(e=>{
		//화살표함수안에서 this는 e.target이 아니다.
		//console.log(e.target); // 클릭한 td태그 -> 부모tr로 이벤트전파(bubbling)
		var $tr = $(e.target).parent();
		var no = $tr.data("no");
		location.href = "${pageContext.request.contextPath}/board/boardDetail.do?no="+no;
	});
	
	    $( "#searchTitle" ).autocomplete({
	    		//source: availableTags
		    	source: function(request, response){
					console.log(request); //{term: "a"}
					console.log(response); //ƒ (){return a.apply(b||this,c.concat(d.call(arguments)))}
					//response([{label: 'a', value:'a'}],{label:'b',value:'b'})

					//사용자입력값전달 ajax요청 -> success함수안에서 response호출
					$.ajax({
						url: "${pageContext.request.contextPath}/board/autocomplete.do",
						data: {
							search :request.term
						},
						dataType: 'json',
						success: (data) =>{
							console.log(data);
							const {board} = data;
							console.log(board);
							//var arr = data.split("\n");
							  //arr = arr.slice(0, arr.length - 1)
							  //arr.splice(arr.length - 1, 1);
							  //arr = $.map(data, function(item){
							//	 return {
							//		 label: item.title, //노출텍스트
							//		 value: item.title  //내부적 처리될 값
							//	 } 
							//  });
							//  console.log(arr);
							  //콜백함수 호출
							//  response(arr);
							response($.map(board,function(item){
								return{
									label:item.title,
									value:item.no}
								}))
							},
						error:(xhr,statusText,err) => {
							console.log(xhr,statusText,err);	
						}
					})
		  		},
		  		select: function(event, selected){
			  		//클릭했을때, 해당게시글 상세페이지로 이동
			  		  console.log(event);
			  		  console.log(selected);
			  		  const {item:{value}} = selected;
			  		  console.log(value);
			  		  location.href=`${pageContext.request.contextPath}/board/boardDetail.do?no=\${value}`;
			  			
			  	},
			  	focus: function(event, focused){
				return false;
				}


		});
});
</script>
<section id="board-container" class="container">
	<input type="search" placeholder="제목 검색..." id="searchTitle" class="form-control col-sm-3 d-inline"/>
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
