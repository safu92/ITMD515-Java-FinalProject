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
    @NamedQuery(name = "Student.findByName", query = "select s from Student s where s.lastName = :lname"),
    @NamedQuery(name = "Student.findById", query = "select s from Student s where s.id = :id"),
    @NamedQuery(name = "Student.findAll", query = "select s from Student s"),
    @NamedQuery(name = "Student.findByUsername", query = "select s from Student s where s.user.userName = :username")})
public class Student extends Person implements Serializable {

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * get user method
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * set user method
     * @param user the value of user object
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
    
    
     @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();
     
      @ManyToMany
    @JoinTable(name = "student_meetup",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "meetup_id"))
    private List<Meetup> meetups = new ArrayList<>();
    
    @OneToOne(mappedBy = "student")
    private Job job;
     
    /**
     * constructor
     */
    public Student() {
    }
    
    private String major;

    /**
     * get courses method
     * @return the value of all the courses taken by that student
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * constructor
     * @param university the name of university student is attending
     * @param major the major of the student
     * @param birthDate the birthdate of student
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     */
    public Student(University university, String major, Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
        this.university = university;
        this.major = major;
    }

    /**
     * get meetup method
     * @return the value of list of meetup object
     */
    public List<Meetup> getMeetups() {
        return meetups;
    }

    /**
     * get job method
     * @return the job of the student
     */
    public Job getJob() {
        return job;
    }

    /**
     *get university method
     * @return the value of the university of student
     */
    public University getUniversity() {
        return university;
    }

    /**
     * set university method
     * @param university the value of the univeristy to set for the student
     */
    public void setUniversity(University university) {
        this.university = university;
    }

    
    /**
     * Get the value of major
     *
     * @return the value of major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Set the value of major
     *
     * @param major new value of major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * constructor
     * @param major the major of student
     * @param birthDate the birthdate of student
     * @param firstName the first name of student
     * @param lastName the last name of student
     */
    public Student(String major, Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
        this.major = major;
    }

    
    
}
