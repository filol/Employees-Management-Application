<%-- 
    Document   : _topbar
    Created on : 19 déc. 2018, 10:10:55
    Author     : namileto
--%>

<%@page import="models.UserBean"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="dashboard">Emloyee Management Software</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

    
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <% UserBean user = (UserBean)session.getAttribute("user"); %>
                Connected as '<%= user.getUsername() %>' &nbsp; &nbsp;
                <a href="logout"><i class="fas fa-sign-out-alt"></i></a>
            </li>
        </ul>
    </div>
</nav>