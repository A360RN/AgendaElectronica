<%@page import="com.santamariaapostol.entity.Comunicado"%>
<%@page import="java.util.List"%>
<%@page import="com.santamariaapostol.entity.Alumno"%>
<%@page import="com.santamariaapostol.util.SessionStringHelpers"%>
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
    <h2 class="center-align">Ultimos Comunicados Recibidos</h2>
    <div class="col m9 s12">
        <ul class="tabs">
        <%for(Alumno a: alumnos){
            String nombre = a.getPrimerNombre().concat(" ").concat(a.getSegundoNombre()).concat(" ")
                    .concat(a.getApellidoPaterno()).concat(" ").concat(a.getApellidoMaterno());
        %>
            <li class="tab col s4"><a href="#swipe-<%=a.getIdAlumno()%>"><%= nombre%></a></li>
        <%}%>
        </ul>
        <%for(Alumno a: alumnos){
            List<Comunicado> comunicadosPorAlumno = a.getMatriculas().get(0).getSeccion().getComunicados();
        %>
        <div id="swipe-<%=a.getIdAlumno()%>" class="col s12">
            <ul class="collapsible" data-collapsible="accordion">
                <%for(Comunicado comunicado: comunicadosPorAlumno){%>
                <li>
                    <div class="collapsible-header"><%= comunicado.getTitulo()%></div>
                    <div class="collapsible-body"><span><%= comunicado.getCuerpo() %></span></div>
                </li>
                <%}%>
            </ul>
        </div>
        <%}%>
    </div>
    <%}else {%>
    <h2>No hay comunicados recientes</h2>
    <%}%>
</div>

<jsp:include page="footer.jsp"></jsp:include>