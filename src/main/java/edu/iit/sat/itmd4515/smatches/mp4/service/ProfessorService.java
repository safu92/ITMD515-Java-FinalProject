/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.Professor;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author smatches
 */
@Stateless
public class ProfessorService extends AbstractService<Professor> {

    /**
     * constructor
     */
    public ProfessorService() {
        super(Professor.class);
    }

    /**
     * find all method which finds all the professors
     * @return
     */
    @Override
    public List<Professor> findAll() {
        return getEntityManager().createNamedQuery("Professor.findAll",Professor.class).getResultList();
    }

    /**
     * find by username method
     * @param username value of the username
     * @return finds the professor which matches the username passed
     */
    public Professor findByUsername(String username) {
        return getEntityManager().createNamedQuery("Professor.findByUsername",Professor.class).setParameter("username", username).getSingleResult();
    }

}
