package com.dzhao.simplecms.server.repository.database.dao;

import com.dzhao.simplecms.server.repository.database.model.DbFileContent;
import junit.framework.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class DbFileContentDaoTest extends JpaDaoTest{

    @Test
    public void can_save() throws UnsupportedEncodingException {
        DbFileContent domain = new DbFileContent();
        domain.setStreamContent(contentStr.getBytes("UTF-8"));
        dbFileContentDao.save(domain);

        DbFileContent actrual = dbFileContentDao.get(domain.getId());

        Assert.assertNotNull(actrual);

        Assert.assertEquals("incorrect StreamContent", contentStr, new String(actrual.getStreamContent(), "UTF-8"));
    }

/*    @Test
    public void can_find_all() throws UnsupportedEncodingException {
        DbFileContent domain1 = new DbFileContent();
        domain1.setStreamContent(contentStr.getBytes("UTF-8"));
        dbFileContentDao.save(domain1);
        Assert.assertNotNull(dbFileContentDao.get(domain1.getId()));

        DbFileContent domain2 = new DbFileContent();
        domain2.setStreamContent(contentStr.getBytes("UTF-8"));
        dbFileContentDao.save(domain2);
        Assert.assertNotNull(dbFileContentDao.get(domain2.getId()));

        List<DbFileContent> domains = dbFileContentDao.getAll();
        Assert.assertNotNull(domains);
        Assert.assertEquals(2, domains.size());
    }*/
}
