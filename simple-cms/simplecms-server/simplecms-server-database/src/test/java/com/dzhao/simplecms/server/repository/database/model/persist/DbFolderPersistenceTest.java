package com.dzhao.simplecms.server.repository.database.model.persist;


import com.dzhao.simplecms.server.repository.database.model.DbFolder;
import junit.framework.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class DbFolderPersistenceTest extends PersistenceTest<DbFolder, String>{

    @Test
    public void can_persist_domain(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        DbFolder domain = new DbFolder();
        domain.setCreatedBy(testUser);
        domain.setCreationDate(testDate);
        domain.setDescription(testDescription);
        domain.setPath(testFolderPath);
        domain.setName(testName);
        domain.setLastModificationDate(testDate);
        domain.setLastModifiedBy(testUser);
        domain.setTitle(testTitle);

        save(domain);

        DbFolder actrual = get(domain.getId());
        Assert.assertNotNull(actrual);

        Assert.assertEquals("incorrect Name",testName, actrual.getName());
        Assert.assertEquals("incorrect CreatedBy",testUser, actrual.getCreatedBy());
        Assert.assertEquals("incorrect LastModifiedBy",testUser, actrual.getLastModifiedBy());
        Assert.assertEquals("incorrect CreationDate",sdf.format(testDate), sdf.format(actrual.getCreationDate()));
        Assert.assertEquals("incorrect LastModificationDate",sdf.format(testDate), sdf.format(actrual.getLastModificationDate()));
        Assert.assertEquals("incorrect Description",testDescription, actrual.getDescription());
        Assert.assertEquals("incorrect Title",testTitle, actrual.getTitle());
        Assert.assertEquals("incorrect FolderPath",testFolderPath, actrual.getPath());
    }


}
