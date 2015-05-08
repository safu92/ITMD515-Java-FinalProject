<%@include file="/WEB-INF/header.jspf" %>
<center>
    
        <h1>All Ongoing & Upcoming Meetups</h1>
        <table role="grid">
    <thead>
        <tr>
            <th width="100">Meetup Date</th>
            <th width="200">Place</th>
            <th width="200">Discussion Topic</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${meetups}" var="meetup">
            <tr>
                <td>${meetup.date}</td>
                <td>${meetup.place}</td>
                <td>${meetup.topic}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</center>
 <%@include file="/WEB-INF/footer.jspf" %>