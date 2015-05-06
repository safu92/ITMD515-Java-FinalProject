<%@include file="/WEB-INF/header.jspf" %>
<center>
    
        <h1>Courses I teach:</h1>
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
                <td><a href="${pageContext.request.contextPath}/courseDetails?id=${course.courseId}">${course.courseId}</a></td>
                <td>${course.name}</td>
                <td>${course.name}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</center>
 <%@include file="/WEB-INF/footer.jspf" %>