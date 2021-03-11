<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Techqui</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.0.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link rel="stylesheet" href="studhome.css">
    <link rel="stylesheet" type="text/css"   href="PassStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<!-- Vertical navbar -->
<div class="vertical-nav bg-white" id="sidebar">
  <div class="py-4 px-3 mb-4 bg-light">
    <div class="media d-flex align-items-center">
    
      <!-- img loading="lazy" src="images/emiway.jpg" alt="..." width="80" height="80" class="mr-3 rounded-circle img-thumbnail shadow-sm"-->
      <div class="media-body">
        <h4 class="m-0">Hello</h4>
        <p class="font-weight-normal text-muted mb-0"></p>
      </div>
    </div>
  </div>

  <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">Dashboard</p>

  <ul class="nav flex-column bg-white mb-0">
    <li class="nav-item">
      <a href="StartQuiz.jsp" class="nav-link text-dark bg-light">
                <!-- i class="fa fa-th-large mr-3 text-primary fa-fw"></i-->
                <i class="fas fa-file-alt"></i>
                New Quiz
            </a>
    </li>
    <li class="nav-item">
      <a href="Review" class="nav-link text-dark bg-light">
                <!-- i class="fa fa-address-card mr-3 text-primary fa-fw"></i-->
                <i class="fas fa-eye"></i>
                Review Quiz 
            </a>
    </li>
    <li class="nav-item">
      <a href="Leaderboard" class="nav-link text-dark bg-light">
                <!-- i class="fa fa-cubes mr-3 text-primary fa-fw"></i-->
                <i class="fas fa-trophy"></i>
                Report
            </a>
    </li>
    <!-- li class="nav-item">
      <a href="#" class="nav-link text-dark">
                <i class="fa fa-picture-o mr-3 text-primary fa-fw"></i>
                Gallery
            </a>
    </li-->
  </ul>

  <p class="text-gray font-weight-bold text-uppercase px-3 small py-4 mb-0">my Account</p>

  <ul class="nav flex-column bg-white mb-0">
    <li class="nav-item">
      <a href="studProfile" class="nav-link text-dark bg-light">
                <!-- i class="fa fa-area-chart mr-3 text-primary fa-fw"></i-->
                <i class="fas fa-id-card"></i>
                Profile 
            </a>
    </li>
    <li class="nav-item">
      <a href="studPass.jsp" class="nav-link text-dark bg-light">
                <!-- i class="fa fa-bar-chart mr-3 text-primary fa-fw"></i-->
                <i class="fas fa-key"></i>
                Change Password 
            </a>
    </li>
    <li class="nav-item">
      <a href="Logout" class="nav-link text-dark bg-light">
                <!-- i class="fa fa-pie-chart mr-3 text-primary fa-fw"></i-->
                <i class="fas fa-lock"></i>
                Logout 
            </a>
    </li>
    <!-- li class="nav-item">
      <a href="#" class="nav-link text-dark">
                <i class="fa fa-line-chart mr-3 text-primary fa-fw"></i>
               LogOut
            </a>
    </li-->
  </ul>
</div>
<!-- End vertical navbar -->


<!-- Page content holder -->
<div class="page-content p-5" id="content">
  <!-- Toggle button -->
  <img src="logo2.jpg" class="logo" alt="logo" height="80" width="100" style="opacity: 0.9;  filter: grayscale(40%); margin-bottom:10px" ><br>
  <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-8 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold"></small></button>

  <!-- Demo content -->
  <h2 class="display-4 text-white"></h2>
  <p class="lead text-white mb-0"></p> 
  <div class="separator"></div>
  <div class="row text-white">
    <div class="col-lg-7">
      <!-- p class="lead"></p>
      <p class="lead">
      </p> 
      <p class="lead">
      </p>
      <p class="lead"></p>
      <p class="lead">
      </p>
    </div>
    <div class="col-lg-5">
      <p class="lead"></p>
      <p class="lead">
      </p>
      <p class="lead"></p>
      <p class="lead">
      </p>
    </div>
  </div-->
<form method=get   action=StPass >
<center><h1>Password Change</h1></center><br>
<center><input type="password" name="old" placeholder="Old Password" /></center><br>
<center><b><input type="password" name="password" onkeyup='check();' id="password" placeholder="New Password" required="required" minlength="8" maxlength="12" />
</b></center><br>
<center><b><input type="password" name="confirm_password" onkeyup='check();' id="confirm_password" placeholder="Confirm Password" required="required" />
</b></center><br>
<!-- div class="registrationFormAlert" style="color:green;" id="CheckPasswordMatch"-->
<script>
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}
</script>
<b><input type=submit name=sub value=Change /></b></center><br>
</form>
</div>
</div>
</div>
<!-- End demo content -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="studhome.js"></script>
</body>
</html>

</body>
</html>