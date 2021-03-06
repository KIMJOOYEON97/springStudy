<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.spring.member.model.vo.Member, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String[] hobby = ((Member) request.getAttribute("loginMember")).getHobby();
//hobby가 null일 경우 nullpointexception을 방지하기 위해서
	List<String> hobbyList =  hobby != null? 
									Arrays.asList(hobby): null;
	pageContext.setAttribute("hobbyList", hobbyList);

%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원정보" name="title"/>
</jsp:include>
<style>
div#update-container{width:400px; margin:0 auto; text-align:center;}
div#update-container input, div#update-container select {margin-bottom:10px;}
</style>
${time}
<div id="update-container">
	<form name="memberUpdateFrm" action="${pageContext.request.contextPath}/member/memberUpdate.do" method="post">
		<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="id" id="id" readonly required value="${loginMember.id}"/>
		<input type="text" class="form-control" placeholder="이름" name="name" id="name" required value="${loginMember.name}"/>
		<input type="date" class="form-control" placeholder="생일" name="birthday" id="birthday" value="${loginMember.birthday}"/>
		<input type="email" class="form-control" placeholder="이메일" name="email" id="email" required value="${loginMember.email}"/>
		<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required value="${loginMember.phone}"/>
		<input type="text" class="form-control" placeholder="주소" name="address" id="address" value="${loginMember.address}"/>
		<select class="form-control" name="gender" required>
		  <option value="" disabled selected>성별</option>
		  <option value="M" ${loginMember.gender eq 'M'? "selected":"" }>남</option>
		  <option value="F" ${loginMember.gender =="F"? "selected":"" }>여</option>
		</select>
		<div class="form-check-inline form-check">
			취미 : &nbsp; 
			<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동" ${hobbyList.contains("운동")? "checked":""}>
			<label for="hobby0" class="form-check-label" >운동</label>&nbsp;
			<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산" ${hobbyList.contains("등산")? "checked":""}>
			<label for="hobby1" class="form-check-label" >등산</label>&nbsp;
			<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서" ${hobbyList.contains("독서")? "checked":""}>
			<label for="hobby2" class="form-check-label" >독서</label>&nbsp;
			<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임" ${hobbyList.contains("게임")? "checked":""}>
			<label for="hobby3" class="form-check-label" >게임</label>&nbsp;
			<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행" ${hobbyList.contains("여행")? "checked":""}>
			<label for="hobby4" class="form-check-label" >여행</label>&nbsp;
		</div>
		<br />
		<input type="submit" class="btn btn-outline-success" value="수정" >&nbsp;
		<input type="reset" class="btn btn-outline-success" value="취소" onclick="updateCancel()">
	</form>
</div>
<script>
$(document.memberUpdateFrm).submit((e) => {

	// 이름은 한글 2글자 이상이어야 한다.
	var $name = $("#name");


 	if(!/^[가-힣]{2,}$/.test($name.val())){
		alert("올바른 한글이름 2글자 이상 입력하세요.")
		e.preventDefault();
	} 
	
	
});

function updateCancel(){

	location.href=`${pageContext.request.contextPath}/member/updateCancel.do`;
	
}

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
