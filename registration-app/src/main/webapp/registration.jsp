<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<div style="margin: 20px">

<form action="reg.do" method="post">
		UserName: <input type="text" name="username" required="required"> <br>
		Password: <input type="password" name="password" required="required"> <br>
		ConfirmPassword: <input type="password" name="confirmpassword" required="required">
		<br> MobileNo: <input type="text" name="mobilenumber" required="required"> <br>
		Age: <input type="text" name="age" required="required"> <br> <input
			type="submit" value="Register">
	</form>
	
	<form action="log.do">
	<input type="submit" value="login">
	</form>

	<form action="del.do" style="margin-top: 50px" method="post">
		UserName: <input type="text" name="username" required="required"> <br> <input
			type="submit" value="Delete">
	</form>

	<form action="update.do" style="margin-top: 50px" method="post">
		Enter username to update: <input type="text" name="username" required="required"> <br>
		MobileNo: <input type="text" name="mobilenumber" required="required"> Age: <input
			type="text" name="age"> <br> <input type="submit"
			value="Update">
	</form>
</div>
	


</body>
</html>