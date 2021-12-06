<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<style>
		.column {
			width: 100px;
		}
		.row {
			border: 1px solid black;
		}
		tr:nth-child(even) td {
	  		background-color: rgb(240,240,240);
		}
	
		tr:nth-child(odd) td {
			background-color: rgb(230,230,230);
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<td class="column">Manufacturer</td>
			<td class="column">Name</td>
			<td style="width: 50px;">Ram</td>
			<td style="width: 50px;">Storage</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr class="row">
				
				<td><c:out value="${item.getManufacturer()}"/></td>
				<td><c:out value="${item.getName()}"/></td>
				<td><c:out value="${item.getRam()}"/></td>
				<td><c:out value="${item.getStorage()}"/></td>	
				<td>
					<form action="/Store/delete" method="post">
						<input type="hidden" name="manufacturer" value="${item.getManufacturer()}">
						<input type="hidden" name="name" value="${item.getName()}">
						<input type="hidden" name="ram" value="${item.getRam()}">
						<input type="hidden" name="storage" value="${item.getStorage()}">
						<input type="submit" value="delete"/>
					</form>
				</td>
				<td>
					<form action="/Store/edit" method="get">
						<input type="hidden" name="id" value="${item.getId()}">
						<input type="submit" value="edit"/>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="/Store/add" method="get">
		<input type="submit" value="add new"/>
	</form>
</body>
</html>