/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.Meetup;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author smatches
 */
@Stateless
public class MeetupService extends AbstractService<Meetup> {

    /**
     * constructor
     */
    public MeetupService() {
        super(Meetup.class);
    }

    /**
     * find all method which finds all the meetup
     * @return
     */
    @Override
    public List<Meetup> findAll() {
        return getEntityManager().createNamedQuery("Meetup.findAll").getResultList();
    }

}
