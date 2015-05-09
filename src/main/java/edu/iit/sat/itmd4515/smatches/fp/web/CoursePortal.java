/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.web;

import edu.iit.sat.itmd4515.smatches.fp.domain.Professor;
import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import edu.iit.sat.itmd4515.smatches.fp.service.ProfessorService;
import edu.iit.sat.itmd4515.smatches.fp.service.StudentService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author smatches
 */
@WebServlet(name = "CoursePortal", urlPatterns = {"/myCourses","/myCourses/"})
public class CoursePortal extends HttpServlet {

    @EJB
    private StudentService studentService;
    
    @EJB
    private ProfessorService professorService;
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
       
        //if student is in role, render student courses
            if (request.isUserInRole("student")) {
                Student s = studentService.findByUsername(request.getRemoteUser());
                response.setContentType("text/html");
                request.setAttribute("user",s.getUser().getUserName());
                request.setAttribute("usertype","1");
                request.setAttribute("courses",s.getCourses());
                request.getRequestDispatcher("/WEB-INF/studentPortal/myCourses.jsp").forward(request, response);
            }
            
            //if professor is in role, render professor courses
              if (request.isUserInRole("professor")) {
                Professor p = professorService.findByUsername(request.getRemoteUser());
                response.setContentType("text/html");
                request.setAttribute("user",p.getUser().getUserName());
                request.setAttribute("usertype","2");
                request.setAttribute("courses",p.getCourses());
                request.getRequestDispatcher("/WEB-INF/studentPortal/myCourses.jsp").forward(request, response);
            }
        }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
     
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
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
