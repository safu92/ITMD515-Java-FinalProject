/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.fp.service;

import edu.iit.sat.itmd4515.smatches.fp.domain.Course;
import edu.iit.sat.itmd4515.smatches.fp.domain.Meetup;
import edu.iit.sat.itmd4515.smatches.fp.domain.Professor;
import edu.iit.sat.itmd4515.smatches.fp.domain.Student;
import edu.iit.sat.itmd4515.smatches.fp.domain.University;
import edu.iit.sat.itmd4515.smatches.fp.domain.security.Group;
import edu.iit.sat.itmd4515.smatches.fp.domain.security.User;
import edu.iit.sat.itmd4515.smatches.fp.service.CourseService;
import edu.iit.sat.itmd4515.smatches.fp.service.CourseService;
import edu.iit.sat.itmd4515.smatches.fp.service.GroupService;
import edu.iit.sat.itmd4515.smatches.fp.service.MeetupService;
import edu.iit.sat.itmd4515.smatches.fp.service.ProfessorService;
import edu.iit.sat.itmd4515.smatches.fp.service.StudentService;
import edu.iit.sat.itmd4515.smatches.fp.service.UniversityService;
import edu.iit.sat.itmd4515.smatches.fp.service.UniversityService;
import edu.iit.sat.itmd4515.smatches.fp.service.UserService;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 */
@Singleton
@Startup
public class DatabasePopulator {

    @PersistenceContext(name = "smatchesPU")
    private EntityManager em;
    
    @EJB
    private CourseService courseService;

    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;

    @EJB
    private ProfessorService professorService;
    
    @EJB
    private StudentService studentService;

    @EJB
    private UniversityService universityService;
    
    @EJB
    private MeetupService meetupService;
    
    /**
     *constructor
     */
    public DatabasePopulator() {
    }

    //the method to fill the data in the database
    @PostConstruct
    private void seedDatabase() {

        Group student = new Group("STUDENT", "Students Group");
        Group professor = new Group("PROFESSOR", "Professors Group");

        User safu = new User("safu", "abc123");
        User test = new User("test", "test");
        User john = new User("john", "abc123");
        User scott = new User("scott", "scott");
        test.addGroup(student);
        john.addGroup(student);
        safu.addGroup(professor);
        scott.addGroup(professor);
        
        Course c1 = new Course("Advance Software Development", "ITMD515");
        Course c2 = new Course("Web Development", "ITMD562");
        Course c3 = new Course("Project Management", "ITMD571");
        Course c4 = new Course("Intermediate Object Oriented Programming", "ITMD411");

        Student s1 = new Student("Information Technology and Management", new GregorianCalendar(1992, 06, 18).getTime(), "Mathew", "Dem");
        Student s2 = new Student("Information Technology and Management", new GregorianCalendar(1989, 03, 21).getTime(), "John", "Nicora");
        s1.setUser(test);
        s2.setUser(john);

        Professor p1 = new Professor(new GregorianCalendar(1980, 05, 21).getTime(), "Safdar", "Matcheswala");
        Professor p2 = new Professor(new GregorianCalendar(1973, 05, 21).getTime(), "Scott", "Spyrison");
        p1.setUser(safu);
        p2.setUser(scott);
        
        University u1 = new University("Illinois", "Illinois Institute of Technology");
        University u2 = new University("California", "San Jose State University");
        
        Meetup m1 = new Meetup(new GregorianCalendar(2015, 04, 04).getTime(), "Herman Hall", "JSP");
        Meetup m2 = new Meetup(new GregorianCalendar(2015, 04, 01).getTime(), "Stuart Building", "Android SQLite");
        Meetup m3 = new Meetup(new GregorianCalendar(2015, 04, 17).getTime(), "MTCC", "Javascript");
        Meetup m4 = new Meetup(new GregorianCalendar(2015, 04, 23).getTime(), "Herman Hall", "iOS Beginner");
        
        
        s1.getCourses().add(c1);
        c1.getStudents().add(s1);
        s1.getCourses().add(c2);
        c2.getStudents().add(s1);
        s2.getCourses().add(c3);
        c3.getStudents().add(s2);
        
        p1.getCourses().add(c2);
        p2.getCourses().add(c1);
        c1.getProfessors().add(p1);
        c1.getProfessors().add(p2);
        
        s1.setUniversity(u1);
        s2.setUniversity(u2);
        p1.setUniversity(u1);
        p2.setUniversity(u1);
        p1.setMeetup(m1);
        p2.setMeetup(m4);
        
        s1.getMeetups().add(m4);
        s2.getMeetups().add(m1);
        
        groupService.create(student);
        groupService.create(professor);

        courseService.create(c1);
        courseService.create(c2);
        courseService.create(c3);
        courseService.create(c4);
        
        userService.create(test);
        userService.create(john);
        userService.create(safu);
        userService.create(scott);
        
        studentService.create(s1);
        studentService.create(s2);
        
        professorService.create(p1);
        professorService.create(p2);
        
        universityService.create(u1);
        universityService.create(u2);
                
        meetupService.create(m1);
        meetupService.create(m2);
        meetupService.create(m3);
        meetupService.create(m4);
    }
}
