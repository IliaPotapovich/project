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

<form name="loginForm" action="controller" method="post" >
    <input type="hidden" name="command" value="login"/>
                    ${logoutMessage}<br/>
                    ${regSuccess}<br/>
    <fmt:message key="login.login" bundle="${ rb }"/><br/>
         <input type="text" name="login" value="" required/><br/>

    <fmt:message key="login.password" bundle="${ rb }"/><br/>
         <input type="password" name="password" value="" required/><br/>


    <input type="submit" value=<fmt:message key="login.submit" bundle="${ rb }"/>>

</form>



<form action="jsp/registerpage.jsp">
    <input type="submit" value=<fmt:message key="login.registerSubmit" bundle="${rb}"/>>
</form>

<br/>
    <br/>
    <br/>




<form name="Language" action="controller" method="post" >
    <input type="hidden" name="command" value="set_language"/>


<fmt:message key="login.languageMessage" bundle="${ rb }"/>
<br/>
<fmt:message key="login.ruLanguage" bundle="${ rb }"/> <input type="radio" name="lang" value="ru_RU"checked><br/>
<fmt:message key="login.enLanguage" bundle="${ rb }"/> <input type="radio" name="lang" value="en_US"><br/>
<fmt:message key="login.beLanguage" bundle="${ rb }"/> <input type="radio" name="lang" value="be_BY"><br/>




<input type="submit" value=<fmt:message key="login.langSubmit" bundle="${ rb }"/>><br/>

    <br/>
    <br/>
    <br/>
${errorLoginPassMessage}
        <br/>
    ${wrongAction}
        <br/>
    ${nullPage}
        <br/>
</form>






<a href="jsp/technicaloffice.jsp"><fmt:message key="login.toAdminRoom" bundle="${ rb }"/></a>



<br/>
    <br/>
    <br/>
</body>
</html>