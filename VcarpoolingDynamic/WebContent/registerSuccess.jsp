<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VCarpool-SignIn</title>
<link href="css/styles.css" rel="stylesheet"
	type="text/css">
<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
<form method="post" action="LoginContolServlet"onsubmit="store()">
		<div class="box">
			<h2 style="color:green">Registration sucessful, your id is <%=session.getAttribute("userid") %> now Login</h2>
			<h1>Login to VCarPool</h1>

			<input type="text" name="userid" required="required" id="userid" placeholder="enter user ID" class="email" /> <input id="password"
				type="password" name="password" required="required"	placeholder="enter your password" class="email" /> <input
				type="submit" value="Sign in" class="btn">
			<!-- End Btn -->

			<a href="register.jsp"><div id="btn2">Sign Up</div></a>
			<!-- End Btn2 -->

		</div>
		<!-- End Box -->

	</form>

	<p>
		Forgot your password? <u style="color: #f1c40f;">Click Here!</u>
	</p>

</body>
</html>


