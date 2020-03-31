<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>User's personal account</title>
</head>

<body>
<h1>${userFirstName} ${userLastName}, You are a successful ${userAction} to online-store!</h1>
<a href="${pageContext.request.contextPath}/index.jsp">To the main</a>
</body>

</html>
