<%@include file="/WEB-INF/header.jspf" %>
<center>
    
        <h1>My Profile</h1>
        <table>
            <tr><td>Name: </td>
                <td><h4><c:out value="${requestScope.name}"></c:out></h4></td></tr>
            <tr><td>Birth Date:</td>
                <td><h4><c:out value="${requestScope.birthdate}"></c:out></h4></td></tr>
            <tr><td>University:</td>
                <td><h4><c:out value="${requestScope.university}"></c:out></h4></td></tr>
        </table>
</center>
 <%@include file="/WEB-INF/footer.jspf" %>