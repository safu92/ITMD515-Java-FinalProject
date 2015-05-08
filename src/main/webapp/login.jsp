<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jspf" %>
<center>
    <br><br><br>
    <% if (request.isUserInRole("student")) { %>
    <h2>Welcome <% out.println(request.getRemoteUser()); %></h2>
    <a href="${pageContext.request.contextPath}/studentPortal"><button class="button">My Account</button></a>
    <a href="${pageContext.request.contextPath}/myCourses"><button class="button">My Courses</button></a>
    <a href="${pageContext.request.contextPath}/myMeetups"><button class="button">My Meetups</button></a>
    <a href="${pageContext.request.contextPath}/studentPortal"><button class="button">More</button></a>
    <a href="${pageContext.request.contextPath}/logout"><button class="button">Logout</button></a>
    <% } %>
    
    <% if (!request.isUserInRole("student")) { %>

    <h2>Login </h2>
        <div class="large-3 large-centered columns">
            <div class="login-box">
                <div class="row">
                    <div class="large-12 columns">
                        <form action="j_security_check" method="post">
                            <div class="row">
                                <div class="large-12 columns">
                    <input type="text" id="j_username" name="j_username" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="large-12 columns">
                                    <input type="password" id="j_password" name="j_password" />                                
                                </div>
                            </div>
                            <div class="row">
                                <div class="large-12 large-centered columns">
<button class="button">Log In</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <% } %>
   
</center>
    <%@include file="/footer.jspf" %>