<%-- 
    Document   : details
    Created on : 19 déc. 2018, 07:47:48
    Author     : namileto
--%>

<%@page import="models.EmployeeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@include file="_bootstrapcss.jsp" %>
        <%@include file="_topbar.jsp" %>
        <% EmployeeBean employee = (EmployeeBean)request.getAttribute("currentEmployee"); %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".go-back").click(function () {
                    parent.history.back();
                });
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add page</title>
    </head>
    <body>
    <div class="container">
            <h1 class="text-center">Details of <% out.println(employee.getFirstName() + " " + employee.getName()); %></h1>
    </div>
             
        <div class="container">
        
        <div class="col-sm-5 mx-auto jumbotron">
            
        <form action="details" method="post">
            <div class="form-group">
                <label for="name">Firstname</label>
                <input value="<% out.println(employee.getFirstName()); %>" name="firstname" type="text" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Enter Firstname">
            </div>
            
            <div class="form-group">
                <label for="name">Name</label>
                <input name="name" value="<% out.println(employee.getName()); %>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
            </div>
            
            <div class="form-group">
                <label for="telhome">Tel Home</label>
                <input name="telhome" value="<% out.println(employee.getHomePhone()); %>" type="text" class="form-control" id="telhome" aria-describedby="emailHelp" placeholder="Enter telhome">
            </div>
            
            
            <div class="form-group">
                <label for="telmob">Tel Mob</label>
                <input name="telmob" value="<% out.println(employee.getMobilePhone()); %>" type="text" class="form-control" id="telmob" aria-describedby="emailHelp" placeholder="Enter telhome">
            </div>
            
            <div class="form-group">
                <label for="telpro">Tel Pro</label>
                <input name="telpro" value="<% out.println(employee.getWorkingPhone()); %>" type="text" class="form-control" id="telpro" aria-describedby="emailHelp" placeholder="Enter telpro">
            </div>
            
            <div class="form-group">
                <label for="adress">Adress</label>
                <input name="adress" value="<% out.println(employee.getAddress()); %>" type="text" class="form-control" id="adress" aria-describedby="emailHelp" placeholder="Enter adress">
            </div>
            
            <div class="form-group">
                <label for="postalcode">Postal Code</label>
                <input name="postalcode" value="<% out.println(employee.getPostalCode()); %>" type="text" class="form-control" id="postalcode" aria-describedby="emailHelp" placeholder="Enter postalcode">
            </div>
            
            <div class="form-group">
                <label for="city">city</label>
                <input name="city" value="<% out.println(employee.getCity()); %>" type="text" class="form-control" id="city" aria-describedby="emailHelp" placeholder="Enter city">
            </div>
            
            <div class="form-group">
                <label for="email">email</label>
                <input name="email" value="<% out.println(employee.getEmail()); %>" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" readonly>
            </div>
            
            
            <button type="submit" class="btn btn-primary">Save</button>
            <button  class="btn btn-light go-back">Cancel</button>
        </form>
        </div>
        </div>

    </body>
    <%@include file="_bootstrapjs.jsp" %>


</html>
