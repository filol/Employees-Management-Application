<%-- 
    Document   : login
    Created on : 11 déc. 2018, 08:28:43
    Author     : namileto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@include file="_bootstrapcss.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
    <div class="container">
            <h1 class="text-center">Login page</h1>
    </div>
        <% if (request.getAttribute("error") != null) {%>
        erreur de connexion
        <% }%>
        
        <div class="container">
        <div class="col-sm-5 mx-auto jumbotron">
        <form action="" method="post">
            <div class="form-group">
                <label for="name">Username</label>
                <input name="username" type="text" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
        </div>

    </body>
    <%@include file="_bootstrapjs.jsp" %>


</html>