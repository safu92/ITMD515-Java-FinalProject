/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.web.admin;

import edu.iit.sat.itmd4515.smatches.fp.domain.University;
import edu.iit.sat.itmd4515.smatches.fp.service.StudentService;
import edu.iit.sat.itmd4515.smatches.fp.service.UniversityService;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "UniversityRender", urlPatterns = {"/uniAdmin","/uniAdmin/"})
public class UniversityRender extends HttpServlet {

    
     private static final Logger LOG = Logger.getLogger(UniversityRender.class.getName());

    @EJB
    private UniversityService universityService;
    
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
        //admin page to add,update and delete university
                    if (request.isUserInRole("admin")) {
                        if(request.getParameter("uniname") != null){
                            String uniName = request.getParameter("uniname");
                            String uniState = request.getParameter("unistate");
                            University u = new University(uniState, uniName);
                            universityService.create(u);
                            request.setAttribute("message", "University Added Successfully!");
                        }
                        
                                                
                       
                        
                        List<University> unis = universityService.findAll();
       request.setAttribute("usertype","7");
       request.setAttribute("universities", unis);
       request.getRequestDispatcher("/admin/university.jsp").forward(request, response);

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
