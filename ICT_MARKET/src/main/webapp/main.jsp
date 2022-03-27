<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Hahmlet:wght@200&family=Play:wght@400;700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>

	@import url('https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Hahmlet:wght@200&family=Play:wght@400;700&display=swap');
	
	html, body{height:100%}
	#wrapper{
		height: auto;
		min-height: 100%;
		padding-bottom: 100px;
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
	
	#main {
	height: auto;
	}
	
	.main_head{
	padding: 70px;
	}
	.main_head h2{
	font-family: 'Play', sans-serif;
	font-weight: 700;
	}
	.main_head p {
	font-family: 'Play', sans-serif;
	}
	
	#main_div{
	position: relative;
	}
	#main_div .main_contain{
	position: absolute;
	left: 20%;
	margin-top: -50px;
	text-align: center;
	}
	
	.main_contain{
	font-family: 'Play', sans-serif;
	width: 60%;
	height: auto;
	}
	
	.line{
	width: 100%;
	height: 1px;
	background: #eee;
	margin-top: 30px;
	}
	
	.recently{
	overflow: auto;
	width: 100%;
	height: 420px;
	font-size: 2vmin;
	
	}
	.colorbox{
	position: fixed;
	margin-top: 50px;
	width: 100%;
	height: 420px;
	z-index:1px;
	background: linear-gradient(transparent,white);
	pointer-events: none; 
	}
	table>tr,td{
    border:none;
    }
	.wts{
	width: 49%;
	text-align: justify;
	margin-top: 5px;
	padding:10px;
	}
	
	.line2{
	width: 1px;
	margin-left: 8px;
	height: 100%;
	background: #eee;
	}
	
	.wtb{
	width: 49%;
	text-align: justify;
	margin-top: 5px;
	padding:10px;
	}
	
	footer{
	font-size: 40%;
	height: 150px;
	position: relative;
  	bottom: 0px;
/* 	transform: translateY(-100%); */
	}
	footer div{
	font-family: 'Play', sans-serif;
	margin-top: 5px;
	margin-left: 90px;
	}
	
</style>
<title>ICT Market</title>
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
					<a href="http://localhost:8181/ICT_MARKET/pickList.com" class="nav-link px-2 link-dark fw-bold heart">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
							<path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
						</svg>
					</a>
				</li>
				<li><a href="http://localhost:8181/ICT_MARKET/userList.com" class="nav-link px-2 link-dark fw-bold">${sessionScope.session_id}</a></li>
				<li id="defaultNav" class="dNav">
					<a href="#" id="profile" style="padding: 15px" onclick="openNav()"> 
					<img src="https://yt3.ggpht.com/ytc/AKedOLTi6w4E6985-QdVBbovBSsnCeTETyj0WomjM5IY8Q=s88-c-k-c0x00ffffff-no-rj" alt="mdo" width="32" height="32" class="rounded-circle"/>
					</a>
					<div id="mySidenav" class="sidenav">
					<a href="http://localhost:8181/ICT_MARKET/userInfo.com" class="text-center">Profile</a>
					<a href="http://localhost:8181/ICT_MARKET/boardInsertForm.com" class="text-center">Sell</a>
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

	<!--search-->
	function press(f){ 
		if(f.keyCode == 13){ 
		searchHeader.submit(); 
		} 
	} 
	
</script>


<!-- main-->
<div id="main" onclick="closeNav()">
	<div class="main_head">
		<c:choose>
			<c:when test="${not empty sessionScope.session_id}">
			<h2 class="text-center">Welcome back, ${myname.user_name}!</h2>
			</c:when>
			<c:otherwise>
				<h2 class="text-center">Welcome to ICT Market!</h2>
				<p class="text-center">Online Marketplace to Buy & Sell</p>
			</c:otherwise>
		</c:choose>
		
		</div>
		<div id="main_div">
			<div class="main_contain">
				<h6 class="text-center" style="float:left; margin-top:6px; margin-left:10px;">
				Recently thread
				</h6>
				<a href="http://localhost:8181/ICT_MARKET/boardList.com?board_info=ALL" type="button" class="btn btn-sm" style="float:right;">+</a>
				<div class="line"></div>
				
					<div class="recently">
					<div class="colorbox"></div>
					
						<div class="wts" style="float:left;">
						<h5 style="text-align:center; margin:20px">
						<a href="http://localhost:8181/ICT_MARKET/boardList.com?board_info=WTS"
						style="text-decoration:none; color:black;">Want to Sell</a></h5>
						<c:forEach items="${boardListsell}" var="board">
						<table id="rt" class="table table-hover" style="font-size:90%">
							<tr>
								<td style="text-align:left;">
								<a href="http://localhost:8181/ICT_MARKET/boardDetail.com?board_num=${board.board_num}" 
								style="text-decoration:none; color:black;">${board.board_title}</a></td>
								<td style="text-align:right;"><fmt:formatNumber value="${board.board_amount}" pattern="#,###"/>원</td>
							</tr>
							</table>
						</c:forEach>
						</div>
					
					<div class="line2" style="float:left;"></div>
					
						<div class="wtb" style="float:right;">
						<h5 style="text-align:center; margin:20px">
						<a href="http://localhost:8181/ICT_MARKET/boardList.com?board_info=WTB"
						style="text-decoration:none; color:black;">Want to Buy</a></h5>
						<c:forEach items="${boardListbuy}" var="board">
							<table id="rt" class="table table-hover" style="font-size:90%">
							<tr>
								<td style="text-align:left; text-decoration:none">
								<a href="http://localhost:8181/ICT_MARKET/boardDetail?board_num=${board.board_num}" 
								style="text-decoration:none; color:black;">${board.board_title}</a></td>
								<td style="text-align:right;"><fmt:formatNumber value="${board.board_amount}" pattern="#,###"/>원</td>
							</tr>
							</table>
						</c:forEach>
						</div>
					</div>
			</div>
		</div>
</div>

</div>
<!--footer-->
<footer class="p-3 py-3 border-top">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<div>
				<h6>Customer Service</h6>
					<ul class="nav flex-column">
						<li class="nav-item mb-2 text-muted">1111-6666</li>
						<li class="nav-item mb-2 text-muted">MON-FRI : 10:00 ~ 17:00</li>
						<li class="nav-item mb-2 text-muted">LUNCH: 13:00 ~ 14:00</li>
						<li class="nav-item mb-2 text-muted">SAT, SUN, HOLIDAY OFF</li>
					</ul>
			</div>
            
			<div>
				<h6>ICT MARKET</h6>
				<ul class="nav flex-column">
					<li class="nav-item mb-2">대표 : 6666 |</li>
					<li class="nav-item mb-2"> 사업자등록번호 : 666666666</li>
					<li class="nav-item mb-2">통신판매업 : 2022-01234</li>
					<li class="nav-item mb-2">주소 : 서울특별시 마포구 서교동 353-4 첨담빌딩 7층</li>
				</ul>
			</div>
            
			<div>
				<ul class="nav flex-column" style="font-size:10px">
					<li class="nav-item mb-2">Copyright © ICT MARKET 2022. All Rights Reserved.</li>
				</ul>
			</div>
		</div>
	</div>        

</footer>

</body>
</html>