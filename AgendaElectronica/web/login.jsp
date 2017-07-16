<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <h2 class="center-align">Inicia Sesion</h2>
        <form action="LoginController?action=login" method="POST" class="col s6 offset-s3">
            <div class="row">
                <div class="input-field col s12">
                    <i class="material-icons prefix">perm_identity</i>
                    <input type="text" name="username" id="username" required>
                    <label for="username">Username</label>
                </div>  
                <div class="input-field col s12">
                    <i class="material-icons prefix">vpn_key</i>
                    <input type="password" name="password" id="password" required>
                    <label for="password">Password</label>
                </div>
                <div class="col s12 center-align">
                    <button class="btn accent-color"><i class="material-icons left">play_arrow</i>Login</button>
                </div>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>