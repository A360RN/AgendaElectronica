<jsp:include page="header.jsp"></jsp:include>

<div class="row">
    <jsp:include page="menu.jsp"></jsp:include>

    <h2>Nuevo Comunicado</h2>
    <form action="ComunicadoController?action=nuevo" method="POST" class="col m9 s12">
        <div class="row">
            <div class="input-field col s12">
                <input type="text" id="titulo" name="titulo" class="form-input">
                <label for="titulo">Titulo</label>
            </div>
            <div class="input-field col s12">
                <textarea class="materialize-textarea" name="cuerpo" id="cuerpo"></textarea>
                <label for="cuerpo">Cuerpo</label>
            </div>
            <div class="col s12 m9 input-field center-align">
                <button class="btn waves-effect green">Enviar Comunicado</button>
                <a href="db_profesor_comunicado.jsp" class="btn waves-effect waves-light red darken-1">Cancelar</a>
            </div>
        </div>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>