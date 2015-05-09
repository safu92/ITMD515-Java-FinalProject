<%@include file="/WEB-INF/header.jspf" %>
<center>
    
    <c:if test="${requestScope.usertype == 1}">
        <h1>My Courses</h1>
    </c:if>
    
        <c:if test="${requestScope.usertype == 2}">
        <h1>Courses I teach:</h1>
        </c:if>
        <table role="grid">
    <thead>
        <tr>
            <th width="100">Course ID</th>
            <th width="200">Course Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.courseId}</a></td>
                <td>${course.name}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</center>
 <%@include file="/WEB-INF/footer.jspf" %>