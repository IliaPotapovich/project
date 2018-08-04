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


<c:forEach var="carList" items="${list}">
<br/>

${carList.carId}
<br/>
${carList.model}
<br/>
${carList.ownerId}
<br/>
${carList.yearOFManufacture}
<br/>



</c:forEach>





</body>
</html>