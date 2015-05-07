/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.security.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 */
@Stateless
public class UserService{

        @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    /**
     * constructor
     */
    public UserService() {
    }

    /**
     * create student
     * @param s
     */
    public void create(User u) {
        em.persist(u);
    }

    /**
     * update student
     * @param s
     */
    public void update(User u) {
        em.merge(u);
    }

    /**
     * remove student
     * @param s
     */
    public void remove(User u) {
        em.remove(u);
    }

    /**
     * find student by its id
     * @param id
     * @return
     */
    public User find(long id) {
        return em.find(User.class, id);
    }


    /**
     * find all method which finds all the users
     * @return
     */
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll",User.class).getResultList();
    }
    
}
