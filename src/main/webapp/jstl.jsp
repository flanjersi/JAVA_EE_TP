<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>JSTL TEST</title>
</head>
<body>
    <p>
        <c:choose>
            <c:when test="${param.name == null or empty param.name}">
                <c:out value="Hello unknown people"/>
            </c:when>
            <c:otherwise>
                <c:out value="Hello ${param.name}"/>
            </c:otherwise>
        </c:choose>
    </p>
</body>
</html>