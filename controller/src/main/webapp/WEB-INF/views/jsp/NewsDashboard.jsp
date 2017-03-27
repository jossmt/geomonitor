<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geopolitical Monitor</title>
</head>
<body>
<c:out value="Hello"></c:out>
<h3>News Stories</h3>
<hr size="4" color="gray"/>
<table>
    <c:forEach items="${nList}" var="newsStory">
        <tr>
            <td>Title: <c:out value="${newsStory.title}"/></td>
            <td>Description: <c:out value="${newsStory.description}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
