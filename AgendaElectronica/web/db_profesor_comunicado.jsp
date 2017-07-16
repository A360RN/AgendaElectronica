<%@page import="java.util.List"%>
<%@page import="com.santamariaapostol.entity.Comunicado"%>
<%@page import="com.santamariaapostol.util.SessionStringHelpers"%>
<jsp:include page="header.jsp"></jsp:include>

<%
    List<Comunicado> listaComunicados = null;
    if(session.getAttribute(SessionStringHelpers.LISTA_COMUNICADOS)!= null){
        listaComunicados = (List<Comunicado>)session.getAttribute(SessionStringHelpers.LISTA_COMUNICADOS);
    }
%>

<div class="row">
    <jsp:include page="menu.jsp"></jsp:include>

    <%if(listaComunicados!=null){ %>
    <div class="col m9 s12">
        <h2>Ultimos Comunicados Enviados</h2>
        <%for(Comunicado c: listaComunicados){ %>
        <ul class="collapsible" data-collapsible="accordion">
            <li>
                <div class="collapsible-header"><%= c.getTitulo() %></div>
                <div class="collapsible-body"><span><%= c.getCuerpo() %></span></div>
            </li>
        </ul>
        <% }%>
        <a href="nuevo_comunicado.jsp" class="btn waves-effect waves-light grey darken-1">Nuevo Comunicado</a>
    </div>
    <% } else {%>
        <h2>No existen comunicados recientes</h2>
    <% }%>
</div>

<jsp:include page="footer.jsp"></jsp:include>