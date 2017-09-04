<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

    <!-- core js -->
    <script src="<c:url value="/resources/js/core.js"/>"></script>

    <!-- core jquery ui -->
    <script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>

<div class="panel-group" id="accordion">

        <c:forEach items="${nList}" var="newsStory" varStatus="theCount">


                <div class="panel-heading" onclick="findByName(${theCount.index})">

                    <h3 class="title" id="section${theCount.index}">
                        <c:out value="${newsStory.title}"/> <span class="logoWrapper">
                    <img id="img" src="${newsStory.urlToImage}"
                        alt='icon'></span>
                    </h3>

                    </div>
                        <div id="collapse${theCount.index}" class="panel-collapse collapse">
                        <div class="panel-body">
                    </div>
                </div>
             </c:forEach>
    </div>
</tiles:putAttribute>
</tiles:insertDefinition>
