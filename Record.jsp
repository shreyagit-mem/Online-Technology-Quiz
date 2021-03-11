<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.0.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <title>Techqui</title>
	
	
  </head>
  <body>
    
	<div class="container-fluid">
	<nav class="navbar navbar-dark bg-dark" >
	  <div class="container-fluid">
	  <img src="logo2.jpg" class="logo" alt="logo" height="80" width="100" style="opacity: 0.9;  filter: grayscale(40%); margin-left:50px" >
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
		  <div class="btn-group-vertical" style="margin-left:20px;" aria-label="Basic outlined example">
			  <a href="Req_Pending" button type="button" class="btn btn-dark"><i class="fas fa-calendar-check"></i>  Pending Requests
			  <a href="Detail" button type="button" class="btn btn-dark"><i class="fas fa-th-list"></i>  Registered Students
			  <a href="AQues.html" button type="button" class="btn btn-dark"><i class="fas fa-plus"></i>  Create Quiz
			  <a href="viewQuiz.jsp" button type="button" class="btn btn-dark"><i class="fas fa-eye"></i>  View Quiz
			  <a href="DeleteQuiz" button type="button" class="btn btn-dark"><i class="fas fa-trash-alt"></i>  Delete Quiz</a>
			  <a href="Modify.html" button type="button" class="btn btn-dark"><i class="fas fa-edit"></i>  Modify Quiz</a>
			  <a href="ALeaderboard" button type="button" class="btn btn-dark"><i class="fas fa-trophy"></i>  Ranking Table </a>
			  <a href="Participants.jsp" button type="button" class="btn btn-dark"><i class="fas fa-user-graduate"></i>  Participants </a>
			  <a href="Record.jsp" button type="button" class="btn btn-dark"><i class="fas fa-clipboard"></i>  View Records </a>
			  <!--button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
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
    <form action="Record" method="get" >
    <h3> Records </h3><br>
  <label for="rec">Choose Technology:</label>
  <select id="rec" name="rec">
    <option value="Outstanding">Outstanding</option>
    <option value="Extraordinary">Extraordinary</option>
    <option value="Fail">Failed</option>
  </select>
  <input type="submit">
</form>
</td>
</tr>
      <!-- th scope="row">1</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
	 <tr>
      <th scope="row">3</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
	<tr>
      <th scope="row">5</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
	<tr>
      <th scope="row">6</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
	<tr>
      <th scope="row">7</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
	<tr>
      <th scope="row">8</th>
      <td>Request Title</td>
      <td style="align:right"><button type="button" class="btn btn-success" style="margin-left:150px;">Accept</button>
	  <button type="button" class="btn btn-danger">Deny</button>
	  </td>
    </tr>
  </tbody>
</table>	  
    </div>
  </div>
</div>

</div-->

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    -->
	
	
  </body>
</html>