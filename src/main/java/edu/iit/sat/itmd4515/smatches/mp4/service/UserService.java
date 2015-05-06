/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.security.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author smatches
 */
@Stateless
public class UserService extends AbstractService<User>{

    /**
     * constructor
     */
    public UserService() {
        super(User.class);
    }

    /**
     * find all method which finds all the users
     * @return
     */
    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
