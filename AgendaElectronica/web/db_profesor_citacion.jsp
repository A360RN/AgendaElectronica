<%@page import="com.santamariaapostol.util.SessionStringHelpers"%>
<%@page import="java.util.List"%>
<%@page import="com.santamariaapostol.entity.Alumno"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    List<Alumno> alumnos = null;
    if (session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS) != null) {
        alumnos = (List<Alumno>) session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS);
    }
%>

<div class="row">
    <jsp:include page="menu.jsp"></jsp:include>

    
    <%if (alumnos != null) {%>
    <div class="col s12 m9">
    <%for (Alumno a : alumnos) {
                String nombre = a.getPrimerNombre().concat(" ").concat(a.getSegundoNombre()).concat(" ").
                        concat(a.getApellidoPaterno()).concat(" ").concat(a.getApellidoMaterno());
    %>
    <div class="row">
        <h6><%="Alumno: " + nombre%></h6>
        <form action="CitacionController?action=identificar_alumno" method="POST">
            <input type="hidden" value="<%= a.getIdAlumno() %>" name="idAlumno">
            <button class="btn waves-effect waves-light">Nueva Citacion</button>
        </form>
    </div>
    <%}%>
    </div>
    
    <%}%>
</div>

<jsp:include page="footer.jsp"></jsp:include>