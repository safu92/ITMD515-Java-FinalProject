/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 */
@Stateless
public class CourseService {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    /**
     * constructor
     */
    public CourseService() {
    }

    /**
     * create student
     * @param c
     */
    public void create(Course c) {
        em.persist(c);
    }

    /**
     * update student
     * @param s
     */
    public void update(Course c) {
        em.merge(c);
    }

    /**
     * remove student
     * @param s
     */
    public void remove(Course c) {
        em.remove(c);
    }

    /**
     * find student by its id
     * @param id
     * @return
     */
    public Course find(long id) {
        return em.find(Course.class, id);
    }

    /**
     * find all method which finds all students
     * @return
     */
    public List<Course> findAll() {
        return em.createNamedQuery("Course.findAll",
                Course.class).getResultList();
    }

    
     public Course findByName(String name) {
        return em.createNamedQuery("C.findByName",
                Course.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
