<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: emygdio
  Date: 15/11/2020
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
<h5>Congratulations! You have created </h5>
<h3> The <s:property value="portfolioName"/> Portfolio</h3>
<p>You may now begin working with <a href="<s:url namespace="/user/secure" action='AdminPortfolio'/>">your portfolio</a> </p>
</body>
</html>
