<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<link rel="stylesheet" href="css/registration.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">

<html>
<head>
	<title>HOME</title>
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



<div class="login-form">
    <h1 class="title-login">Sign in</h1>
    <form:form class="form-inline" modelAttribute="user" action="registration" method="post">

        <div class="form-group">

            <label for="name">${usernameException}</label>
            <form:input path="name" type="text" placeholder="name" class="form-control" required="required" />

        </div>
        <div class="form-group">

            <label for="email">${emailException}</label>
            <form:input path="email" type="email" class="form-control"  placeholder="email" required="required"/>

        </div>
        <div class="form-group">

            <label for="password">${passwordException}</label>
            <form:input path="password" type="password" class="form-control" placeholder="password" required="required"/>
        </div>
        <button type="submit" class="btn btn-default">Sign in</button>
    </form:form>
</div>



<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</body>