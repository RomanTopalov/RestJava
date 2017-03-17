<%--
  Created by IntelliJ IDEA.
  User: -rom-
  Date: 14.02.2017
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>



<script src="/js/jquery-3.1.1.min.js"></script>




<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
<input type="hidden" name="csrf_image"
       value="${_csrf.parameterName}" />



<div class="wrapper" style="text-align: center">
    <header>
        <div id="error"></div>
        <input  id="imageHuman" type="file" name="image" ><br><br>
        <input type="text" id="nameHuman" placeholder="name of human">
        <button id="save">save</button>
    </header>
    <div class="all">



    </div>
</div>




<script src="/js/human.js"></script>
