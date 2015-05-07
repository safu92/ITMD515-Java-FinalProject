/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.web;

import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import edu.iit.sat.itmd4515.smatches.fp.domain.University;
import edu.iit.sat.itmd4515.smatches.fp.domain.security.Group;
import edu.iit.sat.itmd4515.smatches.fp.domain.security.User;
import edu.iit.sat.itmd4515.smatches.fp.service.GroupService;
import edu.iit.sat.itmd4515.smatches.fp.service.ProfessorService;
import edu.iit.sat.itmd4515.smatches.fp.service.StudentService;
import edu.iit.sat.itmd4515.smatches.fp.service.UniversityService;
import edu.iit.sat.itmd4515.smatches.fp.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALLAH
 */
@WebServlet(name = "newUser", urlPatterns = {"/newUser","/newUser/"})
public class newUser extends HttpServlet {

    @EJB
    private StudentService studentService;
    
    @EJB
    private ProfessorService professorService;
    
    @EJB
    private UniversityService uniService;
    
    @EJB
    private GroupService groupService;
    
    @EJB
    private UserService userService;
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
    
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String birthDate = request.getParameter("birthDate");
    String university = request.getParameter("university");
    String userType = request.getParameter("userType");
    Date birth = null;
    DateFormat formatter = null;
    formatter = new SimpleDateFormat("yyyy-mm-dd");
    birth = (Date) formatter.parse(birthDate); // birtDate is a string
    User user = new User(username,password);


if(userType.equals("Student")){
    Group group = groupService.findByName("STUDENT");
    user.addGroup(group);
    Student s = new Student();
    University u = uniService.findByName(university);
    s.setFirstName(firstName);
    s.setLastName(lastName);
    s.setUniversity(u);
    s.setBirthDate(birth);
    s.setUser(user);
    
    userService.create(user);
    studentService.create(s);
		PrintWriter out = response.getWriter();
                out.println("Account Created");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
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

}
