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
<form name="regDriverForm" action="${request.getContextPath}/project/controller" method="post" >
    <input type="hidden" name="command" value="taxi_driver_registration"/>



         <fmt:message key="registr.name" bundle="${ rb }"/><br/>
                  <input type="text" name="regDriverName" value="" required/><br/><br/>

         <fmt:message key="registr.password" bundle="${ rb }"/><br/>
                  <input type="text" name="regDriverPassword" value="" required/><br/><br/>

         <fmt:message key="registr.experience" bundle="${ rb }"/><br/>
                  <input type="text" name="regDriverExp" value="" required/><br/><br/>



<input type="submit" value=<fmt:message key="registr.submit" bundle="${ rb }"/>>

</form>








</body>
</html>
