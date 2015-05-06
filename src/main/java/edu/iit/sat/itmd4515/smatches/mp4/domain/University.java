/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author smatches
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "University.findByName", query = "select u from University u where u.name = :name"),
    @NamedQuery(name = "University.findById", query = "select u from University u where u.id = :id"),
    @NamedQuery(name = "University.findAll", query = "select u from University u")})
public class University extends BaseEntity implements Serializable {

    @OneToMany(mappedBy = "university")
    private List<Student> students = new ArrayList<>();
    
    @OneToMany(mappedBy = "university")
    private List<Professor> professors = new ArrayList<>();

    /**
     * constructor
     * @param state the state the university is in
     * @param name the name of the university
     */
    public University(String state, String name) {
        this.state = state;
        this.name = name;
    }

    /**
     * get student method
     * @return the list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * get professors method
     * @return the list of professors
     */
    public List<Professor> getProfessors() {
        return professors;
    }
    
    /**
     * constructor
     */
    public University() {
    }
    
    private String state;

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(String state) {
        this.state = state;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("University{name=").append(name).append('}');
        return sb.toString();
    }
    
}
