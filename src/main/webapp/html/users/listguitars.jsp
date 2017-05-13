<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <%@ page import="java.util.Set" %>   --%>
<%@ page import="java.util.List" %>
<%@ page import="com.mitro.facade.stub.GuitarStub" %>
<%@ page import="com.mitro.facade.stub.GuitarBrandStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% List<GuitarStub> guitars = (List<GuitarStub>)request.getAttribute("guitars"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.: List Of All Guitars :.</title>
</head>
<body>
	<h3>Guitars Details</h3>
	<hr size="1" color="gray"/>
	<table>
	    <c:forEach items="${guitars}" var="guitar">
	        <tr>
	            <td><h4><c:out value="${guitar.guitarbrand}"/>: <c:out value="${guitar.guitarType}"/></h4></td>
	        </tr>  
	        <tr>
	            <td>
                        serial: <c:out value="${guitar.serialNumber}"/><br>
                        color: <c:out value="${guitar.color}"/><br>
                        vintage: <c:out value="${guitar.vintage}"/><br>
                        price: <c:out value="${guitar.price}"/> Ft<br>
                        owner: <c:out value="${guitar.owner.username}"/>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>