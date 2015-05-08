/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 */
@Stateless
public class StudentService {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    /**
     * constructor
     */
    public StudentService() {
    }

    /**
     * create student
     * @param s
     */
    public void create(Student s) {
        em.persist(s);
    }

    /**
     * update student
     * @param s
     */
    public void update(Student s) {
        em.merge(s);
    }

    /**
     * remove student
     * @param s
     */
    public void remove(Student s) {
        em.remove(s);
    }

    /**
     * find student by its id
     * @param id
     * @return
     */
    public Student find(long id) {
        return em.find(Student.class, id);
    }

    /**
     * find all method which finds all students
     * @return
     */
    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll",
                Student.class).getResultList();
    }

    /**
     * find by username which finds user by its username
     * @param userName username passed which needs to be find
     * @return the student which found
     */
    public Student findByUsername(String userName) {
        return em.createNamedQuery("Student.findByUsername",
                Student.class)
                .setParameter("username", userName)
                .getSingleResult();
    }
    
     

}
