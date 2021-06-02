<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param value="Menu RestAPI" name="title"/>
</jsp:include>
<style>
div.menu-test{width:50%; margin:0 auto; text-align:center;}
div.result{width:70%; margin:0 auto;}
</style>
<script>
/*
 	SOP Same Origin Policy 동일근원정책
 	-origin : protocol + host + port   
 			  http://localhost:9090 ----> http://localhost:10000 
 	-비동기요청시 현재 페이지 origin과 동인 origin으로만 요청할 수 있게 제한함

	CORS Policy Cross Origin Resource Sharing 타 origin과 자원 공유
	-조건: 응답 header에 Access-Controll-Allow-Origin : 나의 origin이 설정되어 있을것.
	 
 Access to XMLHttpRequest(비동기요청을 처리하는 자바객체) at 'http://localhost:10000/springboot/menus' 
 from origin 'http://localhost:9090' 
 has been blocked by CORS policy: 
 No 'Access-Control-Allow-Origin' header is present on the requested resource.
 */
const menuRestOrigin = "http://localhost:10000";
const menuRestContextPath ="/springboot";
const url = menuRestOrigin + menuRestContextPath;
</script>
	<div id="menu-container" class="text-center">
	<!-- 1.GET /menus-->
       <div class="menu-test">
           <h4>전체메뉴조회(GET)</h4>
           <input type="button" class="btn btn-block btn-outline-success btn-send" id="btn-menus" value="전송" />
       </div>
       <div class="result" id="menus-result"></div>
       <script>
	$("#btn-menus").click(()=>{
		$.ajax({
				//url: `\${url}/menus`, //타 REST server로 직접요청
				url: "${pageContext.request.contextPath}/menu/selectMenuList.do",
				method: "GET",
				//객체안의 메소드만 이렇게 작성 가능
				success(data){
					console.log(data);
					displayResultTable("menus-result",data);
				},
				error: console.log
				//이렇게 한 것과 같다.error: (x,y,z) =>console.log(x,y,z)
			})
	});
       </script>
       
       <!-- 2. GET /menus?type=kr(X) 파라미터 사용은 최대한 자제
       /menus/kr  /menus/ch  /menus/jp -> 경로 변수 사용  -->
      <div class="menu-test">
		<h4>추천메뉴(GET)</h4>
		<form id="menuRecommendationFrm">
			<div class="form-check form-check-inline">
				<input type="radio" class="form-check-input" name="type" id="get-no-type" value="all" checked>
				<label for="get-no-type" class="form-check-label">모두</label>&nbsp;
				<input type="radio" class="form-check-input" name="type" id="get-kr" value="kr">
				<label for="get-kr" class="form-check-label">한식</label>&nbsp;
				<input type="radio" class="form-check-input" name="type" id="get-ch" value="ch">
				<label for="get-ch" class="form-check-label">중식</label>&nbsp;
				<input type="radio" class="form-check-input" name="type" id="get-jp" value="jp">
				<label for="get-jp" class="form-check-label">일식</label>&nbsp;
			</div>
			<br />
			<div class="form-check form-check-inline">
				<input type="radio" class="form-check-input" name="taste" id="get-no-taste" value="all" checked>
				<label for="get-no-taste" class="form-check-label">모두</label>&nbsp;
				<input type="radio" class="form-check-input" name="taste" id="get-hot" value="hot">
				<label for="get-hot" class="form-check-label">매운맛</label>&nbsp;
				<input type="radio" class="form-check-input" name="taste" id="get-mild" value="mild">
				<label for="get-mild" class="form-check-label">순한맛</label>
			</div>
			<br />
			<input type="submit" class="btn btn-block btn-outline-success btn-send" value="전송" >
		</form>
	</div>
	<div class="result" id="menuRecommendation-result"></div>
	<script>
	$("#menuRecommendationFrm").submit(e =>{
		//폼은 제출하되 이동없이 비동기 처리
		//폼제출을 방지 : return false; => 마지막 줄에 써야함 첫줄에 오면 아무것도 실행이 안됨으로
		e.preventDefault();
		
		//현제폼
		const $frm = $(e.target);
		const type = $frm.find("[name=type]:checked").val();
		const taste = $frm.find("[name=taste]:checked").val();
		console.log(type,taste);
		
		$.ajax({
			url: "${pageContext.request.contextPath}/menu/selectListType.do",
			data:{
				type,
				taste
				},
			success(data){
				console.log(data);
				displayResultTable("menuRecommendation-result",data);
			},
			error: console.log
		});

	});

	</script>
	
	   <!-- 2.POST /menu -->
		<div class="menu-test">
			<h4>메뉴 등록하기(POST)</h4>
			<form id="menuEnrollFrm">
				<input type="text" name="restaurant" placeholder="음식점" class="form-control" />
				<br />
				<input type="text" name="name" placeholder="메뉴" class="form-control" />
				<br />
				<input type="number" name="price" placeholder="가격" class="form-control" />
				<br />
				<div class="form-check form-check-inline">
					<input type="radio" class="form-check-input" name="type" id="post-kr" value="kr" checked>
					<label for="post-kr" class="form-check-label">한식</label>&nbsp;
					<input type="radio" class="form-check-input" name="type" id="post-ch" value="ch">
					<label for="post-ch" class="form-check-label">중식</label>&nbsp;
					<input type="radio" class="form-check-input" name="type" id="post-jp" value="jp">
					<label for="post-jp" class="form-check-label">일식</label>&nbsp;
				</div>
				<br />
				<div class="form-check form-check-inline">
					<input type="radio" class="form-check-input" name="taste" id="post-hot" value="hot" checked>
					<label for="post-hot" class="form-check-label">매운맛</label>&nbsp;
					<input type="radio" class="form-check-input" name="taste" id="post-mild" value="mild">
					<label for="post-mild" class="form-check-label">순한맛</label>
				</div>
				<br />
				<input type="submit" class="btn btn-block btn-outline-success btn-send" value="등록" >
			</form>
		</div>
		<script>
		/**
		  POST /menu
		  
		 
		*/
		$("#menuEnrollFrm").submit(e =>{
			e.preventDefault(); //폼제출 방지
			const $frm = $(e.target);
			const restaurant = $frm.find("[name=restaurant]").val();
			const name = $frm.find("[name=name]").val();
			const price = $frm.find("[name=price]").val();
			const type = $frm.find("[name=type]:checked").val();
			const taste = $frm.find("[name=taste]:checked").val();

			const menu ={
				restaurant:restaurant,
				name: name,
				price,
				type,
				taste
			};

			console.log(menu);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/menu/insertMenu.do",
				data: JSON.stringify(menu),
				contentType: "application/json; charset=utf-8",
				method: "POST",
				success(data){
					console.log(data);
					const {msg} = data;
					alert(msg);
				},
				error: console.log,
				complete(){
					e.target.reset(); //폼초기화
					}
				});
			
		});
		</script>
		<!-- #3.PUT /menu/123 -->
		<div class="menu-test">
			<h4>메뉴 수정하기(PUT)</h4>
			<p>메뉴번호를 사용해 해당메뉴정보를 수정함.</p>
			<form id="menuSearchFrm">
				<input type="text" name="id" placeholder="메뉴번호" class="form-control" /><br />
				<input type="submit" class="btn btn-block btn-outline-primary btn-send" value="검색" >
			</form>
			<hr />
			<form id="menuUpdateFrm">
				<input type="hidden" name="hiddenId" value=""/>
				<input type="text" name="restaurant" placeholder="음식점" class="form-control" value ="${menu.restaurant}"/>
				<br />
				<input type="text" name="name" placeholder="메뉴" class="form-control" value ="${menu.name}"/>
				<br />
				<input type="number" name="price" placeholder="가격" step="1000" class="form-control" value ="${menu.price}"/>
				<br />
				<div class="form-check form-check-inline">
					<input type="radio" class="form-check-input" name="type" id="put-kr" value="kr" ${menu.type == "kr"? "checked":""}>
					<label for="put-kr" class="form-check-label">한식</label>&nbsp;
					<input type="radio" class="form-check-input" name="type" id="put-ch" value="ch" ${menu.type == "ch"? "checked":""}>
					<label for="put-ch" class="form-check-label">중식</label>&nbsp;
					<input type="radio" class="form-check-input" name="type" id="put-jp" value="jp"${menu.type == "jp"? "checked":""}>
					<label for="put-jp" class="form-check-label">일식</label>&nbsp;
				</div>
				<br />
				<div class="form-check form-check-inline">
					<input type="radio" class="form-check-input" name="taste" id="put-hot" value="hot" ${menu.taste == "hot"? "checked":""}>
					<label for="put-hot" class="form-check-label">매운맛</label>&nbsp;
					<input type="radio" class="form-check-input" name="taste" id="put-mild" value="mild" ${menu.taste == "mild"? "checked":""}>
					<label for="put-mild" class="form-check-label">순한맛</label>
				</div>
				<br />
				<input type="submit" class="btn btn-block btn-outline-success btn-send" value="수정" >
			</form>
		</div>
		<script>
		$("#menuSearchFrm").submit(e =>{
			//폼은 제출하되 이동없이 비동기 처리
			//폼제출을 방지 : return false; => 마지막 줄에 써야함 첫줄에 오면 아무것도 실행이 안됨으로
			e.preventDefault();

			//const $frm = $("#menuSearchFrm");				

			//const id = $frm.find("[name=id]").val();
			//e.target하위의 선택자를 조회 
			const id = $("[name=id]",e.target).val();
			if(!id) return;				

			console.log(id);

			const $upFrm = $("#menuUpdateFrm");
			const $id = $upFrm.find("[name = hiddenId]");
			const $restaurant = $upFrm.find("[name = restaurant]");
			const $name = $upFrm.find("[name = name]");
			const $price = $upFrm.find("[name = price]");
			const $type = $upFrm.find("[name = type]");
			const $taste = $upFrm.find("[name = taste]");

			

			$.ajax({
				url: `${pageContext.request.contextPath}/menu/selectOneMenu/\${id}`,
				method:"GET",
				dataType: "json",
				success:function(data){
					console.log(data);

					if(data){
					
					const {id, restaurant, name, price, type, taste} = data;

					$id.val(id);
					$restaurant.val(restaurant);
					$name.val(name);
					$price.val(price);
					
					//라디오 박스의 경우
					//$("#put-" + type).prop('checked', true);
					//$("#put-" + taste).prop('checked', true);
					$upFrm.find(`[name=type][value=\${type}]`).prop("checked",true);
					$upFrm.find(`[name=taste][value=\${taste}]`).prop("checked",true);
					
					}
					//404로 리턴이 되기 때문에 else절 실행X
					/* else{
						alert("해당 메뉴가 존재하지 않습니다.");
						$("[name =id]",e.target).select();
					}  */
					
				},
				error(xhr, statusText, err){
						console.log(xhr, statusText, err);
						const {status} = xhr;
						status == 404 && alert("해당 메뉴가 존재하지 않습니다.");
						$("[name =id]",e.target).select();
					}
			});

		});

		$("#menuUpdateFrm").submit(e =>{
			
			e.preventDefault();

			const $frm = $(e.target);
			/* const id = $frm.find("[name=hiddenId]").val();
			const restaurant = $frm.find("[name=restaurant]").val();
			const name = $frm.find("[name=name]").val();
			const price = $frm.find("[name=price]").val();
			const type = $frm.find("[name=type]:checked").val();
			const taste = $frm.find("[name=taste]:checked").val(); */

			   /* const menu ={
					id : $frm.find("[name=hiddenId]").val(),
					restaurant : $frm.find("[name=restaurant]").val(),
					name : $frm.find("[name=name]").val(),
					price : $frm.find("[name=price]").val(),
					type : $frm.find("[name=type]:checked").val(),
					taste : $frm.find("[name=taste]:checked").val()
				}; */ 

				//formData(자바스크립트 객체)를 활용해서 객체만들기
				const frmData = new FormData(e.target);
				const menu = {};
				frmData.forEach((value, key) => {
					console.log(value,key);
					menu[key] = value;
				});
				console.log(menu);
				

			$.ajax({
				url:`\${url}/menus/\${menu.id}`,
				data: JSON.stringify(menu),
				contentType: "application/json; charset=utf-8",
				method: "put",
				success(data){
					console.log(data);
					const {msg} = data;
					alert(msg);
				},
				error: console.log,
				complete(){
					$("#menuSearchFrm")[0].reset();
					$("#menuUpdateFrm")[0].reset();
					//$("#menuUpdateFrm")[0].reset(); =>자바스크립트 객체의 reset매소드(reset은 jQuery매소드가 아니다)
					//$("#menuUpdateFrm")[0] == javascript 객체
					//$("#menuUpdateFrm") == jquery 객체
					//e.target.reset(); //폼초기화
					}
				});
			
		});
		</script>
			
		<!-- 4. 삭제 DELETE /menu/123 -->    
		<div class="menu-test">
	    	<h4>메뉴 삭제하기(DELETE)</h4>
	    	<p>메뉴번호를 사용해 해당메뉴정보를 삭제함.</p>
	    	<form id="menuDeleteFrm">
	    		<input type="text" name="id" placeholder="메뉴번호" class="form-control" /><br />
	    		<input type="submit" class="btn btn-block btn-outline-danger btn-send" value="삭제" >
	    	</form>
	    </div>
	    <script>
	    
	    //value자리에 함수가 온다면 메소드
	    /*
	    	name: function(){}
    		name: foo, => 존재하는 함수를 name에 연결한 것이다.
    		name(data) =>메소드 단축형

    		error: console.log => 기존 함수를 가져다가 바인딩한 것
	    */
		$("#menuDeleteFrm").submit(e =>{
			e.preventDefault();

			const id = $("[name=id]",e.target).val();
			if(!id) return;

			$.ajax({
				url: `\${url}/menus/\${id}`,
				method:"DELETE",
				success(data){
					console.log(data);
					const {msg} = data;
					alert(msg);
				},
				error(xhr, statusText, err){
					console.log(xhr, statusText, err);
					const {status} = xhr;
					switch(status){
					case 404 :alert("해당 메뉴가 존재하지 않습니다."); break;
					default: alert("메뉴 삭제 실패!");
					}
					//status == 404 && alert("해당 메뉴가 존재하지 않습니다.");
					$("[name = id]",e.target).select();
				},
				complete(){
					$(e.target)[0].reset();
				}
			});
		});

	    </script>
		
	</div>

<script>
function displayResultTable(id, data){
	const $container = $("#"+id);
	let html = "<table class='table'>";
	html += "<tr><th>번호</th><th>음식점</th><th>메뉴</th><th>가격</th><th>타입</th><th>맛</th></tr>";

	//mybatis session.selectList는 데이터가 없는 경우, 빈 list를 리턴 null/undefined(X) 무조건 배열은 있음
	if(data.length > 0){
		$(data).each((i,menu) =>{
			const {id,restaurant, name, price, type, taste} = menu;
			//`` 템플릿스트릿은 여러줄 작성 가능
											//자바스크립트 삼항 연산자
			html +=`
				<tr>
					<td>\${id}</td>
					<td>\${restaurant}</td>
					<td>\${name}</td>
					<td>\${price}</td>
					<td>\${type}</td>
					<td><span class="badge badge-\${taste == 'hot'? 'danger':'warning'}">\${taste}</span></td>
				</tr>`;
		});
	}
	else{
		html += "<tr><td colspan='6'>검색된 결과가 없습니다</td></tr>"

	}
	html +="</table>"
	//컨테이너에 html을 html로 추가
	$container.html(html);
}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>