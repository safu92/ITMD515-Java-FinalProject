<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>
<center>

    <c:if test="${not empty requestScope.meetupcreated}">
        <h2>${requestScope.meetupcreated}</h2>
        <h2><a href="/myMeetups">View My Meetups</a></h2>
    </c:if>
        <form action="${pageContext.request.contextPath}/addMeetup" method="get">
            
            
        <div class="row">
            <div class="large-12 columns">
                <label>Date (yyyy-mm-dd)<br/><br/>
                     
                    <input type="text" placeholder="Date" id="date" name="date" />
                
                </label>
            </div>
            
            <div class="large-12 columns">
                <label>Place<br/><br/>
                     
                    <input type="text" placeholder="Place" id="place" name="place" />
                
                </label>
            </div>
            
            
            <div class="large-12 columns">
                <label>Topic<br/><br/>
                     
                    <input type="text" placeholder="Topic" id="topic" name="topic" />
                
                </label>
            </div>
        
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Create</button>
                </div>
            </div>
    </form>    

</center>
    <%@include file="/WEB-INF/footer.jspf" %>