<%-- 
    Document   : listmaniacs
    Created on : 2017.04.28., 16:43:36
    Author     : hallgato
--%>

<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.mitro.facade.stub.GuitarOwnerStub" %>
<%@ page import="com.mitro.facade.stub.GuitarStub" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Set<GuitarOwnerStub> maniacs = (Set<GuitarOwnerStub>) request.getAttribute("maniacs"); %>
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
                    <td><p><h4>Name: <c:out value="${maniac.username}"/>: <c:out value="${maniac.email}"/></h4></p></td>
	        </tr>
	    </c:forEach>
	</table>
    </body>
</html>
