<%@page isELIgnored="false" session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vcarpool.model.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link href="css/styles.css" rel="stylesheet" type="text/css">
<script src="js/validate.js" type="text/javascript"> </script>

<%
String testString="";
	if(session.getAttribute("userid")==null) {
		response.sendRedirect("login.jsp");
		
		
	} else {
		Object obj=session.getAttribute("userid");
		testString=(String)obj;
	}
	
	
%>

<meta charset="ISO-8859-1">

<title>Home - <%=session.getAttribute("userid")   %></title>

</head>

<body id="img">
 <h1 style="color:silver;">Hello <%=session.getAttribute("userid")   %> welcome To Vcarpool</h1>
<div class="topnav">
  <a href="#home" class="active">Logo</a>
  <!-- Navigation links (hidden by default) -->
 
  <div id="myLinks">
    <a href="home.jsp">Home</a>
    <a href="index.jsp">select a ride </a>
    <a href="logout.jsp">Logout</a>
    
  </div>
  <!-- "Hamburger menu" / "Bar icon" to toggle the navigation links -->
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>

</body>

</html>