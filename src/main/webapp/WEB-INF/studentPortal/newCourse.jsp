<%@include file="/WEB-INF/header.jspf" %>
<center>
    
    <h1>Register New Course</h1><br><br>
    <c:if test="${not empty requestScope.message}">
        <h2>${requestScope.message}</h2>
    </c:if>
        <form action="${pageContext.request.contextPath}/addCourse" method="get">
        <div class="row">
            <div class="large-12 columns">
                <label>Select Course:</label>
                <select id="course" name="course">
        <c:forEach items="${courses}" var="course">
            <option>${course.name}</option>
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