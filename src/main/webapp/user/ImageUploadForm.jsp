<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Rodrigo.Simas
  Date: 21/11/2020
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Portfolio Image</title>
</head>
<body>
<h4>Complete and submit the form to create your own portfolio.</h4>
<s:form action="ImageUpload" name="/user/secure" method="post" enctype="multipart/form-data">
    <s:file name="pic" label="Picture"/>
    <s:submit/>
</s:form>
</body>
</html>
