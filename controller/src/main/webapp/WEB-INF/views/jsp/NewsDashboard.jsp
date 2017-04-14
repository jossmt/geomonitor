<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geopolitical Monitor</title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h3>News Stories</h3>
<hr size="4" color="gray"/>

<div class="panel-group" id="accordion">
        <c:forEach items="${nList}" var="newsStory">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                <c:out value="${newsStory.title}"/></a>
                    </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <div class="panel-body"><c:out value="${newsStory.rawBody}" escapeXml="false"/>
                    </div>
                </div>
            </div>
        </c:forEach>
</div>

</body>
</html>
