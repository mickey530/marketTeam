<%-- member/loginForm.jsp --%>

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

   <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


<style>
	
	   .form-member-join{
     
      width:900px;
   
     margin-left:1400px;
     margin-bottom: 400px;
     margin-top: 100px;
      }
      


      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
	
	
	
	
	html, body{height:100%}
	#wrapper{
		height: auto;
		min-height: 100%;
		padding-bottom: 193px;
	}
	
	@import url('https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Hahmlet:wght@200&family=Play:wght@400;700&display=swap');
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
	font-family: font-family: 'Hahmlet', serif;
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
	border: 1px solid #ccc;
	margin-top: 10px;
	width: 100%;
	height: 450px;
	background-color: #dcdcdc;
	}
	
	.wts{
	width: 49%;
	text-align: center;
	position:sattic;
	margin-top: 5px;
	}
	
	.line2{
	width: 1px;
	height: 100%;
	background: #eee;
	}
	
	.wtb{
	width: 49%;
	text-align: center;
	position:sattic;
	margin-top: 5px;
	}
	
	footer{
		height: 120px;
		position: relative;
	}	
</style>
<title>ICT Market</title>
</head>
<body>
<<<<<<< HEAD

<div id="wrapper">
<!-- 세션에 아이디가 존재하지 않을 때 헤더 -->
<!-- <header class="p-3 border-bottom bg-white sticky-top">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
				<h2 style="margin:0">ICT MARKET</h2>
			</a>
			
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>
	
			<div>
				<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
	           
					<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
						<input type="search" class="form-control" placeholder="Search..." aria-label="Search">
					</form>
	
					<li><a href="#" class="nav-link px-2 link-dark fw-bold">Login</a></li>
					<li><a href="#" class="nav-link px-2 link-dark fw-bold">Sign-up</a></li>
				</ul>
			</div>
		</div>
	</div>
</header> -->


<!-- 세션에 아이디가 존재할 때 헤더 -->
<header class="p-3 border-bottom bg-white sticky-top">
<div class="container">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
			<h2 style="margin:0; font-family: 'Play', sans-serif; font-weight: 700;">ICT MARKET</h2>
		</a>
		
		<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"></ul>

		<div>
			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
           
				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control" placeholder="Search..." aria-label="Search">
				</form>
               
				<li>
					<a href="#" class="nav-link px-2 link-dark fw-bold">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-sidebar-reverse" viewBox="0 0 16 16">
							<path d="M12.5 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm0 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm.5 3.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
							<path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2zM4 1v14H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm1 0h9a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5V1z"/>
						</svg>
					</a>
				</li>
               
				<li>
					<a href="#" class="nav-link px-2 link-dark fw-bold">
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
				<li><a href="#" class="nav-link px-2 link-dark fw-bold">calmdownman</a></li>
				<li><a href="#" class="nav-link px-2 link-dark fw-bold">logout</a></li>
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


<!-- main 컨텐츠 내용 -->
 <body class="text-center">
    
<main class="form-member-join">
  <form action="http://localhost:8181/ICT_MARKET/ICTJ"method="post">
   
    <h1 class="h3 mb-3 fw-normal"><h1>회 원 가 입</h1></br>

     <div class="form-floating">
      <h4>이 름</h4>
      <input type=text" class="form-control" name="name" required placeholder="name">
      <label for="floatingInput">name</label></br></br>
    </div>
    <h4>아이디</h4>
    <div class="form-floating">
      <input type=text" class="form-control" name="id" required placeholder="id">
      <label for="floatingInput">id</label></br></br>
    </div>
    <h4>비밀 번호</h4>
    <div class="form-floating">
      <input type="password" class="form-control" name="pw" required placeholder="password">
       <label for="floatingInput">password</label></br></br>
    </div>
    <h4>폰 번호</h4>
    <div class="form-floating">
      <input type="text" class="form-control" name="phone" maxlength="11" required placeholder="phone">
       <label for="floatingInput">phone</label></br></br>
    </div>
    <h4>주 소</h4>
     <div class="form-floating">
      <input type="addr" class="form-control" name="addr"  required placeholder="addr">
       <label for="floatingInput">addr</label></br></br>
    </div>

    
    <button class="w-100 btn btn-lg btn-primary" type="submit"><h2>회원 가입</h2></button>
    
  </form>
</main>


    
  </body>
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


		</table>
	</form>
</body>
</html>