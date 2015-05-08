<%@include file="/header.jspf" %>
<center>
    <c:if test="${not empty requestScope.message}">
        <h2>${requestScope.message}</h2>
    </c:if>
        <h1>All Universities</h1>
        <table role="grid">
    <thead>
        <tr>
            <th width="100">Name</th>
            <th width="200">State</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${universities}" var="uni">
            <tr>
                <td>${uni.name}</a></td>
                <td>${uni.state}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
        <h3>Add New Course</h3>
        <form action="${pageContext.request.contextPath}/uniAdmin" method="get">
            <div class="row">
                <div class="large-12 columns">
                    <label>
                        University Name:
                        <input type="text" name="uniname" id="uniname" />
                    </label>
                </div>
            </div>
            
            <div class="row">
                <div class="large-12 columns">
                    <label>
                        State:
                        <input type="text" name="unistate" id="unistate" />
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
        <form action="${pageContext.request.contextPath}/uniAdmin" method="get">
            <div class="row">
                <div class="large-12 columns">
                    <select name="deleteuni" id="deleteuni">
                    <c:forEach items="${universities}" var="uni">
                        <option>${uni.name}</option>
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