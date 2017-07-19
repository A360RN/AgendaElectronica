<%-- 
    Document   : flash-message
    Created on : 02-jul-2017, 1:01:12
    Author     : alonsorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container">
    <div class="col s12">
        <h3 id="message" class="center-align secondary-text-color">
            <%if (session.getAttribute("message") != null) {%>
            <%= session.getAttribute("message")%> 
            <%}
                session.removeAttribute("message");
            %>
        </h3>
    </div>
</div>


