package com.dzhao.simplecms.server.database.dao;

import com.dzhao.simplecms.server.database.model.DbFileContent;
import junit.framework.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class DbFileContentDaoTest extends JpaDaoTest{

    @Test
    public void can_save() throws UnsupportedEncodingException {
        DbFileContent domain = new DbFileContent();
        domain.setId(testId);
        domain.setStreamContent(contentStr.getBytes("UTF-8"));
        dbFileContentDao.save(domain);

        DbFileContent actrual = dbFileContentDao.get(testId);

        Assert.assertNotNull(actrual);

        Assert.assertEquals("incorrect StreamContent", contentStr, new String(actrual.getStreamContent(), "UTF-8"));

    }
}
