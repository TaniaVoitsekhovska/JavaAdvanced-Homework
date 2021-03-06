<%--
  Created by IntelliJ IDEA.
  User: Byby
  Date: 3/23/2020
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cabinet</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="d-flex flex-column ">
    <div class="d-flex justify-content-center">
        <p>Create product</p>
    </div>
    <div class="d-flex justify-content-center">
        <form class="createProduct d-flex flex-column" >
            <div class="form-group">
                <input type="text" class="form-control productName"
                       placeholder="Name">
            </div>

            <div class="form-group">
                <input type="text" class="form-control productDescription"
                       placeholder="Description">
            </div>

            <div class="form-group">
                <input type="number" class="form-control productPrice"
                       placeholder="Price">
            </div>

            <button class="btn btn-primary createProduct">Submit</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/header.js"></script>
<script src="js/createProduct.js"></script>
<script src="js/logout.js"></script>

</body>
</html>
