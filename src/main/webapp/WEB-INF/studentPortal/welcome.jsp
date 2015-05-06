<%@include file="/WEB-INF/header.jspf" %>
        
        <h1>Hello World!</h1>
        <c:out value="${requestScope.name}"></c:out>
        <c:out value="${requestScope.birthdate}"></c:out>
        <c:out value="${requestScope.university}"></c:out>
        
 <%@include file="/WEB-INF/footer.jspf" %>