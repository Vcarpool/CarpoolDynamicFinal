<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="com.sun.prism.Image"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.vcarpool.model.Car, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>
<%
Object obj=session.getAttribute("bookCars");
Car cars=(Car)obj;
%>
</head>
<body>
<form action="ConfirmControlServlet" method="post">
	<table border="1" align="center">
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
	<label>Seats Selected</label></td><td><input type="text" readonly="readonly"  name="bSeatsAvailable" value=<%=session.getAttribute("seats"),cars.getSeatsAvailable()%> /></td></tr>
	<tr><td>
	<label>Fare to be paid</label></td><td><input type="text" readonly="readonly"  id="fare" value="40" /></td></tr>
	<tr align="center"> <td align="center" colspan="2">
	<input type="submit" value="Confirm" /></td></tr>
	</table>
	</form>
</body>
</html>
