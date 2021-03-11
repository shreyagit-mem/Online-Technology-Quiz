<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Techqui</title>
	<!--  <link rel="stylesheet" type="text/css" href="otp.css">-->
	<link rel="stylesheet" type="text/css"   href="style.css">
  <link    rel="stylesheet"    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
<link href="https://fonts.googleapis.com/css2?family=Flamenco&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
	 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <style>
	body{

	height: 100%;
  /* Center and scale the image nicely */
  
  background-repeat: no-repeat;
  background-size: cover;
	
	background-image:linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.3)),url('background.jpeg'); 
 }
.row
{
	max-width: 1680px;
	margin: 0 auto;
	/*height:140px;*/
	
background: -webkit-linear-gradient(to right, #434343, #000000);
opacity:0.9;
}

.logo
{
	height: 120px;
	width: auto;
	float: left;
	margin-left:70px;
	margin-top: 10px;
}

.main-nav
{

font-size: 16px;
/*width:auto;*/
	float: right;
	margin-top:50px;
	/*margin-left: 2px;*/
	margin-right: 50px;
}

.main-nav li
{
	display: inline-block;
	list-style: none;
	margin-left: 75px;
	
}
 
.main-nav li a
{
	font-family: 'Flamenco', cursive;
	padding: 5px 0px;
	color:white;
	text-decoration: none;
	text-transform: uppercase;
	font-size: 130%;
	font-weight: 100%;

}

.main-nav li a:hover
{
	border-bottom: 2px solid #bf55ec;
}
            

.container{
	display: flex;
	flex-flow: column;
	position: absolute;
		top:40%;
	left: 36%;
	align-items: space-around;
	justify-content: center;
}

.userInput{
	display: flex;
	justify-content: center;
	padding:10px;
	
}

input{
font-weight:bold;
	margin: 10px;
	height: 35px;
	width: 65px;
	border: none;
	border-radius: 5px;
	text-align: center;
	font-family: arimo;
	font-size: 1.2rem;
	background: #eef2f3;
 box-shadow: 3px 3px 5px #aaaaaa;
  -webkit-transition: 0.5s;
  transition: 0.5s;
  outline: none;
}


h1{
	text-align: center;
	font-family: 'Flamenco', cursive;
	color: honeydew;
}


button{
	width: 150px;
	height: 40px;
	margin: 25px auto 0px auto;
	font-family: arimo;
	font-size: 1.1rem;
	border: none;
	border-radius: 5px;
	letter-spacing: 2px;
	cursor: pointer;
	background: #616161;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #9bc5c3, #616161);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #9bc5c3, #616161); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}
form a
{
color:red;
}

	</style>
	<script>
	
	function clickEvent(first,last){
		if(first.value.length){
			document.getElementById(last).focus();
		}
	}</script>
	
</head>
<body>
   <header>		<nav>
				<div class="row clearfix">
				<a href="index.html">
				<img src="logo2.jpg" class="logo" alt="logo" style="opacity: 0.9;  filter: grayscale(40%);" ></a>
					<ul class="main-nav animate__animated animate__slideInDown"   id="check-class" >
						<li><a href="SLogin.html"><i style='font-size:22px' class='fas'>&#xf501;</i>Student </a></li>
						<li><a href="Admin.html"><i style='font-size:22px'  class='fas'>&#xf406;</i>Admin</a></li>
						<li><a href="#"><i style="font-size:22px" class="fa">&#xf091;</i>Leaderboard </a></li>
						<li><a href="blogs.html"><i style='font-size:22px' class='fab'>&#xf37d;</i>Blogs </a></li>
						<li><a href="AboutUs.html"><i style='font-size:22px' class='fas'>&#xf35a;</i>About </a></li>
						<li><a href="contactus.html"><i style='font-size:22px' class='fas'>&#xf879;</i>Contact US </a></li>
					
					</ul>
					</div>
			</nav>
	<form method="post" action="StudForgetPassValidation">
	<input type="hidden" name="id" value=<%= request.getAttribute("id") %> />
	<input type="hidden" name="pass" value=<%= request.getAttribute("pass") %> />
	<input type="hidden" name="otp" value=<%= request.getAttribute("otp") %> />
	<div class="container">
		<h1>ENTER OTP</h1>
		<div class="userInput">
			<input type="text" id='ist' maxlength="1"   autofocus="autofocus" onkeyup="clickEvent(this,'sec')" name="one" required="required" />
			<input type="text" id="sec" maxlength="1" onkeyup="clickEvent(this,'third')" name="two" required="required" />
			<input type="text" id="third" maxlength="1" onkeyup="clickEvent(this,'fourth')" name="three" required="required" />
			<input type="text" id="fourth" maxlength="1" onkeyup="clickEvent(this,'fifth')" name="four" required="required" />
			<input type="text" id="fifth" maxlength="1" name="five" required="required" /><br>
		</div>
		<button><center>CONFIRM</center></button>
	</div>
		</form>
	</header>
</body>
</html>
	</header>
</body>
</html>