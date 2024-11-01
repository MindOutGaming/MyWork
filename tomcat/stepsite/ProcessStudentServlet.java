/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.step.controller;

import com.finlogic.step.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sohel1
 */
public class ProcessStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String process = request.getParameter("process");

            // process eq viewstudents
            if (process.equals("viewstudents") 
                    || process.equals("editstudents") 
                    || process.equals("deletestudents")) {
                // service -> repo -> db
                ResultSet rs = studentService.getAllStudents();

                request.setAttribute("result", rs);
                request.setAttribute("process", process);
                
            RequestDispatcher view = request
                    .getRequestDispatcher("studentajax.jsp");

            view.forward(request, response);
            
            } else if (process.equals("addstudents")) {
                request.setAttribute("process", process);
                
            RequestDispatcher view = request
                    .getRequestDispatcher("studentajax.jsp");

            view.forward(request, response);
            
            } else if (process.equals("insertStudents")) {
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String state = request.getParameter("state");
                String city = request.getParameter("city");

                int result = studentService.insertStudent(name, address, email, state, city);
                request.setAttribute("process", process);
                request.setAttribute("status", result);
                RequestDispatcher view = request
                    .getRequestDispatcher("mastertask.jsp");

                view.forward(request, response);
            
            }

        } catch (SQLException ex) {
            System.out.println("an exception has occurred: "+ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

}
