package com.dzhao.simplecms.server.repository.database.dao;

import com.dzhao.simplecms.server.repository.database.dao.runner.DaoSaveRunner;
import com.dzhao.simplecms.server.repository.database.model.DbFolder;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Ignore
public class MultithreadedDaoTest extends JpaDaoTest{

    private static int defaultClients = 10;
    private static int defaultPoolSize = 5;

    @Test
    public void can_insert_multithreaded() throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(defaultPoolSize, defaultPoolSize,0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch finished = new CountDownLatch(defaultClients);
        for (int i = 0; i<defaultClients; i++){
            executor.execute(new DaoSaveRunner<DbFolder, String>(dbFolderDao, newFolder(), start, finished));
        }
        start.countDown();
        finished.await(60, TimeUnit.SECONDS);
        executor.shutdownNow();
        Assert.assertEquals("Not all invocations have completed", 0, finished.getCount());

        for (int i = 0; i<defaultClients; i++){
            Assert.assertNotNull(dbFolderDao.get("thread" + String.valueOf(i)));
        }
    }

    @Test
    public void can_update_multithreaded() throws InterruptedException {

        DbFolder newFolder = newFolder();
        dbFolderDao.save(newFolder);
        String testId = newFolder.getId();
        Assert.assertNotNull(dbFolderDao.get(testId));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(defaultPoolSize, defaultPoolSize,0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch finished = new CountDownLatch(defaultClients);
        for (int i = 0; i<defaultClients; i++){
            executor.execute(new DaoSaveRunner<DbFolder, String>(dbFolderDao, updFolder(testId, String.valueOf(i)), start, finished));
        }
        start.countDown();
        finished.await(60, TimeUnit.SECONDS);
        executor.shutdownNow();
        Assert.assertEquals("Not all invocations have completed", 0, finished.getCount());
        Assert.assertNotNull(dbFolderDao.get("thread"));
    }

    private DbFolder newFolder(){
        DbFolder domain = new DbFolder();
        domain.setCreatedBy(testUser);
        domain.setCreationDate(testDate);
        domain.setDescription(testDescription);
        domain.setPath(testFolderPath);
        domain.setName(testName);
        domain.setLastModificationDate(testDate);
        domain.setLastModifiedBy(testUser);
        domain.setTitle(testTitle);
        return domain;
    }

    private DbFolder updFolder(String id, String title){
        DbFolder domain = dbFolderDao.get(id);
        domain.setTitle(domain.getTitle() + "-" + title);
        return domain;
    }
}
