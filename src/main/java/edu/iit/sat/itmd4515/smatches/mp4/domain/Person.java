/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author smatches
 */
@MappedSuperclass
public abstract class Person extends BaseEntity {

    /**
     *temporal date type birthdate
     */
    @Temporal(TemporalType.DATE)
    protected Date birthDate;

    /**
     * string value of first name
     */
    protected String firstName;

    /**
     * string value of last name
     */
    protected String lastName;

    /**
     * constructor
     * @param birthDate the value of the birthdate of the person
     * @param firstName the value of the first name of the person
     * @param lastName the value of the last name of the person
     */
    public Person(Date birthDate, String firstName, String lastName) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * constructor
     */
    public Person() {
    }

    
    /**
     * Get the value of birthDate
     *
     * @return the value of birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Set the value of birthDate
     *
     * @param birthDate new value of birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get method
     * @return the value of the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set method
     * @param lastName the value of the lastname of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
