<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- link rel="stylesheet" type="text/css"   href="Ques.css"-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.0.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title>Techqui</title>
	
	
  </head>
  <body>
    
	<div class="container-fluid">
    
	<nav class="navbar navbar-dark bg-dark" >
	  <div class="container-fluid">
	  <a href="AdminDash.html">
	    <img src="logo2.jpg" class="logo" alt="logo" height="80" width="100" style="opacity: 0.9; filter: grayscale(40%); margin-left:50px" ></a>
		<!-- a class="navbar-brand" href="#"><b>Online Technology Quiz</b></a-->
	<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
    Hello Admin
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <li><a class="dropdown-item" href="Profile">Profile</a></li>
    <li><a class="dropdown-item" href="Logout">Logout</a></li>
    <li><a class="dropdown-item" href="Pass.html">Change Password</a></li>
  </ul>
  
	</div>
    </div>
	</nav>
<div class="container-fluid"  style="height:100vh">
  <div class="row"  style="height:100vh">
    <div class="col">
		  <div class="row">
			<div class="col-9 bg-dark"  style="height:100vh">
           <h1 style="margin-top:20px;margin-left:20px;color:grey;">Dashboard</h1>
		   <br>
		   <br>
		     
		  <div class="btn-group-vertical" style="margin-left:20px;" aria-label="Basic outlined example" >
		  <a href="Req_Pending" button type="button" class="btn btn-dark"><i class="fas fa-calendar-check"></i>  Pending Requests
		  <a href="Detail" button type="button" class="btn btn-dark"><i class="fas fa-th-list"></i>  Registered Students</button></a>
		  <a href="AQues.html" button type="button" class="btn btn-dark"><i class="fas fa-plus"></i>  Create Quiz</button></a>
		  <a href="viewQuiz.jsp"  button type="button" class="btn btn-dark" ><i class="fas fa-eye"></i>  View Quiz</button></a>
		  <a href="DeleteQuiz" button type="button" class="btn btn-dark"><i class="fas fa-trash-alt"></i>  Delete Quiz</button></a>
		  <a href="Modify.html" button type="button" class="btn btn-dark"><i class="fas fa-edit"></i>  Modify Quiz</button></a>
		  <a href="ALeaderboard" button type="button" class="btn btn-dark"><i class="fas fa-trophy"></i>  Ranking Table</button></a>
		  <a href="Participants.jsp" button type="button" class="btn btn-dark"><i class="fas fa-user-graduate"></i>  Participants </a>
		  <a href="Record.jsp" button type="button" class="btn btn-dark"><i class="fas fa-clipboard"></i>  View Records </a>
		  <!-- button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
				<i class="fas fa-user-graduate"></i>  Participants
			  </button>
			  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  <li><a class="dropdown-item" href="#">JAVA</a></li>
			  <li><a class="dropdown-item" href="#">SQL</a></li>
			  </ul>
		  <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
			<i class="fas fa-clipboard"></i>  View Records
			  </button>
			  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<!-- li><a class="dropdown-item " href="#">Attendent Participents</a></li>
				<li><a class="dropdown-item" href="#">Not Attendent Participents</a></li>
				<li><a class="dropdown-item" href="#">Outstanding</a></li>
				<li><a class="dropdown-item" href="#">Extraordinary</a></li>
				<li><a class="dropdown-item" href="#">Failed</a></li>
			  </ul-->

		  </div>
		  <br>
		  <br>
    </div>
    <div class="col">
	</div>
	
  </div>
</div>
 <div class="col-9">
 <table class="table table-striped table-hover" style="margin-left:-50px;margin-top:50px;margin-bottom:50px;">
  <thead>
    <tr>
      <th scope="col" colspan="2"><h1><center>Welcome to Techqui</center></h1></th>
	  <th scope="col"></th>
	  <th scope="col"></th>
    </tr>
  </thead>
  
  <tbody>
    <tr><td>
<form method=post   action=ViewQuestion >
<h3> View Quiz </h3>
<br>
<label for="Tech">Choose Technology:</label>

<select name="Tech" id="Tech">
  <option value="1" >JAVA</option>
  <option value="2"   >Python</option>
  <option value="3">SQL</option>
  <option value="4">Data Science</option>
  <!-- option value="5">Other</option-->
</select>
<input type=submit name=submit  value=Submit  /><br>

<p id="Quesone"></p>
<p id="Ansone"></p>
<p id="Questwo"></p>
<p id="Anstwo"></p>
<p id="Questhree"></p>
<p id="Ansthree"></p>











<!-- 
<input type=text name=q1  placeholder="Question 1"  /></center><br>
<input type=text name=a1 placeholder="Answer 1" /></center><br>
<input type=text name=q2  placeholder="Question 2"  /></center><br>
<input type=text name=a2 placeholder="Answer 2" /></center><br>
<input type=text name=q3  placeholder="Question 3"  /></center><br>
<input type=text name=a3 placeholder="Answer 3" /></center><br>

<input type=text name=q4  placeholder="Question 4"  /></center><br>
<input type=text name=a4  placeholder="Answer 4" /></center><br>
<input type=text name=q5  placeholder="Question 5"  /></center><br>
<input type=text name=a5 placeholder="Answer 5" /></center><br>
<input type=text name=q6  placeholder="Question 6"  /></center><br>
<input type=text name=a6 placeholder="Answer 6" /></center><br>
<input type=text name=q7  placeholder="Question 7"  /></center><br>
<input type=text name=a7 placeholder="Answer 7" /></center><br>
<input type=text name=q8  placeholder="Question 8"  /></center><br>
<input type=text name=a8 placeholder="Answer 8" ></center><br>
<input type=text name=q9  placeholder="Question 9"  /></center><br>
<input type=text name=a9 placeholder="Answer 9" /></center><br>
<input type=text name=q10  placeholder="Question 10"  /></center><br>
<input type=text name=a10 placeholder="Answer 10" /></center>-->
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>