# Employees-Management-Application
An Employees Management Application (verison 1.0)

## 1) Import the project in Netbeans
- Clone this project on you computer
- Open NetBeans (you need Glassfish Server and JDBC Derby in Netbeans)
- Click "File" -> "Open Project" and select the projet ("Employees-Management-Application")

## 2) Create the database
- Go to the "service" tab in Netbeans
- In "Database"  Create a Database named "PROJET" (with user "adm" / "adm")
- In this database, execute the 2 SQL scripts located in "web/WEB-INF" (Employees.sql and Users.sql)

## 3) Run the application
- Right click on the projet -> select properties and in the "run" section, make sure that "/EmployeesManagementApplication" is the context 
path (and not "/Employees-Management-Application" or you will get a 404)
- Now you can run the application from Netbeans
- the application shoud be available at "http://localhost:8080/EmployeesManagementApplication/"
- Enjoy (the default crendentials are "admin" / "admin" for the login page) !

