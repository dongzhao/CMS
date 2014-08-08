package com.dzhao.simplecms.server.database.model.persist;


import com.dzhao.simplecms.server.model.BaseDomain;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class PersistenceTest<T extends BaseDomain<ID>, ID extends Serializable> {

    protected Injector injector;
    protected static EntityManagerFactory emf;
    protected Class<T> clazz;

    protected String testId = "file-12345";
    protected String testName = "test";
    protected String testFolderPath = "/test folder";
    protected String testUser = "testuser01";
    protected String testDescription = "test description";
    protected String testTitle = "test testTitle";
    protected Long testLength = Long.valueOf(100000l);
    protected String testMimetype = "pdf";
    protected Date testDate = new Date();

    protected String contentStr = "This is a test";

    protected Map<String, String> testAttributes = new HashMap<String, String>(){
        {
            put("testName1", "testValue1");
            put("testName2", "testValue2");
        }
    };


    public PersistenceTest(){
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (types[0] instanceof ParameterizedType) {
            // If the class has parameterized types, it takes the raw type.
            ParameterizedType type = (ParameterizedType) types[0];
            clazz = (Class<T>) type.getRawType();
        } else {
            clazz = (Class<T>) types[0];
        }
    }

    @Before
    public void setUp(){
        injector = Guice.createInjector(new PersistenceTestModule());
        emf = injector.getInstance(EntityManagerFactory.class);
    }

    @After
    public void tearDown(){
        emf.close();
    }

    protected <T> void save(T domain){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(domain);
        em.getTransaction().commit();
    }

    protected <T> T get(ID id){
        EntityManager em = emf.createEntityManager();
        return (T)em.find(clazz, id);
    }

}
