<%-- 
    Document   : listmaniacs
    Created on : 2017.04.28., 16:43:36
    Author     : hallgato
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%--<%@ page import="com.mitro.stub.LotteryManiacStub" %>--%>
<%@ page import="com.mitro.entities.LotteryManiac" %>
<%@ page import="com.mitro.entities.Tip" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% List<LotteryManiac> maniacs = (List<LotteryManiac>) request.getAttribute("maniacs"); %>
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
                        <p><c:forEach items="${maniac.tips}" var = "tip">
                            - tip numbers: <c:out value="${tip.numbersOfTip}"/><br>
                            - tip date: <c:out value="${tip.timeOfTip}"/>                           
                            </c:forEach></p>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
    </body>
</html>
