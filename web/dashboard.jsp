<%-- 
    Document   : dashboard
    Created on : 14 déc. 2018, 10:08:32
    Author     : namileto
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.EmployeeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@include file="_bootstrapcss.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Dashboard</h1>
            <% if (request.getAttribute("success-added") != null) {%>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Employee added to the database 
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <% }%>
            <br /><br />    
        </div>

        <div class="container">
            <div class="container">
                <div class="row font-weight-bold">
                    <div class="col-1">Sél</div>
                    <div class="col-1">Name</div>
                    <div class="col-1">First Name</div>
                    <div class="col-1">Home Phone</div>
                    <div class="col-1">Mobile Phone</div>
                    <div class="col-1">Work Phone</div>
                    <div class="col-2">Address</div>
                    <div class="col-1">Postal code</div>
                    <div class="col-1">City</div>
                    <div class="col-2">Email</div>
                </div>
                <br />

                <div class="listing" style=" overflow-y: scroll; overflow-x: hidden; max-height: 500px;">
                    <%
                        ArrayList<EmployeeBean> employeesList = (ArrayList<EmployeeBean>) request.getAttribute("employeesList");
                        for (EmployeeBean employee : employeesList) {
                    %>
                    <div class="row">
                        <div class="col-1">
                            <div>
                                <input type="radio" id="<% out.println(employee.getEmail());  %>" name="selection" checked>
                            </div>
                        </div>
                        <div class="col-1"><% out.println(employee.getName());  %></div>
                        <div class="col-1"><% out.println(employee.getFirstName());  %></div>
                        <div class="col-1"><% out.println(employee.getHomePhone());  %></div>
                        <div class="col-1"><% out.println(employee.getMobilePhone());  %></div>
                        <div class="col-1"><% out.println(employee.getWorkingPhone());  %></div>
                        <div class="col-2"><% out.println(employee.getAddress());  %></div>
                        <div class="col-1"><% out.println(employee.getPostalCode());  %></div>
                        <div class="col-1"><% out.println(employee.getCity());  %></div>
                        <div class="col-2"><% out.println(employee.getEmail());  %></div>
                    </div>
                    <%}%>
                </div>

                <div class="bottom-buttons" style="margin-top: 10px;">
                    <a href="add"><button type="button" class="btn btn-primary">Add</button></a>
                    <a href="details"><button type="button" class="btn btn-secondary">Details</button></a>
                    <button type="button" class="btn btn-danger">Delete</button> 
                </div>
            </div>
        </div>
    </body>
    <%@include file="_bootstrapjs.jsp" %>
</html>
