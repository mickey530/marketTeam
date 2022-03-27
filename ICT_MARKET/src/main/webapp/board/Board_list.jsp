<%--@ page import="kr.co.ict.BoardVO"--%>
<%--@ page import="kr.co.ict.BoardDAO"--%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	
	.tab_menu .btn:hover{
	color: #f1f1f1;
	}
	
	#mainboard {
	font-family: 'Play', sans-serif;
	}
	#mainboard .row{
	margin-top: 50px;
	margin-bottom: 10px;
	}
	#mainboard .row>.col-md-1{
	margin-right:14px;
	}
	#mainboard .row .col-md-11{
	font-weight: 700;
	font-size:30px;
	}
	.pagination{
	color:black;
	list-style: none;
	display: inline-block;
	margin-top: 5px;
	}
	.pagination li{
	display: inline-block;
	text-align: center;
	}
	.pagination a{
	color: black;
	display: block;
	font-size: 17px;
	text-decoration: none;
	padding-left:5px;
	padding-right:5px;
	}
	.pagination a:hover{
	color: #f1f1f1;
	}
	
	#navgate{
	display: flex;
	justify-content:space-between;
	margin-top:-15px;
  	font-size: 2vmin;
	}
	#navgate .btn:hover{
	color: #f1f1f1;
	}
	
	#navgate #post{
    white-space: nowrap;
	float:right;
	}
	
	td > a {text-decoration:none; color:black}
	
	footer{
	font-size: 40%;
	height: 150px;
	position: relative;
  	bottom: 0px;
	
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
				<li><a href="http://localhost:8181/ICT_MARKET/userInfo.com" class="nav-link px-2 link-dark fw-bold">${sessionScope.session_id}</a></li>
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

<!-- Header Menu(onclick main body->close-->
				<div id="mySidenav" class="sidenav">
					<a href="http://localhost:8181/ICT_MARKET/userInfo" class="text-center">Profile</a>
					<a href="/ICT_MARKET/boardInsertForm" class="text-center">Sell</a>
					<a href="http://localhost:8181/ICT_MARKET/logOut" class="text-center">Logout</a>
            	</div>
<script>
	function openNav(){
		document.getElementById("mySidenav").style.height="160px";
		document.getElementById("mainboard").style.filter="blur(3px)";
		
	}
	function closeNav(){
		document.getElementById("mySidenav").style.height="0px";
		document.getElementById("mainboard").style.filter="blur(0)";
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
<h3 class="col-md-11">${info}</h3>
<h5 class="col-md-1">Trade</h5>
<table class="tab_menu">

  <tr class="list">
  <td>
  <c:if test="${info eq 'Want to Sell'}">
  <form action="http://localhost:8181/ICT_MARKET/boardList.com" method="get">
    <input type="submit" class="btn" name="board_info" value="SaleOnly" style="font-size: 10px; color:blue;">
  </form>
  </c:if>
  </td>
  	<td>
      <form action="http://localhost:8181/ICT_MARKET/boardList.com" method="get">
      	<input type="submit" class="btn" name="board_info" value="WTS">
      </form>
    </td>
    <td>
      <form action="http://localhost:8181/ICT_MARKET/boardList.com" method="get">
      	<input type="submit" class="btn" name="board_info" value="WTB">
      </form>
    </td>
    <td>
      <form action="http://localhost:8181/ICT_MARKET/boardList.com" method="get">
      	<input type="submit" class="btn" name="board_info" value="ALL">
      </form>      
    </td>
  </tr>
</table>
</div>
	<table class="table table-hover" style="font-size:80%">
		<tr>
			<th class="col-md-1">No</th>
			<c:choose>
	    	<c:when test="${info eq 'Want to Sell'}">
			<th class="col-md-1">판매여부</th>
			<th class="col-md-6">제목</th>
			<th style="text-align:center;">가격</th>
			</c:when>
			<c:otherwise>
			<th class="col-md-8">제목</th>
			</c:otherwise>
			</c:choose>
			<th style="text-align:center;">글쓴이</th>
			<th style="text-align:center;">날짜</th>
			<th style="text-align:center;">조회</th>
			
			<th style="text-align:center;">찜</th>
	</tr>
		<c:forEach items="${boardList}" var="board">
		<tr>
	    	<td class="col-md-1">${board.board_num}</td>
	    	<c:choose>
	    	<c:when test="${info eq 'Want to Sell'}">
	    	<c:if test="${board.board_sold == false}">
			<td class="col-md-1" style="color:blue;">On Sale</td>
			</c:if>
			<c:if test="${board.board_sold == true}">
			<td class="col-md-1" style="color:red;">Soldout</td>
			</c:if>
			<td class="col-md-6">
			<a href="http://localhost:8181/ICT_MARKET/boardDetail.com?board_num=${board.board_num}" style="text-decoration:none;">
				${board.board_title}
				</a>
			</td>
			<td style="text-align:right; padding-right:40px;"><fmt:formatNumber value="${board.board_amount}" pattern="#,###"/>원</td>
			</c:when>
			<c:otherwise>
			<td class="col-md-8">
			<a href="http://localhost:8181/ICT_MARKET/boardDetail.com?board_num=${board.board_num}" style="text-decoration:none;">
				${board.board_title}
				</a>
			</td>
			</c:otherwise>
			</c:choose>
				
			
			<td style="text-align:center;">${board.user_id}</td>
			<td style="text-align:center;">${board.board_writetime}</td>
			<td style="text-align:center;">${board.board_hit}</td>
			
			<td style="text-align:center;">${board.board_picked_num}</td>
		</tr>
		</c:forEach>
	</table>
 	
	<div id="navgate" class="container">
	<nav aria-label="Page navigation" style="float:left">
  	<ul class="pagination">
    <li><p><a href="?pageNum=${dto.startPage -1}" style="text-decoration: none;">prev</a></p></li>
    <c:forEach var="pageIndex" begin="${dto.startPage}" end="${dto.endPage}">
    <li><a href="http://localhost:8181/ICT_MARKET/boardList.com?board_info=${boardinfo}?pageNum=${pageIndex}"
    style="text-decoration: none;"> ${pageIndex} </a></li>
    </c:forEach>
    <li><a href="?pageNum=${dto.endPage +1}" style="text-decoration: none;">next</a></li>
 	</ul>
	</nav>
	<c:if test="${not empty sessionScope.session_id}">
	<form id="post" action="http://localhost:8181/ICT_MARKET/boardInsertForm.com" method="post">
	<input type="hidden" value="${boarddetail.board_num}" name="board_num">
	<input type="submit" type="button" class="btn" value="Post Thread">
	</form>
	</c:if>
	
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