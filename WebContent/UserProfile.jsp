<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="shortcut icon" href="images/favicon.png" ></link>
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<link href="css/bootstrap.css" rel="stylesheet" >
	<link href="css/Default.css" rel="stylesheet" >	
	<script type="text/javascript"  src="js/jquery.js"></script>
	<script>

		$(document).ready(function()
		{
			//alert($(window).width());
			var x=(($(window).width())-1024)/2;
			//alert(x);
			$('.wrap').css("left",x+"px");
		});
		$(window).resize(function(){
			var x=(($(window).width())-1024)/2;
			//alert(x);
			$('.wrap').css("left",x+"px");
		});
	</script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
	<script type="text/javascript" src=""js/man.js"></script>

</head>
<body onload="$('#myCarousel').carousel()">
	<jsp:useBean id="coustmer" class="comm.Coustmer" scope="request"></jsp:useBean>
	<div class="wrap">
		<div class="header">
			<div style="float:left;width:150px;">
				<img src="images/logo.png"/>
			</div>		
			<div style="float:right; font-size:20px;margin-top:20px;">
						<h3> Welcome </h3>
						
						<div class="dropdown">
    					<button class="btn btn-info" type="button" data-toggle="dropdown">Login
    					<span class="caret"></span></button>
    					<ul class="dropdown-menu">
      					<li><a href="LoginSahayak.html">Sahayak</a></li>
      					<li><a href="LoginUser.html">User</a></li>
    					</ul>
  						
						<a href="#" class="btn btn-info">Logout</a>
						</div>

			</div>
			<div id="heading">
				<a href="#">Sahayak</a>
			</div>
		</div>
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<div class="container" >
				<a class="brand" href="Sahayak.html" >HOME</a>
				<a class="brand" href="reservation.html">BOOK COOLIE</a>
			
						<a class="brand" href="display.html">TRANSACTIONS</a>
				<a class="brand" href="contact.html">CONTACT</a>
				</div>
			</div>
		</div>
		<div class="span12 well pass1">
			<table style="width:100%;">
				
			<tr>
				<td><span style="font-weight:bold;font-size:25px;">Profile</span>
				<a id="editp1" style="float:right;margin-right:5%;" class="btn btn-info"> Edit Profile</a></td>
			<tr/>
			<tr>
				<td>
					<div class="span8" style="float:left;width:80%;">
					<table class="table">
					<tr><td >Id : </td> <td style="text-transform:capitalize;">  <jsp:getProperty property="id" name="coustmer"/>  </td></tr>
					<tr><td >First Name : </td> <td style="text-transform:capitalize;">  <jsp:getProperty property="fname" name="coustmer"/>  </td></tr>
					<tr><td >Last Name : </td> <td style="text-transform:capitalize;">  <jsp:getProperty property="lname" name="coustmer"/>  </td></tr>
					<tr><td>E-Mail : </td> <td>  <jsp:getProperty property="email" name="coustmer"/>  </td></tr>
					<tr><td> Gender :</td> <td style="text-transform:capitalize;"> <jsp:getProperty property="gender" name="coustmer"/>   </td></tr>
					<tr><td></td> <td></td></tr>
					</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
				<span style="width:35%;"><a href="ForgetPasswordUser.html">Change Password</a></span>
				<span class="label label-success" id="chang" style="float:right;display:none;">Password Successfully Changed &nbsp;&nbsp;&nbsp;<span>  <!-- display:none; color:#0000ff;-->
				</td>
			</tr>
		</table>
		</div>
		<div class="span12 pass2 " style="display:none;">
		<div class="span4 well">	
		<h2>Change Password</h2>	
		<br/>
		<br/>

		<form method="POST" >
			<label>Original Password</label>
			<input name ="original_password" type="password" class="input-large" ><span ></span></td><br><br> 

			<label>New Password</label>
			<input id="p1" name ="new_password" type="password" class="input-large" onkeyup="return check123()"><span id="ps" ></span></td><br><br> 
			 <!-- onkeyup=="check()" -->
			<label>Repeat Password</label>
			<input id="p2" name="confirm_new_password" class="input-large" type="password" onkeyup="checkk()">

			<br /><span id="match" style="color:#ff0000;visibility:hidden;">&nbsp;&nbsp;Password Don't Match</span><br><br> 
			<input id="sub" type="submit" disabled="disabled" class="btn btn-info" value="Change Password" 
			name="password_change">

		</form>
		</div>
		</div>
		
		
		
		<div class="span12 pass3 " style="display:none;">
		<div class="span8 well">
			<table style="width:100%;">
			<tr>
				<td><span style="font-weight:bold;font-size:25px;">Profile</span>

			<tr/>
			<tr>
				<td>
					<form method="POST" >
		
						<div class="span6" style="float:left;width:80%;">
						<table class="table">
							<tr>
								<td >First Name </td> 
								<td style="text-transform:capitalize; onblur="return name1()" >
								</td>
							</tr>
						<tr><td> Last name </td> <td><input style="text-transform:capitalize;" name="last_name" type="text" value="    "></td></tr>
						<tr><td>E-Mail  </td> <td>     </td></tr>
						<tr><td>Dob  </td> <td><input name="dob" type="date" value="   "></td></tr>
						<tr><td>Gender  </td>  <td><input style="text-transform:capitalize;" name="gender" type="text" value="    "></td></tr>
						<tr><td>Marital Status </td>  <td><input name="martial_status" type="text" value="    " style="text-transform:capitalize;"></td></tr>
						<tr><td>Mobile No.  </td>  <td><input name="mobile_no" type="text" value="   "></td></tr>
						<tr><td>Security Question  </td>  <td>    </td></tr>
						<tr><td>Answer  </td>  <td><input name="sec_ans" type="text" value="    "></td></tr>
						<tr>
							<td></td> 
							<td><input type="submit" value="Save Profile" class="btn btn-info" name="profile_change"></td>
						</tr>
						</table>
						</div>
					</form>
				</td>
			</tr>
			</table>
		</div>
		</div>
</body>
</html>