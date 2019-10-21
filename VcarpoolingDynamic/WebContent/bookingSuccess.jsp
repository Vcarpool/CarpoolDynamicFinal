<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vcarpool.model.Car" %>
<!DOCTYPE html>
<html>
<head>
<%
Object obj=session.getAttribute("bookCars");
Car cars=(Car)obj;
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Success</title>
</head>
<body>

<table border="1" align="center">
	<h6 style="color: green;font-family: sans-serif; font-size: large;">Booking successfully Done!</h6>
	<th colspan="2">Booking Details</th>
	<tr><td>
	<label>Car Number</label></td><td><input type="text" readonly="readonly"  name="bCarNo" value=<%=cars.getRegNo() %> /></td></tr>
	<tr><td>
	<label>Car Name</label></td><td><input type="text" readonly="readonly"  id= "bCarName" value=<%=cars.getCarName() %> /></td></tr>
	<tr><td>
	<label>Source</label></td><td><input type="text" readonly="readonly"  id ="bCarSource" value=<%=cars.getSource() %> /></td></tr>
	<tr><td>	
	<label>Destination</label></td><td><input type="text" readonly="readonly"  id ="bCarDest" value=<%=cars.getDestination() %> /></td></tr>
	<tr><td>
	<label>Departure Time</label></td><td><input type="text" readonly="readonly" id="bCarTime" value=<%=cars.getDeptTime() %> /></td></tr>
	<tr><td>
	<label>Seats Selected</label></td><td><input type="text" readonly="readonly"  name="bSeatsAvailable" value=<%=session.getAttribute("seats")%> /></td></tr>
	<tr><td>
	<label>Fare to be paid</label></td><td><input type="text" readonly="readonly"  id="fare" value="40" /></td></tr>
	<tr><td>
	<label>status</label></td><td bgcolor="green" style="color:black">Active</td></tr>
	</table>
	<button style="margin-left: 10px;" type="submit" value="go back" onclick="home.html">
</body>
</html>


