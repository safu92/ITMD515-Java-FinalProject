/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.Course;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author smatches
 */
@Stateless
public class CourseService extends AbstractService<Course> {

    /**
     *constructor
     */
    public CourseService() {
        super(Course.class);
    }

    /**
     *find all method which finds all courses
     * @return
     */
    @Override
    public List<Course> findAll() {
        return getEntityManager().createNamedQuery("Course.findAll").getResultList();
    }

}
