/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.DataTransaction;
import models.EmployeeBean;
import models.UserBean;

/**
 *
 * @author namileto
 */
public class SingleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        PrintWriter out = response.getWriter();

        if (userPath.equals("")) {
            out.println("edvrgr");
        }

        if (userPath.equals("/login")) {
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
        if (userPath.equals("/dashboard")) {
            if (userConnected(request)) 
            {
                DataTransaction dt = new DataTransaction();
                ArrayList<EmployeeBean> employeesList = dt.getAllEmployees();

                request.setAttribute("employeesList", employeesList);
                this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
            } else {
                out.println("You must be connected !");
            }
        }
        if (userPath.equals("/add")) {
            this.getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
        }
        
        if (userPath.equals("/delete")) {      
            String email = request.getParameter("email");
             
            DataTransaction dt = new DataTransaction();
            dt.deleteEmployee(email);
            
            request.setAttribute("success-delete", "message without importance");
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dashboard");
            rd.forward(request, response);
        }
        
        if (userPath.equals("/details")) {
            String email = request.getParameter("email");
            DataTransaction dt = new DataTransaction();
            EmployeeBean emp = new EmployeeBean();
            emp = dt.getEmployee(email);
            request.setAttribute("currentEmployee", emp);
            this.getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userPath = request.getServletPath();

        if (userPath.equals("/login")) {
            DataTransaction dt = new DataTransaction();
            UserBean user = new UserBean();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            if (user.getUsername() == null || user.getPassword() == null
                    || user.getUsername().equals("") || user.getPassword().equals("")) {
                request.setAttribute("error-fields", "message without importance");
                this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }

            if (dt.checkCredentials(user.getUsername(), user.getPassword())) {
                HttpSession s = request.getSession();

                s.setAttribute("user", user);
                response.sendRedirect("/EmployeesManagementApplication/dashboard");
            } else {
                request.setAttribute("error-connection", "message without importance");
            }

            //this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

        if (userPath.equals("/add")) {
            DataTransaction dt = new DataTransaction();
            EmployeeBean emp = new EmployeeBean();
            emp.setName(request.getParameter("name"));
            emp.setFirstName(request.getParameter("firstname"));
            emp.setEmail(request.getParameter("email"));
            emp.setHomePhone(request.getParameter("telhome"));
            emp.setMobilePhone(request.getParameter("telmob"));
            emp.setWorkingPhone(request.getParameter("telpro"));
            emp.setAddress(request.getParameter("adress"));
            emp.setCity(request.getParameter("city"));
            emp.setPostalCode(request.getParameter("postalcode"));
            dt.addEmployee(emp);
            
            request.setAttribute("success-added", "message without importance");
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dashboard");
            rd.forward(request, response);
        }
        
        
        if (userPath.equals("/details")) {
            DataTransaction dt = new DataTransaction();
            EmployeeBean emp = new EmployeeBean();
            emp.setName(request.getParameter("name"));
            emp.setFirstName(request.getParameter("firstname"));
            emp.setEmail(request.getParameter("email"));
            emp.setHomePhone(request.getParameter("telhome"));
            emp.setMobilePhone(request.getParameter("telmob"));
            emp.setWorkingPhone(request.getParameter("telpro"));
            emp.setAddress(request.getParameter("adress"));
            emp.setCity(request.getParameter("city"));
            emp.setPostalCode(request.getParameter("postalcode"));
            dt.updateEmployee(emp);
            
            request.setAttribute("success-updated", "message without importance");
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dashboard");
            rd.forward(request, response);
        }
        
        

        if (userPath.equals("/dashboard")) {
            if (userConnected(request)) {
                DataTransaction dt = new DataTransaction();
                ArrayList<EmployeeBean> employeesList = dt.getAllEmployees();

                request.setAttribute("employeesList", employeesList);
                this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
            } else {
                out.println("You must be connected !");
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean userConnected(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null != session.getAttribute("user")) {
            return true;
        } else {
            return false;
        }
    }
    
    
   

}
