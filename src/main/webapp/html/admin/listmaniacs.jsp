<%-- 
    Document   : listmaniacs
    Created on : 2017.04.28., 16:43:36
    Author     : hallgato
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mitro.facade.stub.GuitarOwnerStub" %>
<%@ page import="com.mitro.facade.stub.GuitarStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% List<GuitarOwnerStub> maniacs = (List<GuitarOwnerStub>) request.getAttribute("maniacs"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Maniacs</title>
    </head>
    <body>
        <h2>Here are the maniacs:</h2>
        <table>
	    <c:forEach items="${maniacs}" var="maniac">
	        <tr>
                    <td><p><h4>Name: <c:out value="${maniac.maniacName}"/>:</h4></p></td>
	        </tr>  
	        <tr>
	            <td>                         
                        <p><c:forEach items="${maniac.guitars}" var = "guitar">
                            guitar brand: <c:out value="${guitar.guitarbrand}"/><br>
                            guitar type: <c:out value="${guitar.guitartype}"/><br>
                            serial: <c:out value="${guitar.guitarSerialNumber}"/><br>
                            color: <c:out value="${guitar.guitarColor}"/><br>
                            vintage: <c:out value="${guitar.guitarVintage}"/><br>
                            price: <c:out value="${guitar.guitarPrice}"/> Ft                          
                        </c:forEach></p>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
    </body>
</html>
