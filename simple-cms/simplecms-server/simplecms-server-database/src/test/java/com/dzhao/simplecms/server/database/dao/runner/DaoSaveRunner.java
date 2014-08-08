package com.dzhao.simplecms.server.database.dao.runner;


import com.dzhao.simplecms.server.database.dao.api.Dao;
import com.dzhao.simplecms.server.model.BaseDomain;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

public class DaoSaveRunner<T extends BaseDomain<ID>, ID extends Serializable> implements Runnable{

    private final Dao<T, ID> dao;
    private T domain;
    protected CountDownLatch start;
    protected CountDownLatch finished;

    public DaoSaveRunner(Dao<T, ID> dao, T domain,  CountDownLatch start, CountDownLatch finished){
        this.dao = dao;
        this.domain = domain;
        this.start = start;
        this.finished = finished;
    }

    @Override
    public void run() {
        try {
            start.await();
            dao.save(domain);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        finished.countDown();
    }
}
