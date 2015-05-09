/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.Meetup;
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
public class MeetupService {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;
   /**
     * constructor
     */
    public MeetupService() {
    }

    /**
     * create meetup
     * @param m
     */
    public void create(Meetup m) {
        em.persist(m);
    }

    /**
     * update meetup
     * @param m
     */
    public void update(Meetup m) {
        em.merge(m);
    }

    /**
     * remove meetup
     * @param m
     */
    public void remove(Meetup m) {
        em.remove(m);
    }

    /**
     * find meetup by its id
     * @param id
     * @return
     */
    public Meetup find(long id) {
        return em.find(Meetup.class, id);
    }

    /**
     * find all method which finds all meetups
     * @return
     */
    public List<Meetup> findAll() {
        return em.createNamedQuery("Meetup.findAll",
                Meetup.class).getResultList();
    }
    

    /**
     * find by topic method which finds all the meetup
     * @param topic
     * @return
     */
    public Meetup findByTopic(String topic) {
        return em.createNamedQuery("Meetup.findByTopic",Meetup.class).setParameter("topic", topic).getSingleResult();
    }
}
