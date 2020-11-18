<%--
  Created by IntelliJ IDEA.
  User: emygdio
  Date: 15/11/2020
  Time: 07:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Portfolio Registration</title>
</head>
<body>
<h4>Complete and submit the form to create your own portfolio.</h4>
<s:form action="Register">
    <s:textfield name="user.username" label="Username"/>
    <s:password name="user.password" label="Password"/>
    <s:textfield name="user.portfolioName" label="Enter a name for your porfolio"/>
    <s:submit/>
</s:form>
</body>
</html>
