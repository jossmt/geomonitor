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

        <link rel="stylesheet" href="resources/core/css/hello.css" type="text/css"/>

<style>
    .title{
        font-size: 25px;
        color: black;
        font-family: Georgia;
    }
</style>
</head>
<body>
<h3>News Stories</h3>
<hr size="4" color="gray"/>

<div class="panel-group" id="accordion">

       <div class="panel panel-default">
        <c:forEach items="${nList}" var="newsStory" varStatus="theCount">


                <div class="panel-heading>
                    <h4 class="panel-title">
                            <a id = "title${theCount.index}" class = "title" data-toggle="collapse"
                            data-parent="#accordion" href="#collapse${theCount.index}" class = "collapsed">

                                <c:out value="${newsStory.title}"/></a>
                    </h4>
                    </div>
                        <div id="collapse${theCount.index}" class="panel-collapse collapse">
                        <div class="panel-body">
                    </div>
                </div>
             </c:forEach>
         </div>
</div>
</body>
</html>
