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


${driver_id}
<br/>
${driver_name}
<br/>
${driver_experience}
<br/>
${driver_status}

<br/><br/><br/>

    ${car_id}<br/>
    ${model}<br/>
    ${owner_id}<br/>
    ${year}<br/>





</body>
</html>