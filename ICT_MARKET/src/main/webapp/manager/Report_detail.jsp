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
		padding-bottom: 193px;
	}
	body{
transition :0.5s;
}

#head{
font-family: 'Play', sans-serif;
font-size: 90%;
}

.sidenav{
	width:100px;
	border-radius: 5px;
	position: fixed;
	right:0;
	z-index:1; 
	background: #dcdcdc;
	margin-top: -1px; 
	margin-right: 120px;
	overflow-y: hidden;
	
	
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
	justify-content: center;
	margin-top:-15px;
	max-width: 90%;
  	font-size: 2vmin;
	}
	#navgate .btn:hover{
	color: #f1f1f1;
	}
	#navgate #list{
    white-space: nowrap;
	text-align:left;
	margin-left:30px;
	}
	
	#navgate #post{
    white-space: nowrap;
	float:right;
	}
	
	#navgate #edit{
    white-space: nowrap;
	float:right;
	}
	
	#navgate #del{
    white-space: nowrap;
	float:right;
	margin-right:30px;
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
<c:if test="${sessionScope.session_id ne 'Manager'}">
<% response.sendRedirect("http://localhost:8181/ICT_MARKET"); %>
</c:if>
<div id="wrapper">
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
<!-- Header Menu(onclick main body->close-->
				<div id="mySidenav" class="sidenav">
					<a href="http://localhost:8181/ICT_MARKET/userInfo" class="text-center">Profile</a>
					<a href="/ICT_MARKET/boardInsertForm" class="text-center">Sell</a>
					<a href="http://localhost:8181/ICT_MARKET/logOut" class="text-center">Logout</a>
            	</div>
<script>
	function openNav(){
		document.getElementById("mySidenav").style.height="160px";
		document.body.style.backgroundColor="rgba(0,0,0,0.4)";
		document.getElementById("mainboard").style.filter="blur(3px)";
		
	}
	function closeNav(){
		document.getElementById("mySidenav").style.height="0px";
		document.body.style.backgroundColor="white";
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
<h3 class="col-md-11">${boarddetail.board_title}</h3>
<h6 class="col-md-12">Trade </h6>

<p id="no" class="col-2">No.${boarddetail.board_num}</p>
<p id="writer" class="col-9">작성자 ID : ${boarddetail.user_id}</p>
<hr/>
</div>

<div id="productamount" class="row">
<!-- notate unit of bills (below)-->
<!--<h4 class="col-10">Price: ₩<fmt:formatNumber value="${boarddetail.board_amount}" pattern="#,###"/></h4> -->
<table class="table table-dark table-hover" style="margin-left:14px; font-size: 2vmin;">
<tr>
	<th>Price</th>
    <td style="text-align:right;">₩ <fmt:formatNumber value="${boarddetail.board_amount}" pattern="#,###"/></td>
</tr>
<tr>
	<th>Cartegory</th>
    <td style="text-align:right;">${boarddetail.board_category}</td>
</tr>
</table>
</div>
<div id="contents" class="row">
<img src="" style="float:left;"/>
<p class="text-left">${boarddetail.board_content}</p>
</div>

<div class="row">
<hr/>
<p class="col-12 d-flex justify-content-start">신고내용</p>
<hr/>

<p class="text-left">${reportDetail.reported_reason}</p>
<p class="d-flex justify-content-end">신고자 ID : ${reportDetail.reporting_id}</p>
<hr/>
<br/>
</div>

<div id="navgate" class="container d-flex justify-content-center">
<form action="http://localhost:8181/ICT_MARKET/reportList.com" id="list" class="col-md-11">
	<input type="submit" class="btn" value="List">
</form>
<form id="blind" action="#" method="post">
<input type="hidden" value="${sessionScope.session_id}" name="session_id">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<input type="submit" type="button" class="btn" value="Blind" id="comment">
</form>
<form id="unblind" action="#" method="post">
<input type="hidden" value="${sessionScope.session_id}" name="session_id">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<input type="submit" type="button" class="btn" value="Unblind" id="comment">
</form>
<form id="del" action="http://localhost:8181/ICT_MARKET/reportBoardDelete.com" method="post">
<input type="hidden" value="${sessionScope.session_id}" name="session_id">
<input type="hidden" value="${boarddetail.board_num}" name="board_num">
<input type="submit" type="button" class="btn btn-outline-danger" style="border:none" value="Delete" id="comment">
</form>
</div>
<br/>



</div>


</body>

</html>