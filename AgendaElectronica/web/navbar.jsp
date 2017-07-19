
<%@page import="com.santamariaapostol.util.SessionStringHelpers"%>
<%@page import="com.santamariaapostol.entity.Apoderado"%>
<%@page import="com.santamariaapostol.entity.Profesor"%>
<%
    Profesor profesor = null;
    Apoderado apoderado = null;
    String tipo = "";
    String nombre = "";
    if(session.getAttribute(SessionStringHelpers.USUARIO)!=null){
        if(session.getAttribute(SessionStringHelpers.TIPO_USUARIO).equals("profesor")){
            profesor = (Profesor)session.getAttribute(SessionStringHelpers.USUARIO);
            tipo = "profesor";
            nombre = profesor.getPrimerNombre() + " " + profesor.getSegundoNombre();
        }else if(session.getAttribute(SessionStringHelpers.TIPO_USUARIO).equals("apoderado")){
            apoderado = (Apoderado)session.getAttribute(SessionStringHelpers.USUARIO);
            tipo = "apoderado";
            nombre = apoderado.getPrimerNombre() + " " + apoderado.getSegundoNombre();
        }
    }
%>

<nav class="green darken-2">
    <div class="nav-wrapper container">
        <a href="index.jsp" class="left">I.E.P. Santa Maria Apostol</a>
        <a href="#!" data-activates="sidebar" class="button-collapse right"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
            <%if(profesor!=null || apoderado!= null){%>
            <li><a href="#!">Bienvenido(a) <%= nombre%> <i class="material-icons right">face</i></a></li>
            <li><a href="home">Inicio<i class="material-icons right">home</i></a></a></li>
            <li><a href="LoginController?action=logout">Salir<i class="material-icons right">exit_to_app</i></a></li>
            <%}else{%>
            <li><a href="login.jsp">Login<i class="material-icons right">perm_identity</i></a></li>
            <%}%>
        </ul>
        <ul class="side-nav" id="sidebar">
            <%if(profesor!=null || apoderado!= null){%>
            <li><a href="#!">Bienvenido(a) <%= nombre%> <i class="material-icons right">face</i></a></li>
            <li><a href="home">Inicio<i class="material-icons right">home</i></a></li>
            <li><a href="LoginController?action=logout">Salir<i class="material-icons right">exit_to_app</i></a></li>
            <%}else{%>
            <li><a href="login.jsp">Login</a><i class="material-icons right">perm_identity</i></li>
            <%}%>
        </ul>
    </div>

</nav>