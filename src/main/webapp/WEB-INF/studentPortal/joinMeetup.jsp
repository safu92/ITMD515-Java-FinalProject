<%@include file="/WEB-INF/header.jspf" %>
<center>
    
    <h1>Join Meetup</h1><br><br>
    <c:if test="${not empty requestScope.message}">
        <h2>${requestScope.message}</h2>
    </c:if>
        <form action="${pageContext.request.contextPath}/jointhisMeetup" method="get">
        <div class="row">
            <div class="large-12 columns">
                <label>Upcoming Meetup:</label>
                <select id="meetup" name="meetup">
        <c:forEach items="${meetups}" var="meetup">
            <option>${meetup.topic}</option>
        </c:forEach>
                </select>
            </div>
        </div>
    
    <div class="row">
            <div class="large-12 columns">
            <button class="button">Add</button>
            </div>
        </div>
        </form>

</center>
 <%@include file="/WEB-INF/footer.jspf" %>