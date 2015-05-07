/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.security.Group;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 */
@Stateless
public class GroupService {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    /**
     * constructor
     */
    public GroupService() {
    }

    /**
     * create student
     * @param s
     */
    public void create(Group g) {
        em.persist(g);
    }

    /**
     * update student
     * @param s
     */
    public void update(Group g) {
        em.merge(g);
    }

    /**
     * remove student
     * @param s
     */
    public void remove(Group g) {
        em.remove(g);
    }

    /**
     * find student by its id
     * @param id
     * @return
     */
    public Group find(long id) {
        return em.find(Group.class, id);
    }

    /**
     * find all method which finds all students
     * @return
     */
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll",
                Group.class).getResultList();
    }

    /**
     * find by username which finds user by its username
     * @param userName username passed which needs to be find
     * @return the student which found
     */
    public Group findByName(String name) {
        return em.createNamedQuery("Group.findByName",
                Group.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
