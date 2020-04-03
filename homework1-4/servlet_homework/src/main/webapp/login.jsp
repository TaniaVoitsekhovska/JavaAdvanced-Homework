
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Authorization form</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>Authorization form</h1>
<form action="logging" method="post">
    <input name="login" type="text" placeholder="Login"><br><br>
    <input name="password" type="password" placeholder="Password"><br><br>
    <input type="submit" value="Enter">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
