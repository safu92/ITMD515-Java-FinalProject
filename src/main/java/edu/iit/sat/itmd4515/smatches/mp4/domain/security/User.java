/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author smatches
 */
@Entity
@Table(name = "sec_user")
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User implements Serializable {

    private Boolean enabled;

    @Id
    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "sec_user_groups",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    /**
     * constructor
     * @param userName the username of the user
     * @param password the password of the user
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * constructor
     */
    public User() {
    }

    /**
     * add group method
     * @param g value of group object to add to user and vice versa
     */
    public void addGroup(Group g) {
        if (!this.groups.contains(g)) {
            this.groups.add(g);
        }
        if (!g.getUsers().contains(this)) {
            g.getUsers().add(this);
        }
    }

    /**
     * set enabled method
     * @param enabled value of enabled which can be true or false
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get groups method
     * @return the value of the groups as a list of group object
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * set groups method
     * @param groups the value of the groups as a list of group objects to set for the user
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    //hashing password method
    @PrePersist
    @PreUpdate
    private void hashPassword(){
        String digestPassword = DigestUtils.md5Hex(this.password);
        this.password = digestPassword;
    }

    /**
     * is enabled method 
     * @return the value of the enabled
     */
    public Boolean isEnabled() {
        return enabled;
    }

}
