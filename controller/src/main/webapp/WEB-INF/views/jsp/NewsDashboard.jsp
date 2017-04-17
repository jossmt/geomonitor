<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

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

                            <c:out value="${newsStory.rawBody}" escapeXml="false"/>
                        <div class="panel-body">
                    </div>
                </div>
             </c:forEach>
         </div>
    </div>
</tiles:putAttribute>
</tiles:insertDefinition>
