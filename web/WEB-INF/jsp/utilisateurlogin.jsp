<%-- 
    Document   : employelogin
    Created on : 18 juin 2023, 20:56:19
    Author     : P14A_77_Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evaluation June</title>
        <meta name="description" content="" />
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/source/assets/michael/img/avatars/love.ico" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/michael/css/loginadmin.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/michael/vendor/css/core.css" class="template-customizer-core-css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/michael/vendor/css/theme-default.css" class="template-customizer-theme-css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/michael/css/demo.css" />
        <script src="${pageContext.request.contextPath}/source/assets/michael/vendor/js/helpers.js"></script>
        <script src="${pageContext.request.contextPath}/source/assets/michael/js/config.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/michael/css/fade.css" />
    </head>
    <body>
        <div class="container">
            <div class="form-container sign-in-container" >
                <form action="<%=request.getContextPath()%>/functionlogUtilisateur" class="formfade"> 
                    <h1>Connecter en tant qu'Utilisateur</h1>
                    <span>utiliser votre compte</span>
                    <br><br><br>
                    <input class="form-control" type="name" placeholder="Name" name="email" required/>
                    <input class="form-control" type="password" placeholder="Password" name="mdp" required/>
                    <% if (request.getAttribute("erreur") != null) {%> <p style="color: #ff6600"><%out.print(request.getAttribute("erreur"));%></p><% }%>
                    <button type="submit" class="btn btn-primary m-2">Connecter</button>
                </form>
            </div>
        </div>
    </body>
</html>
