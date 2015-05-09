/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.web;

import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import edu.iit.sat.itmd4515.smatches.fp.service.MeetupService;
import edu.iit.sat.itmd4515.smatches.fp.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "MeetupPortal", urlPatterns = {"/myMeetups","/myMeetups/"})
public class MeetupPortal extends HttpServlet {

    @EJB
    private MeetupService meetupService;
    
    @EJB
    private StudentService studentService;
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
       
        //show all the meetups to the user
            if (request.isUserInRole("student")) {
                Student s = studentService.findByUsername(request.getRemoteUser());
                response.setContentType("text/html");
                request.setAttribute("user",s.getUser().getUserName());
                request.setAttribute("usertype","1");
                request.setAttribute("meetups",s.getMeetups());
                request.getRequestDispatcher("/WEB-INF/meetupPortal/myMeetups.jsp").forward(request, response);
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
