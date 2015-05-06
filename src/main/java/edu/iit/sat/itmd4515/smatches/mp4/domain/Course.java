/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author smatches
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Course.findById", query = "select c from Course c where c.id = :id"),
    @NamedQuery(name = "Course.findByName", query = "select c from Course c where c.name = :name"),
    @NamedQuery(name = "Course.findAll", query = "select c from Course c")})
public class Course extends BaseEntity implements Serializable {

    /**
     * Constructor
     */
    public Course() {
    }
    
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();
    
    
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Professor> professors = new ArrayList<>();

    /**
     *
     * @param professors set the value of the professor
     */
    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
    
     
       
       
    
        private String name;

    /**
     *get professor method
     * @return the value of the professor
     */
    public List<Professor> getProfessors() {
        return professors;
    }

    /**
     *get students method
     * @return the value of students
     */
    public List<Student> getStudents() {
        return students;
    }

        
    /**
     * Get the value of courseName
     *
     * @return the value of courseName
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of courseName
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }


    private String courseId;

    /**
     * Get the value of courseId
     *
     * @return the value of courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Set the value of courseId
     *
     * @param courseId new value of courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * constructor
     * @param name the name of the course
     * @param courseId the id of the course
     */
    public Course(String name, String courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Course{name=").append(name).append('}');
        return sb.toString();
    }
}
