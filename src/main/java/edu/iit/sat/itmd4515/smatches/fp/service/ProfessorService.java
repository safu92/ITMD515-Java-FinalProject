/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.Professor;
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
public class ProfessorService {

        @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    /**
     * constructor
     */
    public ProfessorService() {
    }

    /**
     * create professor
     * @param p
     */
    public void create(Professor p) {
        em.persist(p);
    }

    /**
     * update professor
     * @param p
     */
    public void update(Professor p) {
        em.merge(p);
    }

    /**
     * remove professor
     * @param p
     */
    public void remove(Professor p) {
        em.remove(p);
    }

    /**
     * find prof by its id
     * @param id
     * @return
     */
    public Student find(long id) {
        return em.find(Student.class, id);
    }


    /**
     * find all method which finds all the professors
     * @return
     */
    public List<Professor> findAll() {
        return em.createNamedQuery("Professor.findAll",Professor.class).getResultList();
    }

    /**
     * find by username method
     * @param username value of the username
     * @return finds the professor which matches the username passed
     */
    public Professor findByUsername(String username) {
        return em.createNamedQuery("Professor.findByUsername",Professor.class).setParameter("username", username).getSingleResult();
    }

}
