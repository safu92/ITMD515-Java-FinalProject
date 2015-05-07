/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.University;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 */
@Stateless
public class UniversityService {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    /**
     * constructor
     */
    public UniversityService() {
    }

    /**
     * create student
     * @param s
     */
    public void create(University u) {
        em.persist(u);
    }

    /**
     * update student
     * @param s
     */
    public void update(University u) {
        em.merge(u);
    }

    /**
     * remove student
     * @param s
     */
    public void remove(University u) {
        em.remove(u);
    }

    /**
     * find student by its id
     * @param id
     * @return
     */
    public University find(long id) {
        return em.find(University.class, id);
    }

    /**
     * find all method which finds all students
     * @return
     */
    public List<University> findAll() {
        return em.createNamedQuery("University.findAll",
                University.class).getResultList();
    }

    /**
     * find by username which finds user by its username
     * @param userName username passed which needs to be find
     * @return the student which found
     */
    public University findByName(String name) {
        return em.createNamedQuery("University.findByName",
                University.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
