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

                            ${errorTechnLoginPassMessage}
<form name="loginForm" action="${request.getContextPath}/project/controller" method="post" >
    <input type="hidden" name="command" value="technical_login"/>

    <fmt:message key="login.login" bundle="${ rb }"/><br/>
         <input type="text" name="techLogin" value="" required/><br/>

    <fmt:message key="login.password" bundle="${ rb }"/><br/>
         <input type="password" name="techPassword" value="" required/><br/>


    <input type="submit" value=<fmt:message key="login.submit" bundle="${ rb }"/>>
</form>
<br/>






<br/>
    <br/>
    <br/>
</body>
</html>