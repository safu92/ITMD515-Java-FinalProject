/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.University;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author smatches
 */
@Stateless
public class UniversityService extends AbstractService<University> {

    /**
     * constructor
     */
    public UniversityService() {
        super(University.class);
    }

    /**
     * find all method which finds all the universities
     * @return
     */
    @Override
    public List<University> findAll() {
        return getEntityManager().createNamedQuery("University.findAll").getResultList();
    }

}
