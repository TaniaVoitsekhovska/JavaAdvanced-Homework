
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Registration form</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>Форма регистрации</h1>
<form action="registering" method="post">
    <input name="firstName" type="text" placeholder="FirstName"><br><br>
    <input name="lastName" type="text" placeholder="LastName"><br><br>
    <input name="email" type="text" placeholder="Login"><br><br>
    <input name="password" type="password" placeholder="Password"><br><br>
    <input name="accessLevel" type="radio" id="user" value="user" checked>
    <label for="user">User</label><br>
    <input name="accessLevel" type="radio" id="admin" value="admin">
    <label for="admin">Administrator</label><br><br>
    <input type="submit" value="Send">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
