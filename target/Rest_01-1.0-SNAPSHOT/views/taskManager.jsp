<%--
  Created by IntelliJ IDEA.
  User: -rom-
  Date: 27.05.2017
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TaskManager</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <!-- STYLESHEET CSS FILES -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
</head>


<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                    class="icon icon-bar"></span> <span class="icon icon-bar"></span> <span
                    class="icon icon-bar"></span></button>
            <a href="#" class="navbar-brand"><img class="small-image-logo" src="images/logo.png"></a></div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav ">


                <li class="li-header"><a href="home" class="smoothScroll">Home</a></li>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <li class="li-header"><a href="taskManager" class="smoothScroll">TaskManager</a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="li-header"><a href="loginpage" class="smoothScroll">Log in</a></li>
                    <li class="li-header"><a href="registration" class="smoothScroll">Sign in</a></li>
                </sec:authorize>

                <li class="li-header"><a class="smoothScroll">
                    <sec:authorize access="isAuthenticated()">
                        <form:form action="logout" method="post">
                            <a href="#">
                                <button>logout</button>
                            </a>
                        </form:form>

                    </sec:authorize></a></li>

                <input class="btn btn-default" type="submit" value="Submit">


            </ul>
        </div>
    </div>
</div>

<section id="blog-section">
    <div class="container">
        <div class="row">
            <div class="blog-title">
                <h1 class="task-title-admin">Task manager</h1>
            </div>
            <div class="create-task">
                <p class="create-task-text">Create task</p>
                <form:form modelAttribute="taskManager" action="saveTask" method="post">
                    <form:input path="title" value="Title" type="text"/>
                    <form:input path="text" value="Text" type="text"/>
                    <form:input path="autor" value="Autor" type="hiddem"/>

                    <input type="submit" value="Create">
                </form:form>
            </div>


            <div class="all-settings">
                <c:forEach var="taskManager" items="${taskManagers}">
                    <div class="task-message">
                        <p>${taskManager.title}</p>
                        <p class="text-message">${taskManager.text}</p>
                        <p class="username-text">${taskManager.autor}</p>
                    </div>


                    <div class="settings-for-task">
                        <p><a href="updateTaskManager/${taskManager.id}">update</a></p> /
                        <p><a href="deleteTask/${taskManager.id}"> delete</a></p>
                    </div>
                </c:forEach>
            </div>


        </div>
    </div>
</section>


<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
