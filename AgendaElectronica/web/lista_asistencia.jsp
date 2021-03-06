<%@page import="com.santamariaapostol.entity.Asistencia"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.santamariaapostol.util.SessionStringHelpers"%>
<%@page import="com.santamariaapostol.entity.Alumno"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    List<Alumno> alumnos = null;
    if(session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS)!= null){
        alumnos = (List<Alumno>)session.getAttribute(SessionStringHelpers.LISTA_ALUMNOS);
    }
    LocalDateTime now = LocalDateTime.now();
    String date = now.getDayOfMonth()+ "/"+ now.getMonthValue()+ "/"+ now.getYear();
%>

<div class="row">
    <jsp:include page="menu.jsp"></jsp:include>

<h3 class="center-align">Asistencia <%=date%></h3>

<%if(alumnos != null){ %>
<form action="AsistenciaController?action=guardar_lista" method="POST" class="col m9 s12">
    <!-- Cambiar id, name -->
    <%for(Alumno a : alumnos){
        String name = a.getPrimerNombre().concat(" ").concat(a.getSegundoNombre())
                .concat(" ").concat(a.getApellidoPaterno()).concat(" ")
                .concat(a.getApellidoMaterno());
        Asistencia asistenciaHoy = a.getMatriculas().get(0).getAsistencias().get(0);
    %>
    
    <h6><%="Alumno: " + name %></h6>
    
    <div class="row">      
        <!-- asistio -->
        <%if(asistenciaHoy.getEstado().equals(SessionStringHelpers.ASISTENCIA_ASISTIO)){%>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>A" value="ASISTIO" checked>
            <label for="<%=a.getIdAlumno()%>A">Asistio</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>B" value="TARDANZA">
            <label for="<%=a.getIdAlumno()%>B">Tardanza</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>C" value="INASISTENCIA">
            <label for="<%=a.getIdAlumno()%>C">Inasistencia</label>
        </div>
        
        <!-- inasistencia -->
        <%}else if(asistenciaHoy.getEstado().equals(SessionStringHelpers.ASISTENCIA_INASISTENCIA)){%>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>A" value="ASISTIO">
            <label for="<%=a.getIdAlumno()%>A">Asistio</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>B" value="TARDANZA">
            <label for="<%=a.getIdAlumno()%>B">Tardanza</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>C" value="INASISTENCIA" checked>
            <label for="<%=a.getIdAlumno()%>C">Inasistencia</label>
        </div>
        
        <!-- tardanza -->
        <%}else if(asistenciaHoy.getEstado().equals(SessionStringHelpers.ASISTENCIA_TARDANZA)){%>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>A" value="ASISTIO">
            <label for="<%=a.getIdAlumno()%>A">Asistio</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>B" value="TARDANZA" checked>
            <label for="<%=a.getIdAlumno()%>B">Tardanza</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>C" value="INASISTENCIA">
            <label for="<%=a.getIdAlumno()%>C">Inasistencia</label>
        </div>
        
        <%}else {%>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>A" value="ASISTIO">
            <label for="<%=a.getIdAlumno()%>A">Asistio</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>B" value="TARDANZA">
            <label for="<%=a.getIdAlumno()%>B">Tardanza</label>
        </div>
        <div class="input-field inline col s3">
            <input type="radio" name="btn<%=a.getIdAlumno()%>" id="<%=a.getIdAlumno()%>C" value="INASISTENCIA">
            <label for="<%=a.getIdAlumno()%>C">Inasistencia</label>
        </div> 
        <%}%>
    </div>
    <%}%>
    <!-- Fin -->
    <div class="col s12 m9 input-field center-align">
        <button class="btn waves-effect">Guardar Asistencia</button>
    </div>
</form>
<%}%>
</div>
<jsp:include page="footer.jsp"></jsp:include>