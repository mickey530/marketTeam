<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
	html, body{height:100%}
	#wrapper{
		height: auto;
		min-height: 100%;
		padding-bottom: 157px;
	}
	.main{text-align:center;

		}
		.info{text-align:right;}
	footer{
		height: 157px;
		position: relative;
		transform: translateY(-100%);
		font-size: 8px;
	}	
</style>
<title>ICT Market</title>
</head>
<body>
<div id="wrapper">
<c:if test="${sessionScope.session_id eq null }">
<header class="p-3 border-bottom bg-white sticky-top">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="http://localhost:8181/ICT_MARKET/" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
				<h2 style="margin:0; font-family: 'Play', sans-serif; font-weight: 700;">ICT MARKET</h2>
			</a>
			
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>
	
			<div>
				<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
	           
					<form name="searchHeader" action="http://localhost:8181/ICT_MARKET/board/Board_search.jsp" method="get" 
				class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" style="font-family: 'Play', sans-serif; font-size: 80%">
					<input type="search" class="form-control" name="search_keyword" placeholder="Search" aria-label="Search">
				</form>
	
					<li style="font-family: 'Play', sans-serif; font-size: 80%"><a href="http://localhost:8181/ICT_MARKET/ICTLF" class="nav-link px-2 link-dark fw-bold">Login</a></li>
					<li style="font-family: 'Play', sans-serif; font-size: 80%"><a href="http://localhost:8181/ICT_MARKET/users/join_form.jsp" class="nav-link px-2 link-dark fw-bold">Sign-up</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>
</c:if>

<!-- 세션에 아이디가 존재할 때 헤더 -->
<c:if test="${sessionScope.session_id ne null }">
<header class="p-3 border-bottom bg-white sticky-top">
<div class="container">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		<a href="http://localhost:8181/ICT_MARKET/" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
			<h2 style="margin:0; font-family: 'Play', sans-serif; font-weight: 700;">ICT MARKET</h2>
		</a>
		
		<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>

		<div>
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
           
				<form name="searchHeader" action="http://localhost:8181/ICT_MARKET/board/Board_search.jsp" method="get" 
				class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" style="font-family: 'Play', sans-serif; font-size: 80%">
					<input type="search" class="form-control" name="search_keyword" placeholder="Search" aria-label="Search">
				</form>
               
				<li>
					<a href="http://localhost:8181/ICT_MARKET/boardList?board_info=ALL" class="nav-link px-2 link-dark fw-bold">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-sidebar-reverse" viewBox="0 0 16 16">
							<path d="M12.5 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm0 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm.5 3.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
							<path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2zM4 1v14H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm1 0h9a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5V1z"/>
						</svg>
					</a>
				</li>
               
				<li>
					<a href="http://localhost:8181/ICT_MARKET/boardInsertForm" class="nav-link px-2 link-dark fw-bold">
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
				<li><a href="http://localhost:8181/ICT_MARKET/userInfo" class="nav-link px-2 link-dark fw-bold">${sessionScope.session_id}</a></li>
				<li><a href="http://localhost:8181/ICT_MARKET/logOut" class="nav-link px-2 link-dark fw-bold">logout</a></li>
				<li>
					<a href="#" id="profile" style="padding: 15px;"> 
						<img src="https://yt3.ggpht.com/ytc/AKedOLTi6w4E6985-QdVBbovBSsnCeTETyj0WomjM5IY8Q=s88-c-k-c0x00ffffff-no-rj" alt="mdo" width="32" height="32" class="rounded-circle">
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</header>
</c:if>


<!-- main 컨텐츠 내용 -->
<div class="main">

<h1 class="userinfo">회원정보</h1>




<form class="info">
	<div class="row mb-3">
    <label class="col-sm-2 col-form-label">아이디</label> 
    <div class="col-sm-3">
      <input type="text" class="form-control" value="${user.user_id }" readonly/>
    </div>
  </div>
  <div class="row mb-3">
    <label class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" value="${user.user_name }" readonly/>
    </div>
  </div>

  <div class="row mb-3">
    <label class="col-sm-2 col-form-label">휴대전화</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" value="${user.user_pnum }" readonly/>
    </div>
  </div>
  <div class="row mb-3">
    <label class="col-sm-2 col-form-label">주소</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" value="${user.user_address }" readonly/>
    </div>
  </div>

  

  </form>
   
  <form class="deleteinfo" action="http://localhost:8181/ICT_MARKET/userInfoDelete.com" method="post">
  <div class="row mb-3">
    <label class="col-sm-2 col-form-label"></label>
    <div class="col-sm-3">

    <input type="hidden" value="${user.user_id }" name="user_id"/>
    <input type="hidden" value="${user.user_num }" name="user_num"/>
      <input type="submit" class="form-control" value="탈퇴" readonly/>
    </div>
  </div>
  </form>
  <form class="updateinfo" action="http://localhost:8181/ICT_MARKET/userInfoUpdateForm.com"" method="post">
  <div class="row mb-3">
    <label class="col-sm-2 col-form-label"></label>
    <div class="col-sm-3">
    
    <input type="hidden" value="${user.user_id }" name="user_id"/>
      <input type="submit" class="form-control" value="수정" readonly/>
    </div>
  </div>
  </form>

 </div>
 




</body>
</html>