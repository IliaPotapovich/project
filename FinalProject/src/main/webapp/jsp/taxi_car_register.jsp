<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="label" var="rb"/>
<html>
<head>
    <title><fmt:message key="login.title" bundle="${rb}"/></title>
    <meta charset="utf-8"/>
</head>

<body>

                                ${registrError}
<form name="regForm" action="${request.getContextPath}/project/controller" method="post" >
    <input type="hidden" name="command" value="taxi_car_registration"/>


         <fmt:message key="registr.carModel" bundle="${ rb }"/><br/>
                 <input type="text" name="regCarModel" value="" required/><br/><br/>

         <fmt:message key="registr.ownerId" bundle="${ rb }"/><br/>
                  <input type="text" name="regOwnerId" value="" required/><br/><br/>

         <fmt:message key="registr.yearOfManuf" bundle="${ rb }"/><br/>
                  <input type="text" name="regYearOfManuf" value="" required/><br/><br/>



<input type="submit" value=<fmt:message key="registr.submit" bundle="${ rb }"/>>

</form>








</body>
</html>
