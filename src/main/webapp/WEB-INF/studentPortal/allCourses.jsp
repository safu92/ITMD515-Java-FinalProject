<%@include file="/WEB-INF/header.jspf" %>
<center>
    
        <h1>All Available Courses</h1>
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