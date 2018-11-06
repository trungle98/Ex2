<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="service.CustomerServiceImpl"%>
<%@page import="model.Car"%>
<%@page import="service.InsuranceServiceImpl"%>
<%@page import="model.BaoHanh"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<%
		CustomerServiceImpl cus = new CustomerServiceImpl();
		InsuranceServiceImpl ins = new InsuranceServiceImpl();
		String optInsurance;
		int k = 1;
		ArrayList<String> listInsurance = new ArrayList<String>();
		for (Car c : cus.SearchCar(request.getAttribute("name").toString())) {
	%>
	<form action="BuyInsurance" method="post">
		<table border="1" cellpadding="1" cellspacing="1">
			<thead>
				<th>Name of Car</th>
				<th>Number Plate</th>
				<th>Brand</th>
				<th>Year of manufacture</th>
				<th>Have Insurance</th>
				<th>Feature</th>
				<th>Action</th>
				<th>Type of Insurance</th>
			</thead>
			<tbody>
				<tr>
					<td><%=c.getTenXe()%></td>
					<td><%=c.getBsk()%></td>
					<td><%=c.getHANGSANXUAT()%></td>
					<td><%=c.getNAMSANXUAT()%></td>
					<td><%=c.getMATINHNANG()%></td>
					<td><%=c.getMABH()%></td>
					<td><button class="fas fa-shopping-cart" name="buy"
							value="<%=c.getBsk()%>"></button></td>
					<%
						}
						
					%>
					<td><select name="listInsurance">
							<c:forEach items="${listInsurance}" var="listInsurance">
								<option value="${listInsurance}">${listInsurance}</option>
							</c:forEach>
					</select></td>
					<%
						
					%>


					<%
						
					%>
				</tr>

			</tbody>
		</table>
	</form>


</body>
</html>