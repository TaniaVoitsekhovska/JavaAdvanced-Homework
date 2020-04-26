<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Lesson-18</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/Participants">All participants</a></li>
            <li><a href="/Participants/new">new Participant</a></li>
        </ul>
    </div>
</nav>


<div class="container">
    <c:choose>
        <c:when test="${mode == 'PARTICIPANT_VIEW'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Level</th>
                    <th>Primary Skill</th>
                    <th>Cover</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="participant" items="${participants}">
                    <tr>
                        <td>${participant.id}</td>
                        <td>${participant.name}</td>
                        <td>${participant.email}</td>
                        <td>${participant.level}</td>
                        <td>${participant.primarySkill}</td>
                        <td>
                            <img src="/Participants/participant-cover-files/download/${participant.coverId}" width="50px">
                        </td>
                        <td><a href="/Participants/update?id=${participant.id}">edit</a></td>
                        <td><a href="/Participants/delete?id=${participant.id}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode == 'PARTICIPANT_EDIT' || mode == 'PARTICIPANT_CREATE'}">
            <form action="${mode == 'PARTICIPANT_EDIT' ? "/Participants/save": "/Participants/create"}" method="POST">
                <c:choose>
                    <c:when test="${mode == 'PARTICIPANT_EDIT'}">
                        <img src="/Participants/participant-cover-files/download/${participant.coverId}" width="200px"
                             id="participant-cover">
                        <input type="hidden" value="${participant.id}" class="form-control" id="id" name="id">
                    </c:when>
                    <c:when test="${mode == 'PARTICIPANT_CREATE'}">
                        <img src="https://omegamma.com.au/wp-content/uploads/2017/04/default-image.jpg"
                             id="participant-cover" width="200px">
                    </c:when>
                </c:choose>

                <div class="form-group">
                    <label for="cover-file">Participant cover</label>
                    <input id="cover-file" type="file" />
                </div>
                <input type="hidden" value=""
                       class="form-control"
                       id="cover-id" name="coverId">
                    <label for="name">Name:</label> <input type="text"
                                                           class="form-control" id="name" name="name"
                                                           value="${participant.name}">



                <div class="form-group">
                    <label for="email">Email:</label> <input type="text"
                                                             class="form-control" id="email" name="email"
                                                             value="${participant.email}">
                </div>
                <div class="form-group">
                    <label for="level">Level(choose level):</label> <select class="form-control" id="level" name="level"
                                                                            value="${participant.level}">
                    <option>L1</option>
                    <option>L2</option>
                    <option>L3</option>
                    <option>L4</option>
                    <option>L5</option>
                </select>
                </div>
                <div class="form-group">
                    <label for="primarySkill">Primary Skill:</label> <input type="text"
                                                                            class="form-control" id="primarySkill"
                                                                            name="primarySkill"
                                                                            value="${participant.primarySkill}">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </c:when>

    </c:choose>
    <script src="${pageContext.request.contextPath}/js/participant.js"></script>

</div>
</body>
</html>