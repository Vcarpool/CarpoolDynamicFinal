<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VCarPool - login</title>
<link href="css/styles.css" rel="stylesheet"
	type="text/css">
<script src="js/validate.js" type="text/javascript">
	
</script>
<%
Object obj=request.getAttribute("message");
String message="";
if(obj!=null)
	message=(String)obj;
%>
</head>
<body>
<form action="LoginControlServlet" method="post">
<div class="box">
<h1>Sign in - VCarPool</h1>
<h3 style="color:red;"><%=message%></h3>
<input type="text" name="userid" id="userid" required="required"
				placeholder="enter user id" class="email" />
				<input type="password" name="password" id="password" required="required" placeholder="enter your password"
				 class="email" />
				 <input type="submit" value="Sign in" class="btn" onclick="return regValidate(password,password1);">
				 <a href="register.jsp"><div id="btn2">Sign Up</div></a> <!-- End Btn2 -->

</div>

</form>

</body>
</html>


