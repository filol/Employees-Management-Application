<%-- 
    Document   : add
    Created on : 18 déc. 2018, 08:25:08
    Author     : namileto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@include file="_bootstrapcss.jsp" %>
        <%@include file="_topbar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add page</title>
    </head>
    <body>
    <div class="container">
            <h1 class="text-center">Add a new Employee</h1>
    </div>
        
        
        
        <div class="container">
        
        <div class="col-sm-5 mx-auto jumbotron">
            
        <form action="add" method="post">
            <div class="form-group">
                <label for="name">Firstname</label>
                <input name="firstname" type="text" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Enter Firstname">
            </div>
            
            <div class="form-group">
                <label for="name">Name</label>
                <input name="name" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
            </div>
            
            <div class="form-group">
                <label for="telhome">Tel Home</label>
                <input name="telhome" type="text" class="form-control" id="telhome" aria-describedby="emailHelp" placeholder="Enter telhome">
            </div>
            
            
            <div class="form-group">
                <label for="telmob">Tel Mob</label>
                <input name="telmob" type="text" class="form-control" id="telmob" aria-describedby="emailHelp" placeholder="Enter telhome">
            </div>
            
            <div class="form-group">
                <label for="telpro">Tel Pro</label>
                <input name="telpro" type="text" class="form-control" id="telpro" aria-describedby="emailHelp" placeholder="Enter telpro">
            </div>
            
            <div class="form-group">
                <label for="adress">Adress</label>
                <input name="adress" type="text" class="form-control" id="adress" aria-describedby="emailHelp" placeholder="Enter adress">
            </div>
            
            <div class="form-group">
                <label for="postalcode">Postal Code</label>
                <input name="postalcode" type="text" class="form-control" id="postalcode" aria-describedby="emailHelp" placeholder="Enter postalcode">
            </div>
            
            <div class="form-group">
                <label for="city">city</label>
                <input name="city" type="text" class="form-control" id="city" aria-describedby="emailHelp" placeholder="Enter city">
            </div>
            
            <div class="form-group">
                <label for="email">email</label>
                <input name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
            </div>
            
            
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
        </div>

    </body>
    <%@include file="_bootstrapjs.jsp" %>


</html>
