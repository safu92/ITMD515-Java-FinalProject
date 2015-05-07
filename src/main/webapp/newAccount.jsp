<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jspf" %>
<center>

        <form action="${pageContext.request.contextPath}/newUser" method="get">
            
            
        <div class="row">
            <div class="large-12 columns">
                <label>Username<br/><br/>
                     
                    <input type="text" placeholder="Username" id="username" name="username" />
                
                </label>
            </div>
            
            <div class="large-12 columns">
                <label>Password<br/><br/>
                     
                    <input type="password" placeholder="Password" id="password" name="password" />
                
                </label>
            </div>
            
            
            <div class="large-12 columns">
                <label>First Name<br/><br/>
                     
                    <input type="text" placeholder="First Name" id="firstName" name="firstName" />
                
                </label>
            </div>
                            <div class="large-12 columns">

                <label>Last Name<br/><br/>
                     
                    <input type="text" placeholder="Last Name" id="lastName" name="lastName" />
                </label>
            </div>
                <div class="large-12 columns">
                <label>Birth Date (yyyy-mm-dd)<br/><br/>
                    <input type="date" id="birthDate" name="birthDate" />
                    
                </label>
            </div>
                
            <div class="large-12 columns">
                <label>University<br/><br/>
                    <select name="university" id="university">
        <c:forEach items="${universities}" var="uni">
            <option>${uni.name}</option>
        </c:forEach>

                    </select>
                    
                </label>
            </div>
            
             <div class="large-12 columns">
                <label>Professor or Student ?<br/><br/>
                    <select name="userType" id="userType">
            <option>Professor</option>
            <option>Student</option>
                    </select>
                    
                </label>
            </div>
                
        </div>
        
        
        
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Create</button>
                </div>
            </div>
    </form>    

</center>
    <%@include file="/footer.jspf" %>