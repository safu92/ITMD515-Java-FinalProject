/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.web;

import edu.iit.sat.itmd4515.smatches.fp.domain.Course;
import edu.iit.sat.itmd4515.smatches.fp.domain.Meetup;
import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import edu.iit.sat.itmd4515.smatches.fp.service.MeetupService;
import edu.iit.sat.itmd4515.smatches.fp.service.StudentService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.codegen.Compiler.LOG;

/**
 *
 * @author smatches
 */
@WebServlet(name = "joinMeetup", urlPatterns = {"/joinMeetup","/joinMeetup/"})
public class joinMeetup extends HttpServlet {

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
        //allow user to join meetup by rendering all meetups in dropdown menu
        if (request.isUserInRole("student")) {
                Student s = studentService.findByUsername(request.getRemoteUser());
        List<Meetup> m = meetupService.findAll();
        response.setContentType("text/html");
          request.setAttribute("user",s.getUser().getUserName());
                request.setAttribute("usertype","1");
        request.setAttribute("meetups", m);
        request.getRequestDispatcher("/WEB-INF/studentPortal/joinMeetup.jsp").forward(request, response);
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
