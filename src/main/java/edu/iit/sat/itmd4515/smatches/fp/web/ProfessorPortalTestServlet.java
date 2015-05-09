/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.web;

import edu.iit.sat.itmd4515.smatches.fp.domain.Course;
import edu.iit.sat.itmd4515.smatches.fp.domain.Professor;
import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import edu.iit.sat.itmd4515.smatches.fp.service.ProfessorService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
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
@WebServlet(name = "ProfessorPortalTestServlet", urlPatterns = {"/professorPortal", "/professorPortal/"})
public class ProfessorPortalTestServlet extends HttpServlet {

    @EJB
    private ProfessorService professorService;
    
        private static final Logger LOG
            = Logger.getLogger(ProfessorPortalTestServlet.class.getName());


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
        
        //show professor profile deetails
                       if (request.isUserInRole("professor")) {
             Professor p = professorService.findByUsername(request.getRemoteUser());
        response.setContentType("text/html");
        request.setAttribute("user",p.getUser().getUserName());
        request.setAttribute("usertype","0");
        request.setAttribute("name", p.getFirstName());
        request.setAttribute("birthdate", p.getBirthDate());
        request.setAttribute("university", p.getUniversity().getName());
                     LOG.info("Dispatching to /myProfile");
        request.getRequestDispatcher("/WEB-INF/studentPortal/myProfile.jsp").forward(request, response);
        
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
