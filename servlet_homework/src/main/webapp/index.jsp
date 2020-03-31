<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>"Good shopping" online store</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>WELCOME to our store!</h1>

<form>
    <button type="button" onClick="location.href='register.jsp'">Sign up</button>
    <button type="button" onClick="location.href='login.jsp'">Enter</button><br>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
