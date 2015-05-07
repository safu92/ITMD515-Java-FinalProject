/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.domain;

import edu.iit.sat.itmd4515.smatches.fp.domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author smatches
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Professor.findByName", query = "select p from Professor p where p.lastName = :lname"),
    @NamedQuery(name = "Professor.findById", query = "select p from Professor p where p.id = :id"),
    @NamedQuery(name = "Professor.findAll", query = "select p from Professor p"),
@NamedQuery(name = "Professor.findByUsername", query = "select p from Professor p where p.user.userName = :username")})
public class Professor extends Person implements Serializable {

      @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
    
     @ManyToMany
    @JoinTable(name = "professor_course",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();
    
    
    @OneToOne
    private Meetup meetup;
    
    /**
     * constructor
     */
    public Professor() {
    }

    /**
     * get meetup method
     * @return the value of the meetup
     */
    public Meetup getMeetup() {
        return meetup;
    }

    /**
     * set meetup method
     * @param meetup the value of the meetup object professor is attending
     */
    public void setMeetup(Meetup meetup) {
        this.meetup = meetup;
    }

    /**
     * get user method
     * @return the value of the user
     */
    public User getUser() {
        return user;
    }

    /**
     * ser user method
     * @param user the value of the user object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * constructor
     * @param university the value of the university object
     * @param meetup the value of the meetup object
     * @param birthDate the birthdate of professor
     * @param firstName the first name of professor
     * @param lastName the last name of professor
     */
    public Professor(University university,Meetup meetup, Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
        this.university = university;
        this.meetup = meetup;
    }
    
    /**
     * get university method
     * @return the value of the university of professor
     */
    public University getUniversity() {
        return university;
    }

    /**
     * set university method
     * @param university the value of university to set for the professor
     */
    public void setUniversity(University university) {
        this.university = university;
    }

    /**
     * get courses method
     * @return the list of courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * constructor
     * @param birthDate the value of the birthdate of professor
     * @param firstName the first name of professor
     * @param lastName the last name of professor
     */
    public Professor(Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
    }

    
    
    

   
}
