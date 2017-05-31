<%--
  Created by IntelliJ IDEA.
  User: -rom-
  Date: 30.05.2017
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags"	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>TaskManager</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <!-- STYLESHEET CSS FILES -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
</head>

<body>
<h1>Update Task</h1>
<form:form action="/updateTaskManager" method="post" >
    <input type="hidden" name="id" value="${taskManager.id}">
    <input name="title" value="${taskManager.title}" type="text"/>
    <input name="text" value="${taskManager.text}" type="text"/>
    <input name="autor" value="${taskManager.autor}" type="text"/>
    <input type="submit" value="Update">
</form:form>




</body>
</html>
