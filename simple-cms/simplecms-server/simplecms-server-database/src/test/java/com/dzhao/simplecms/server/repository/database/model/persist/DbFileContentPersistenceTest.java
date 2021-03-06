package com.dzhao.simplecms.server.repository.database.model.persist;

import com.dzhao.simplecms.server.repository.database.model.DbFileContent;
import junit.framework.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;


public class DbFileContentPersistenceTest extends PersistenceTest<DbFileContent, String>{

    @Test
    public void can_persist_domain() throws UnsupportedEncodingException {
        DbFileContent domain = new DbFileContent();
        domain.setStreamContent(contentStr.getBytes("UTF-8"));
        save(domain);

        DbFileContent actrual = get(domain.getId());
        Assert.assertNotNull(actrual);

        Assert.assertEquals("incorrect StreamContent", contentStr, new String(actrual.getStreamContent(), "UTF-8"));

    }
}
