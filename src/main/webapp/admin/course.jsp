<%@include file="/header.jspf" %>
<center>
    <c:if test="${not empty requestScope.message}">
        <h2>${requestScope.message}</h2>
    </c:if>
        <h1>All Courses</h1>
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
        <h3>Add New Course</h3>
        <form action="${pageContext.request.contextPath}/courseAdmin" method="get">
            <div class="row">
                <div class="large-12 columns">
                    <label>
                        Course ID:
                        <input type="text" name="courseId" id="courseId" />
                    </label>
                </div>
            </div>
            
            <div class="row">
                <div class="large-12 columns">
                    <label>
                        Course Name:
                        <input type="text" name="courseName" id="courseName" />
                    </label>
                </div>
            </div>
            
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Add</button>
                </div>
            </div>
        </form>
            
             <h3>Delete Course</h3>
        <form action="${pageContext.request.contextPath}/courseAdmin" method="get">
            <div class="row">
                <div class="large-12 columns">
                    <select name="deletecourse" id="deletecourse">
                    <c:forEach items="${courses}" var="course">
                        <option>${course.name}</option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            
                       
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Delete</button>
                </div>
            </div>
        </form>

</center>
 <%@include file="/footer.jspf" %>