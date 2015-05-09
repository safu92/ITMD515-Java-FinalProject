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
     * create university
     * @param u
     */
    public void create(University u) {
        em.persist(u);
    }

    /**
     * update university
     * @param u
     * @param s
     */
    public void update(University u) {
        em.merge(u);
    }

    /**
     * remove university
     * @param u
     */
    public void remove(University u) {
        em.remove(u);
    }

    /**
     * find university by its id
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
     * find university by its name
     * @param name
     * @return the university which found
     */
    public University findByName(String name) {
        return em.createNamedQuery("University.findByName",
                University.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
