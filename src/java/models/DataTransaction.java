/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Constants;

/**
 *
 * @author namileto
 */
public class DataTransaction {

    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    private String dbUrl;
    private String user;
    private String pwd;

    ArrayList<UserBean> userList;
    ArrayList<EmployeeBean> employeeList;

    public Connection getConnection() {
        dbUrl = Constants.dbUrl;
        user = Constants.user;
        pwd = Constants.pwd;

        try {
            dbConn = DriverManager.getConnection(dbUrl, user, pwd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return dbConn;
    }

    public Statement getStatement(Connection dbConn) {
        try {
            stmt = dbConn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return stmt;
    }

    public ResultSet getResultSet(Statement stmt, String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public ArrayList getAllCredentials(ResultSet rs) {
        userList = new ArrayList<UserBean>();

        try {
            while (rs.next()) {
                UserBean credential = new UserBean();
                credential.setUsername(rs.getString("username"));
                credential.setPassword(rs.getString("password"));
                userList.add(credential);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public boolean checkCredentials(String login, String password) {
        String query = "SELECT * FROM USERS";
        userList = this.getAllCredentials(this.getResultSet(this.getStatement(this.getConnection()), query));
        for (UserBean user : userList) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList getAllEmployees(ResultSet rs) {
        employeeList = new ArrayList<EmployeeBean>();
        String query = "SELECT * FROM EMPLOYEES";
        this.getResultSet(this.getStatement().getConnection(), query);
        // FINIR ICI CONTINUER  !!!!
        try {
            while (rs.next()) {
                EmployeeBean emp = new EmployeeBean();
                emp.setFirstName(rs.getString("FIRSTNAME"));
                emp.setName(rs.getString("NAME"));
                emp.setHomePhone("TELHOME");
                emp.setMobilePhone("TELMOB");
                emp.setWorkingPhone("TELPRO");
                emp.setAddress("ADRESS");
                emp.setPostalCode("POSTALCODE");
                emp.setCity("CITY");
                emp.setEmail("EMAIL");
                employeeList.add(emp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employeeList;
    }
    
    public ArrayList getEmployees() {
        String query = "SELECT * FROM EMPLOYEES";
        employeeList = this.getAllEmployees(this.getResultSet(this.getStatement(this.getConnection()), query));
        return employeeList;
    }

}
