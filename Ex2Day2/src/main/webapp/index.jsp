<%@page import="service.CustomerServiceImpl"%>
<%@page import="model.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="1" cellspacing="1">
		<thead>
		    <th>TenXe</th>
			<th>Bsk</th>
			<th>HANGSANXUAT</th>
			<th>NAMSANXUAT</th>
			<th>BH</th>
			<th>TINHNANG</th>
			
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
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
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