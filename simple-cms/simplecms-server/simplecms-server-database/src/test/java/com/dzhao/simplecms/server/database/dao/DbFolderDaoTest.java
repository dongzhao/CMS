package com.dzhao.simplecms.server.database.dao;

import com.dzhao.simplecms.server.database.model.DbFolder;
import junit.framework.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class DbFolderDaoTest extends JpaDaoTest{

    @Test
    public void can_save(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        DbFolder domain = new DbFolder();
        domain.setId(testId);
        domain.setCreatedBy(testUser);
        domain.setCreationDate(testDate);
        domain.setDescription(testDescription);
        domain.setFolderPath(testFolderPath);
        domain.setName(testName);
        domain.setLastModificationDate(testDate);
        domain.setLastModifiedBy(testUser);
        domain.setTitle(testTitle);

        dbFolderDao.save(domain);

        DbFolder actrual = dbFolderDao.get(testId);

        Assert.assertNotNull(actrual);

        Assert.assertEquals("incorrect Name",testName, actrual.getName());
        Assert.assertEquals("incorrect CreatedBy",testUser, actrual.getCreatedBy());
        Assert.assertEquals("incorrect LastModifiedBy",testUser, actrual.getLastModifiedBy());
        Assert.assertEquals("incorrect CreationDate",sdf.format(testDate), sdf.format(actrual.getCreationDate()));
        Assert.assertEquals("incorrect LastModificationDate",sdf.format(testDate), sdf.format(actrual.getLastModificationDate()));
        Assert.assertEquals("incorrect Description",testDescription, actrual.getDescription());
        Assert.assertEquals("incorrect Title",testTitle, actrual.getTitle());
        Assert.assertEquals("incorrect FolderPath",testFolderPath, actrual.getFolderPath());


    }
}
