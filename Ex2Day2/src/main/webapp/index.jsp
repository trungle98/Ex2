<%@page import="service.CustomerServiceImpl"%>
<%@page import="model.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="BuyInsurance" method="get">
	<table border="1" cellpadding="1" cellspacing="1">
	
		<thead>
			<th>Name of Car</th>
			<th>Number Plate</th>
			<th>Brand</th>
			<th>Year of manufacture</th>
			<th>Have Insurance</th>
			<th>Feature</th>
			<th>Action</th>

		</thead>
		<tbody>
			<%
				CustomerServiceImpl cus = new CustomerServiceImpl();
				for (Car c : cus.getAllCar()) {
			%>
			<tr>
				<td><%=c.getTenXe()%></td>
				<td><%=c.getBsk()%></td>
				<td><%=c.getHANGSANXUAT()%></td>
				<td><%=c.getNAMSANXUAT()%></td>
				<td><%=c.getMATINHNANG()%></td>
				<td><%=c.getMABH()%></td>
				<td><button class="fas fa-shopping-cart" name="buy" value="<%=c.getBsk()%>"></button></td>
			</tr>

			<%
				}
			%>
		</tbody>

	</table>
	       </form>
	<form action="AddCar" method="post">
		<table>
			<tr>
				<td>Bsk</td>
				<td><input type="text" name="txtTen">
				<td>
			</tr>

		</table>
		<button type="submit" name="AddCar" value="AddCar">AddCar</button>
	</form>
</body>
</html>