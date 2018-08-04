<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="label" var="rb"/>
<!doctype html>
<html>
<head>
    <title><fmt:message key="main.title" bundle="${rb}"/></title>
    <meta charset="utf-8"/>
</head>

<body>

<h1><fmt:message key="login.greetings" bundle="${rb}"/></h1>
<fmt:message key="main.hello" bundle="${rb}"/> ${taxiName} <fmt:message key="main.hello2" bundle="${rb}"/>





                        ${carIdErrorMessage}
<form name="loginForm" action="controller" method="post" >
<input type="hidden" name="command" value="driver_chooses_car"/>

<fmt:message key="taxi.neededCar" bundle="${ rb }"/><br/>
         <input type="text" name="desiredCarId" value="" required/><br/>


<input type="submit" value="<fmt:message key="main.submitIntoUserRoom" bundle="${rb}"/>">



</form>





</body>
</html>