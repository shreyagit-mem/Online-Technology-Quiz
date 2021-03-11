 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techqui</title>
<link rel="stylesheet" type="text/css"   href="Home_Template.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" type="text/css"   href="style.css">
<link rel="stylesheet"    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
<link href="https://fonts.googleapis.com/css2?family=Flamenco&display=swap" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<header>
		<nav>
			<div class="row clearfix">
			<a href="index.html">
<img src="logo2.jpg" class="logo" alt="logo" style="opacity: 0.9;  filter: grayscale(40%);" ></a>
					<ul class="main-nav animate__animated animate__slideInDown"   id="check-class" >
						<li><a href="SLogin.html"><i style='font-size:22px' class='fas'>&#xf501;</i>Student </a></li>
						<li><a href="Admin.html"><i style='font-size:22px'  class='fa'>&#xf406;</i>Admin</a></li>
						<li><a href="#"><i style="font-size:22px" class="fa">&#xf091;</i>Leaderboard </a></li>
						<li><a href="blogs.html"><i style='font-size:22px' class="fab">&#xf37d;</i>Blogs </a></li>
						<li><a href="AboutUs.html"><i style='font-size:22px' class="fas">&#xf35a;</i>About </a></li>
						<li><a href="contactus.html"><i style='font-size:22px' class='fas'>&#xf879;</i>Contact US </a></li>
					</ul>
					<a href="#" class="mobile-icon"  onclick="slideshow()"><i class="fa fa-bars"></i></a>
				</div>
			</nav>
<div class="transbox">
<form method=post   action="studForget" >
<center><p>Forgot Password  </p>
</center><br>
<center><input type=email  class="inputtext btn-submit" name=email placeholder="ID"  required="required" />
</b></center><br>
<center><input type=submit name=sub value=Forgot /></center><br>
<center><a href="SLogin.html" style='font-size:10px solid black'>Cancel</a></center><br>
</form>
</div>
</header>
</body>
</html>