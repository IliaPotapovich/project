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



                                ${driverErrorMessage}
<form name="findDriverById" action="${request.getContextPath}/project/controller" method="post">
 <input type="hidden" name="command" value="find_driver_by_id"/>

<fmt:message key="find.driverById" bundle="${ rb }"/><br/>

<input type="text" name="taxiDriverId" value="" required/><br/>

    <input type="submit" value=<fmt:message key="find.submit" bundle="${rb}"/>>
</form>
<br/>
<br/>
<br/>


                                ${driverNameErrorMessage}
<form name="findDriverByName" action="${request.getContextPath}/project/controller" method="post">
 <input type="hidden" name="command" value="find_driver_by_name"/>

<fmt:message key="find.driverByName" bundle="${ rb }"/><br/>

<input type="text" name="taxiDriverName" value="" required/><br/>

    <input type="submit" value=<fmt:message key="find.submit" bundle="${rb}"/>>
</form>
<br/>
<br/>
<br/>



                                  ${carIdErrorMessage}
<form name="findCarById" action="${request.getContextPath}/project/controller" method="post">
 <input type="hidden" name="command" value="find_car_by_id"/>

<fmt:message key="find.carById" bundle="${ rb }"/><br/>

<input type="text" name="taxiCarId" value="" required/><br/>

    <input type="submit" value=<fmt:message key="find.submit" bundle="${rb}"/>>
</form>
<br/>
<br/>
<br/>



                                ${carOwnerIdErrorMessage}
<form name="findCarByOwnerId" action="${request.getContextPath}/project/controller" method="post">
 <input type="hidden" name="command" value="find_car_by_owner_id"/>

<fmt:message key="find.carsByOwnerId" bundle="${ rb }"/><br/>

<input type="text" name="taxiOwnerId" value="" required/><br/>

    <input type="submit" value=<fmt:message key="find.submit" bundle="${rb}"/>>
</form>
<br/>
<br/>
<br/>










                                ${regTaxiSuccess}
<form action="${request.getContextPath}/project/jsp/taxi_driver_register.jsp">
<fmt:message key="taxiregister.driverRegister" bundle="${ rb }"/><br/>

    <input type="submit" value=<fmt:message key="login.registerSubmit" bundle="${rb}"/>>
</form>
<br/>
<br/>
<br/>



                                ${regCarSuccess}
<form action="${request.getContextPath}/project/jsp/taxi_car_register.jsp">
<fmt:message key="taxiregister.carRegister" bundle="${ rb }"/><br/>

    <input type="submit" value=<fmt:message key="login.registerSubmit" bundle="${rb}"/>>
</form>











</body>
</html>
