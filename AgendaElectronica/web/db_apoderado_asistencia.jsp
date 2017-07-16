<%@page import="com.santamariaapostol.entity.Asistencia"%>
<%@page import="com.santamariaapostol.util.SessionStringHelpers"%>
<%@page import="com.santamariaapostol.entity.Alumno"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    List<Alumno> alumnos = null;
    if(session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS)!= null){
        alumnos = (List<Alumno>)session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS);
    }
%>
<div class="row">
    <jsp:include page="menu.jsp"></jsp:include>
    <%if(alumnos!=null){%>
    <div class="col m9 s12">
        <ul class="tabs">
            <%for(Alumno a: alumnos){
                String nombre = a.getPrimerNombre().concat(" ").concat(a.getSegundoNombre()).concat(" ")
                .concat(a.getApellidoPaterno()).concat(" ").concat(a.getApellidoMaterno());
            %>
            <li class="tab col s4"><a href="#swipe-<%=a.getIdAlumno()%>"><%= nombre %></a></li>
            <%}%>
        </ul>
        <%for(Alumno a: alumnos){
            Asistencia hoy = a.getMatriculas().get(0).getAsistencias().get(0);
        %>
        <div id="swipe-<%=a.getIdAlumno()%>" class="col s12">
            <p>
                <h5 class="center-align">El dia de hoy el estado de la asistencia es:</h5>
            </p>
            <p>
                <h5 class="center-align"><%= hoy.getEstado() %></h5>               
            </p>
        </div>
        <%}%>
    </div>
    <%}%>
</div>

<jsp:include page="footer.jsp"></jsp:include>