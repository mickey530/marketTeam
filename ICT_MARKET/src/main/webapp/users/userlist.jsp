<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--add [no access for unauthorize manager option]-->
<%-- <c:if test="${sessionScope.session_id eq null}">
<% response.sendRedirect("http://localhost:8181/ICT_MARKET/userLogin.com"); %>
</c:if>
<c:if test="${sessionScope.session_id ne 'Manager' }">
<% response.sendRedirect("http://localhost:8181/ICT_MARKET/userInfo.com"); %>
</c:if> --%>
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
<!-- Session_id == Manager 시 헤더-->
<c:if test="${sessionScope.session_id eq 'Manager'}">
<header id="head" class="p-3 border-bottom bg-white sticky-top">
<div class="container">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		<a href="http://localhost:8181/ICT_MARKET/main.com" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
			<h2 style="margin:0; font-family: 'Play', sans-serif; font-weight: 700;">ICT MARKET</h2>
		</a>
		
		<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>

		<div>
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
           
				<form name="searchHeader" action="http://localhost:8181/ICT_MARKET/searchResult.com" method="get" 
				class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="hidden" name="search_where" value="header">
					<input type="search" class="form-control" name="search_keyword" placeholder="Search" aria-label="Search">
				</form>
               
				<li>
					<a href="http://localhost:8181/ICT_MARKET/userList.com" class="nav-link px-2 link-dark fw-bold">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-sidebar-reverse" viewBox="0 0 16 16">
							<path d="M12.5 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm0 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm.5 3.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
							<path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2zM4 1v14H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm1 0h9a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5V1z"/>
						</svg>
					</a>
				</li>
				<li>
					<a href="http://localhost:8181/ICT_MARKET/reportList.com" class="nav-link px-2 link-dark fw-bold heart">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-flag" viewBox="0 0 16 16">
						  <path d="M14.778.085A.5.5 0 0 1 15 .5V8a.5.5 0 0 1-.314.464L14.5 8l.186.464-.003.001-.006.003-.023.009a12.435 12.435 0 0 1-.397.15c-.264.095-.631.223-1.047.35-.816.252-1.879.523-2.71.523-.847 0-1.548-.28-2.158-.525l-.028-.01C7.68 8.71 7.14 8.5 6.5 8.5c-.7 0-1.638.23-2.437.477A19.626 19.626 0 0 0 3 9.342V15.5a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 1 0v.282c.226-.079.496-.17.79-.26C4.606.272 5.67 0 6.5 0c.84 0 1.524.277 2.121.519l.043.018C9.286.788 9.828 1 10.5 1c.7 0 1.638-.23 2.437-.477a19.587 19.587 0 0 0 1.349-.476l.019-.007.004-.002h.001M14 1.221c-.22.078-.48.167-.766.255-.81.252-1.872.523-2.734.523-.886 0-1.592-.286-2.203-.534l-.008-.003C7.662 1.21 7.139 1 6.5 1c-.669 0-1.606.229-2.415.478A21.294 21.294 0 0 0 3 1.845v6.433c.22-.078.48-.167.766-.255C4.576 7.77 5.638 7.5 6.5 7.5c.847 0 1.548.28 2.158.525l.028.01C9.32 8.29 9.86 8.5 10.5 8.5c.668 0 1.606-.229 2.415-.478A21.317 21.317 0 0 0 14 7.655V1.222z"/>
						</svg>
					</a>
				</li>
				<li><a href="http://localhost:8181/ICT_MARKET/userInfo.com" class="nav-link px-2 link-dark fw-bold">${sessionScope.session_id}</a></li>
				<li id="defaultNav" class="dNav">
					<a href="#" id="profile" style="padding: 15px" onclick="openNav()"> 
					<img src="https://yt3.ggpht.com/ytc/AKedOLTi6w4E6985-QdVBbovBSsnCeTETyj0WomjM5IY8Q=s88-c-k-c0x00ffffff-no-rj" alt="mdo" width="32" height="32" class="rounded-circle"/>
					</a>
					<div id="mySidenav" class="sidenav">
					<a href="http://localhost:8181/ICT_MARKET/userLogout.com" class="text-center">Logout</a>
            	</div>
				</li>
			</ul>
		</div>
	</div>
</div>
</header>
</c:if>


<!-- main 컨텐츠 내용 -->
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
<h3 class="col-md-11">My Thread</h3>
<h5 class="col-md-1"> </h5>
<table class="tab_menu">
  <tr class="list">
  	<td>
      <form action="http://localhost:8181/ICT_MARKET/userList.com" method="get">
      	<input type="submit" class="btn" name="userinfo" value="UserList">
      </form>
    </td>
    <td>
      <form action="http://localhost:8181/ICT_MARKET/reportList.com" method="get">
      	<input type="submit" class="btn" name="my_boardList" value="ReportList">
      </form>
    </td>
  </tr>
</table>
</div>
<table class="table table-hover" style="font-size:80%">
  <tr>
	  <th>No</th>
	  <th style="text-align:center;">회원아이디</th>
	  <th style="text-align:center;">회원이름</th>
	  <th style="text-align:center;">전화번호</th>
	  <th style="text-align:center;" class="col-md-6">주소</th>
  </tr>
 <c:forEach var="user" items="${userList}">
 <tr>
  <td>${ user.user_num}</td>
  <td style="text-align:center;"><a href="http://localhost:8181/ICT_MARKET/userInfoManager.com?user_num=${user.user_num}">${ user.user_id}</a></td>
  <td style="text-align:center;">${ user.user_name}</td>
  <td style="text-align:center;">${ user.user_pnum }</td>
  <td style="text-align:center;" class="col-md-6">${ user.user_address }</td>
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

	
</div>
</div>
</div>

<!-- 여기서 부터는 푸터 -->

<footer class="p-3 py-3 border-top">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<div class="col">
				<h5>SC CENTER</h5>
					<ul class="nav flex-column">
						<li class="nav-item mb-2 text-muted">1111-6666</li>
						<li class="nav-item mb-2 text-muted">MON-FRI : 10:00 ~ 17:00</li>
						<li class="nav-item mb-2 text-muted">LUNCH: 13:00 ~ 14:00</li>
						<li class="nav-item mb-2 text-muted">SAT, SUN, HOLIDAY OFF</li>
					</ul>
			</div>
            
			<div class="col">
				<h5>ICT MARKET</h5>
				<ul class="nav flex-column">
					<li class="nav-item mb-2">대표 : 6666 |</li>
					<li class="nav-item mb-2"> 사업자등록번호 : 666666666|</li>
					<li class="nav-item mb-2">통신판매업 : 2022-01234 |</li>
					<li class="nav-item mb-2">주소 : 서울특별시 마포구 서교동 353-4 첨담빌딩 7층</li>
				</ul>
			</div>
            
			<div class="col">
				<ul class="nav flex-column">
					<li class="nav-item mb-2">Copyright © ICT MARKET. All Rights Reserved.</li>
				</ul>
			</div>
		</div>
	</div>        
</footer>


</body>
</html>