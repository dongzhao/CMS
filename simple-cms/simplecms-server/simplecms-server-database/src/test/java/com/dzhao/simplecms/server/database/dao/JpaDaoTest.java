package com.dzhao.simplecms.server.database.dao;

import com.dzhao.simplecms.server.database.dao.api.Dao;
import com.dzhao.simplecms.server.database.model.DbFile;
import com.dzhao.simplecms.server.database.model.DbFileContent;
import com.dzhao.simplecms.server.database.model.DbFolder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import org.junit.Before;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class JpaDaoTest{
    protected Injector injector;
    protected Dao<DbFolder, String> dbFolderDao;
    protected Dao<DbFile, String> dbFileDao;
    protected Dao<DbFileContent, String> dbFileContentDao;

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


    @Before
    public void setUp(){
        injector = Guice.createInjector(new JpaDaoTestModule());
        dbFolderDao = injector.getInstance(new Key<Dao<DbFolder, String>>(){});
        dbFileDao = injector.getInstance(new Key<Dao<DbFile, String>>(){});
        dbFileContentDao = injector.getInstance(new Key<Dao<DbFileContent, String>>(){});
    }

}
