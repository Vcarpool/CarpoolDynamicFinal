<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VCarPooling - welcome</title>


<link href="css/styles.css" rel="stylesheet" type="text/css">
<script src="validate.js" type="text/javascript"></script>

</head>
<body>

	<form method="post" action="FindCarServlet">
		<div class="box">
			<h1>VCarPool - Pool Your Car</h1>
			
			<input type="text" name="source" required="required" id="source"
				placeholder="enter source" class="email" /> 
				<input id="destination"
				type="text" name="destination" required="required"
				placeholder="enter your destination" class="email" />
				<input type="time" name="time" required="required" id="time"  class="email" placeholder="enter departure time"/>
				 <input type="number" name="seats" required="required" id="seats" min="1" max="5"	placeholder="enter no of seats" class="email" /> 
				 
				 <center><input type="submit" value="Find Cars" class="btn"></center>
			<!-- End Btn -->


			<!-- End Btn2 -->

		</div>
		<!-- End Box -->

	</form>
	


</body>
</html>