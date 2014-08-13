package com.dzhao.simplecms.server.database.dao.api;

import com.dzhao.simplecms.server.model.BaseDomain;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends BaseDomain<ID>, ID extends Serializable> {
    /**
     * Persist the newInstance object into database
     * @param entity
     * @return
     */
    T save(T entity);

    void save(final T... entities);

    /**
     * Retrieve an object that was previously persisted to the database
     * using the indicated id as primary key
     * @param id
     * @return
     */
    T get(ID id);

    /**
     *
     * @return
     */
    List<T> getAll();
    /**
     * Save changes made to a persistent object.
     * @param entity
     * @return
     */
    T update(T entity);

    /**
     * Remove an object from persistent storage in the database
     * @param entity
     */
    void delete(T entity);
}
