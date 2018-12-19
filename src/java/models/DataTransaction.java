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

    public ArrayList getAllEmployees() {
        employeeList = new ArrayList<EmployeeBean>();

        String query = "SELECT * FROM EMPLOYEES";
        ResultSet rs = this.getResultSet(this.getStatement(this.getConnection()), query);

        try {
            while (rs.next()) {
                EmployeeBean emp = new EmployeeBean();
                emp.setFirstName(rs.getString("FIRSTNAME"));
                emp.setName(rs.getString("NAME"));
                emp.setHomePhone(rs.getString("TELHOME"));
                emp.setMobilePhone(rs.getString("TELMOB"));
                emp.setWorkingPhone(rs.getString("TELPRO"));
                emp.setAddress(rs.getString("ADRESS"));
                emp.setPostalCode(rs.getString("POSTALCODE"));
                emp.setCity(rs.getString("CITY"));
                emp.setEmail(rs.getString("EMAIL"));
                employeeList.add(emp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employeeList;
    }

    public void addEmployee(EmployeeBean emp) {

        String query = "insert into EMPLOYEES (FIRSTNAME, NAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            dbConn = this.getConnection();
            PreparedStatement st = dbConn.prepareStatement(query);
            st.setString(1, emp.getFirstName());
            st.setString(2, emp.getName());
            st.setString(3, emp.getHomePhone());
            st.setString(4, emp.getMobilePhone());
            st.setString(5, emp.getWorkingPhone());
            st.setString(6, emp.getAddress());
            st.setString(7, emp.getPostalCode());
            st.setString(8, emp.getCity());
            st.setString(9, emp.getEmail());
            st.executeUpdate();
            dbConn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public EmployeeBean getEmployee(String email) {

        String query = "SELECT * FROM EMPLOYEES WHERE EMAIL = ?";
        EmployeeBean emp = new EmployeeBean();
        
        try {
            dbConn = this.getConnection();
            PreparedStatement st = dbConn.prepareStatement(query);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            emp.setFirstName(rs.getString("FIRSTNAME"));
            emp.setName(rs.getString("NAME"));
            emp.setHomePhone(rs.getString("TELHOME"));
            emp.setMobilePhone(rs.getString("TELMOB"));
            emp.setWorkingPhone(rs.getString("TELPRO"));
            emp.setAddress(rs.getString("ADRESS"));
            emp.setPostalCode(rs.getString("POSTALCODE"));
            emp.setCity(rs.getString("CITY"));
            emp.setEmail(rs.getString("EMAIL"));
            }
            dbConn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return emp;
    }

    public void updateEmployee(EmployeeBean emp) {
       String query = "UPDATE EMPLOYEES SET FIRSTNAME=?, NAME=?, TELHOME=?, TELMOB=?, "
               + "TELPRO =?, ADRESS=?, POSTALCODE=?, CITY=? WHERE EMAIL=?";

        try {

            dbConn = this.getConnection();
            PreparedStatement st = dbConn.prepareStatement(query);
            st.setString(1, emp.getFirstName());
            st.setString(2, emp.getName());
            st.setString(3, emp.getHomePhone());
            st.setString(4, emp.getMobilePhone());
            st.setString(5, emp.getWorkingPhone());
            st.setString(6, emp.getAddress());
            st.setString(7, emp.getPostalCode());
            st.setString(8, emp.getCity());
            st.setString(9, emp.getEmail());
            st.executeUpdate();
            dbConn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void deleteEmployee(String email) {
       String query = "DELETE FROM EMPLOYEES WHERE EMAIL=?";

        try {

            dbConn = this.getConnection();
            PreparedStatement st = dbConn.prepareStatement(query);
            st.setString(1, email);
            st.executeUpdate();
            dbConn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
