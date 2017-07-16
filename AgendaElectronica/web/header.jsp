<%@page import="com.santamariaapostol.entity.Apoderado"%>
<%@page import="com.santamariaapostol.entity.Profesor"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Santa Maria Apostol</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/style.css">
</head>

<body>
    <nav class="green darken-2">
        <div class="nav-wrapper container">
            <a href="#!" class="left">I.E.P. Santa Maria Apostol</a>
            <a href="#!" data-activates="sidebar" class="button-collapse right"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="#!">Bienvenido Usuario</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="#!">Salir</a></li>
            </ul>
            <ul class="side-nav" id="sidebar">
                <li><a href="#!">Bienvenido Usuario</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="#!">Salir</a></li>
            </ul>
        </div>

    </nav>