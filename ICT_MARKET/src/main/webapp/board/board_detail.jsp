<%--@ page import="kr.co.ict.BoardVO"--%>
<%--@ page import="kr.co.ict.BoardDAO"--%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&
family=Hahmlet:wght@200&family=Play:wght@400;700&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<style>
	html, body{height:100%}
	#wrapper{
		height: auto;
		min-height: 100%;
		padding-bottom: 157px;
	}
	body{
	transition :0.5s;
	}

#head{
font-family: 'Play', sans-serif;
font-size: 90%;
}

#profile{
position: relative;
}

.sidenav{
	width:100px;
	border-radius: 5px;
	position: absolute;
	z-index:0; 
	background: #dcdcdc;
	overflow-y: hidden;
	margin-top: 22px;
	margin-left: -20px;
	height: 0;
	transition :0.5s;
}
.sidenav a{
	
	color: #212529;
	text-decoration: none;
	font-size: px;
	font-family: 'Play', sans-serif;
	display: block;
	padding: 8px 8px 8px 5px;
	margin-top: 7px; 
	
	transition :0.3s;
}
.sidenav a:hover{
	color: #f1f1f1;
}

	@import url('https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Hahmlet:wght@200&family=Play:wght@400;700&display=swap');
	
	
	.tab_menu{
	position:relative;
	margin-top: -50px;
	margin-left: -20px;
	}
  	
  	.tab_menu .list{float:right;}
  	
  	.tab_menu .list li{float:left; margin-right:14px;}
  	
  	.tab_menu .list li.is_on .btn{font-weight:bold; color:blue;}
  	
  	.tab_menu .list .btn{font-size:13px;}
  	
  	.tab_menu .cont_area .cont{
  	position:absolute; 
  	top:25px; left:0; 
  	background:#555; 
  	color:#fff; 
  	text-align:center; 
  	width:250px; 
  	height:100px; 
  	line-height:100px;}
	
	.tab_menu a:hover{
	color: #f1f1f1;
	}
	
	#mainboard {
	font-family: 'Play', sans-serif;
	}
	#mainboard .row{
	margin-top: 50px;
	
	}
	#mainboard .row>.col-md-12{
	margin-right:14px;
	padding-bottom: 15px;
	}
	#mainboard .row .col-md-11{
	font-weight: 700;
	font-size:30px;
	}
	#mainboard .row #read{
	text-align:right;
	padding-right: 5px;
	}
	#mainboard .row #writer{
	font-size: 2vmin;
	text-align:right;
	}
	#mainboard .row #no{
	font-size: 2vmin;
	margin: 0 auto;
	}
	#mainboard .row #read{
	font-size: 2vmin;
	margin: 0 auto;
	
	}
	
	#mainboard #productamount {
	max-width: 35%;
	min-width:35%;
  	height: auto;
  	display: block;
	font-weight: 700;
	margin-top: -5px;
	margin-bottom: -30px;
	}
	#mainboard #contents {
	align:left;
	width:100%;
	position: relative;
	}
	
	
	#fav{
	max-width: 25%;
	float:right;
	margin-top:-75px;
	}
	#fav a:hover{
	color: #f1f1f1;
	}
	
	#navgate{
	display: flex;
	justify-content:center;
	margin-top:-15px;
	max-width: 93%;
  	font-size: 2vmin;
	}
	#navgate .btn:hover{
	color: #f1f1f1;
	}
	#navgate #list{
	float: left;
	margin-left:0px;
	}
	
	#navgate #post{
	float: left;
	}
	
	#contents #picked input[type="submit"]{
	display: none;
	}
	#pickeddiv{
	width:auto;
	margin-top: 5px;
	float: right;
	align-content: center;
	}
	#pickeddiv:hover{
	color: #f1f1f1;
	}
	
	#navgate #edit{
    white-space: nowrap;
	float: left;
	}
	
	#navgate #del{
    white-space: nowrap;
	float: left;
	}
	
	#comment:hover{
	color: #f1f1f1;
	}
	
	footer{
	font-size: 40%;
	height: 150px;
	position: relative;
  	bottom: 0px;
	display: flex;
	}	
	
	footer div{
	font-family: 'Play', sans-serif;
	margin-top: 5px;
	margin-left: 90px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
<!-- 세션에 아이디가 존재하지 않을 때 헤더 -->
<c:if test="${sessionScope.session_id eq null }">
<header id="head" class="p-3 border-bottom bg-white sticky-top">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="http://localhost:8181/ICT_MARKET/main.com" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
				<h2 style="margin:0; font-family: 'Play', sans-serif; font-weight: 700;">ICT MARKET</h2>
			</a>
			
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>
	
			<div>
				<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
	           
					<form name="searchHeader" action="http://localhost:8181/ICT_MARKET/board/Board_search.jsp" method="get" 
				class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control" name="search_keyword" placeholder="Search" aria-label="Search">
				</form>
	
					<li><a href="http://localhost:8181/ICT_MARKET/userLogin.com" class="nav-link px-2 link-dark fw-bold">Login</a></li>
					<li><a href="http://localhost:8181/ICT_MARKET/userJoin.com" class="nav-link px-2 link-dark fw-bold">Sign-up</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>
</c:if>

<!-- 세션에 아이디가 존재할 때 헤더 -->
<c:if test="${sessionScope.session_id ne null }">
<header id="head" class="p-3 border-bottom bg-white sticky-top">
<div class="container">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		<a href="http://localhost:8181/ICT_MARKET/main" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
			<h2 style="margin:0; font-family: 'Play', sans-serif; font-weight: 700;">ICT MARKET</h2>
		</a>
		
		<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>

		<div>
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
           
				<form name="searchHeader" action="http://localhost:8181/ICT_MARKET/board/Board_search.jsp" method="get" 
				class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control" name="search_keyword" placeholder="Search" aria-label="Search">
				</form>
               
				<li>
					<a href="http://localhost:8181/ICT_MARKET/boardList.com?board_info=ALL" class="nav-link px-2 link-dark fw-bold">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-sidebar-reverse" viewBox="0 0 16 16">
							<path d="M12.5 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm0 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm.5 3.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
							<path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2zM4 1v14H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm1 0h9a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5V1z"/>
						</svg>
					</a>
				</li>
               
				<li>
					<a href="http://localhost:8181/ICT_MARKET/boardInsertForm.com" class="nav-link px-2 link-dark fw-bold">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
							<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
							<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
						</svg>
					</a>
				</li>
				<li>
					<a href="#" class="nav-link px-2 link-dark fw-bold heart">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
							<path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
						</svg>
					</a>
				</li>
				<li><a href="http://localhost:8181/ICT_MARKET/userInfo.com" class="nav-link px-2 link-dark fw-bold">${sessionScope.session_id}</a></li>
				<li id="defaultNav" class="dNav">
					<a href="#" id="profile" style="padding: 15px" onclick="openNav()"> 
					<img src="https://yt3.ggpht.com/ytc/AKedOLTi6w4E6985-QdVBbovBSsnCeTETyj0WomjM5IY8Q=s88-c-k-c0x00ffffff-no-rj" alt="mdo" width="32" height="32" class="rounded-circle"/>
					</a>
					<div id="mySidenav" class="sidenav">
					<a href="http://localhost:8181/ICT_MARKET/userInfo.com" class="text-center">Profile</a>
					<a href="/ICT_MARKET/boardInsertForm" class="text-center">Sell</a>
					<a href="http://localhost:8181/ICT_MARKET/userLogout.com" class="text-center">Logout</a>
            	</div>
				</li>
			</ul>
		</div>
	</div>
</div>
</header>
</c:if>

<script>

	function openNav(){
		document.getElementById("mySidenav").style.height="150px";
		document.getElementById("main").style.filter="blur(3px)";
		
	}
	function closeNav(){
		document.getElementById("mySidenav").style.height="0px";
		document.getElementById("main").style.filter="blur(0)";
	}

	<!--search script-->
	function press(f){ 
		if(f.keyCode == 13){ 
		searchHeader.submit(); 
		} 
	} 
	 const tabList = document.querySelectorAll('.tab_menu .list li');
	  const contents = document.querySelectorAll('.tab_menu .cont_area .cont')
	  let activeCont = '';

	  for(var i = 0; i < tabList.length; i++){
	    tabList[i].querySelector('.btn').addEventListener('click', function(e){
	      e.preventDefault();
	      for(var j = 0; j < tabList.length; j++){
	       
	        tabList[j].classList.remove('is_on');

	       
	        contents[j].style.display = 'none';
	      }

	      this.parentNode.classList.add('is_on');

	      activeCont = this.getAttribute('href');
	      document.querySelector(activeCont).style.display = 'block';
	    });
	  }
	  
	
</script>
<div id= "mainboard" class="container" onclick="closeNav()">
<div class="row">
<h3 class="col-md-11">${info}${boarddetail.board_title}</h3>
<h6 class="col-md-12">Trade </h6>

<p id="no" class="col-2">No.${boarddetail.board_num}</p>
<p id="writer" class="col-9" style="font-size:80%; float:left;">${boarddetail.user_id}님이 ${boarddetail.board_writetime}에 작성하신 게시글입니다.</p>
<p id="read" class="col-1">${boarddetail.board_hit},read</p>
<hr/>
</div>

<div id="productamount" class="row">
<!-- notate unit of bills (below)-->
<!--<h4 class="col-10">Price: ₩<fmt:formatNumber value="${boarddetail.board_amount}" pattern="#,###"/></h4> -->
<table class="table table-dark table-hover" style="margin-left:14px; font-size: 2vmin;">
<c:if test="${boarddetail.board_info}">
<tr>
	<th>Status</th>
	<c:if test="${boarddetail.board_sold}">
    <td style="text-align:right;">Soldout</td></c:if>
    <c:if test="${!boarddetail.board_sold}">
    <td style="text-align:right;">Sold</td></c:if>
</tr>
<tr>
	<th>Price</th>
    <td style="text-align:right;">₩ <fmt:formatNumber value="${boarddetail.board_amount}" pattern="#,###"/></td>
</tr>
</c:if>
<tr>
	<th>Cartegory</th>
    <td style="text-align:right;">${boarddetail.board_category}</td>
</tr>
</table>
<!--<c:if test="${not empty sessionScope.session_id},${sessionScope.session_id eq boarddetail.user_id}">-->
<form id="picked" action="http://localhost:8181/ICT_MARKET/Picked" method="post">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<label>
<input type="submit"/>
    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
	<path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z">
      </svg>
</label>
</form>
<h6>sad</h6>
</div>
<!--</c:if>-->
</div>
<div id="contents" class="row">
<img src="" style="float:left;"/>
<p class="text-left">${boarddetail.board_content}</p>
</div>
<hr/>
<div id="navgate" class="container">

<form id="list" class="col-11">
    <a href="http://localhost:8181/ICT_MARKET/boardList?board_info=ALL">
        <input type="button" class="btn" value="List">
    </a>
</form>

<c:if test="${not empty sessionScope.session_id}">
<form id="post" action="http://localhost:8181/ICT_MARKET/boardInsertForm.com" method="post">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<input type="submit" type="button" class="btn" value="Post Thread">
</form>
</c:if>

<c:if test="${sessionScope.session_id eq boarddetail.user_id}">
<form id="edit" action="http://localhost:8181/ICT_MARKET/boardUpdateForm.com" method="post">
<input type="hidden" value="${boarddetail.user_id}" name="user_id">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<input type="submit" type="button" class="btn" value="Edit" id="comment">
</form>
<form id="del" action="http://localhost:8181/ICT_MARKET/boardDelete.com" method="post">
<input type="hidden" value="${boarddetail.user_id}" name="user_id">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<input type="submit" type="button" class="btn" value="Delete" id="comment">
</form>
</c:if>
</div>
<br/>

<!-- comment -->
<div class="comment">
	<table class="table table-hover" style="font-size:80%">
		<tr>
			<th class="col-md-1">comments</th>
			<th class="col-md-8"></th>
			<th colspan=3></th>
	</tr>
		<c:forEach items="${comment}" var="comment">
		<tr>
			<td class="align-middle">${comment.comment_id }</td>
			<td class="align-middle">${comment.comment_content }</td>
			<td class="align-middle">${comment.comment_updatetime }</td>
			<td>
				<c:if test="${sessionScope.session_id eq comment.comment_id}">
					<form action="http://localhost:8181/ICT_MARKET/CommentUpdateForm" method="post">
						<input type="hidden" name="comment_num" value="${comment.comment_num }">
						<input class="btn btn-sm" type="submit" value="Edit">
					</form>
				</c:if>
			</td>
			<td>
				<c:if test="${sessionScope.session_id eq comment.comment_id}">			
					<form action="http://localhost:8181/ICT_MARKET/CommentDelete" method="post">
						<input type="hidden" name="comment_num" value="${comment.comment_num }">
						<input type="hidden" name="board_num" value="${boarddetail.board_num }">
						<input class="btn btn-sm" type="submit" value="Delete">
					</form>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
		<form action="http://localhost:8181/ICT_MARKET/CommentInsert" method="post">
			<div class="form-floating">
			<input type="hidden" name="board_num" value="${boarddetail.board_num }">
			  <textarea class="form-control" placeholder="Leave a comment here" name="comment_content" id="floatingTextarea"></textarea>
			  <label for="floatingTextarea">Comments</label>
			</div>		
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<input class="btn" type="submit" value="write" id="comment">
			</div>
		</form>
		
</div>
</div>
</body>
</html>