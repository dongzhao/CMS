package com.dzhao.simplecms.server.database.dao;

import com.dzhao.simplecms.server.database.dao.api.Dao;
import com.dzhao.simplecms.server.database.dao.provider.EntityManagerProvider;
import com.dzhao.simplecms.server.model.BaseDomain;
import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.io.Serializable;
/*import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;*/

public class JpaDao<T extends BaseDomain<ID>, ID extends Serializable> implements Dao<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(Dao.class);

    private final EntityManagerProvider entityManagerProvider;

    protected final Class<T> clazz;

    @Inject
    public JpaDao(TypeLiteral<T> type, EntityManagerProvider entityManagerProvider){
        this.entityManagerProvider = entityManagerProvider;
        this.clazz = (Class<T>)type.getRawType();
/*        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if(types[0] instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) types[0];
            setClazz( (Class<BaseDomain<ID>>) type.getRawType() );
        }else{
            setClazz((Class<BaseDomain<ID>>) types[0]);
        }*/
    }
    @Override
    public T save(T entity) {
        EntityManager em = entityManagerProvider.get();
        try {
            em.getTransaction().begin();
            if (entity.getId() != null) {
                entity = em.merge(entity);
            } else {
                em.persist(entity);
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            em.getTransaction().rollback();
        } finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
        return entity;
    }
    @Override
    public void save(final T... entities) {
        for (T entity : entities){
            save(entity);
        }
    }

    @Override
    public T get(ID id) {
        return entityManagerProvider.get().find(clazz, id);
    }

    @Override
    public T update(T entity) {
        return save(entity);
    }

    @Override
    public void delete(final T entity) {
        EntityManager em = entityManagerProvider.get();
        try{
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            em.getTransaction().rollback();
        }finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }
}
