/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smatches
 * @param <T> the value of the class passed in generic
 */
public abstract class AbstractService<T> {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    private final Class<T> entityClass;
    
    /**
     *consctructor
     * @param entityClass the class passed to set the value
     */
    protected AbstractService(Class entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * getting the entity manager object
     * @return em is the entity manager
     */
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * create method
     * @param entity the value of the class passed
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     * find method
     * @param id value of the object id
     * @return the value of the specific object by finding it
     */
    public T find(Object id) {
        return em.find(entityClass, id);
    }

    /**
     * find method which finds all the data
     * @return
     */
    public abstract List<T> findAll();

    /**
     * update method
     * @param entity the value of the class which needs to be updated
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     * delete method
     * @param entity the value of the class which needs to be deleted
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    /**
     * delete by id method
     * @param id the id which needs to be deleted
     */
    public void deleteById(Object id) {
        em.remove(em.getReference(entityClass, id));
    }
}
