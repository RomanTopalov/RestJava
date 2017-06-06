<%--
  Created by IntelliJ IDEA.
  User: -rom-
  Date: 30.05.2017
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TaskManager</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">

    <!-- STYLESHEET CSS FILES -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
</head>

<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                        class="icon icon-bar"></span> <span class="icon icon-bar"></span> <span
                        class="icon icon-bar"></span></button>
                <a href="#" class="navbar-brand"><img class="small-image-logo" src="/images/logo.png"></a></div>
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

    <div class="login-form">
        <h1 class="title-login">Update Task</h1>
        <form:form action="/updateTaskManager" method="post">
            <div class="form-group"><input type="hidden" name="id" value="${taskManager.id}"></div>
            <div class="form-group">
                <input name="title" value="${taskManager.title}" type="text"/>
            </div>
            <div class="form-group">
                <input name="text" value="${taskManager.text}" type="text"/>
            </div>
            <div class="form-group">
                <input name="autor" value="${taskManager.autor}" type="text"/>
            </div>
            <button type="submit" class="btn btn-default update-button">Update</button>
        </form:form>
    </div>

    <%--<h1 class="updateTask-header">Update Task</h1>
    <div class="form-input-update"
    <form:form action="/updateTaskManager" method="post" >
        <input type="hidden" name="id" value="${taskManager.id}">
        <input name="title" value="${taskManager.title}" type="text"/>
        <input name="text" value="${taskManager.text}" type="text"/>
        <input name="autor" value="${taskManager.autor}" type="text"/>
        <input type="submit" value="Update">
    </form:form>
    </div>--%>


    <script src="/js/jquery-3.1.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    </body>
</html>
