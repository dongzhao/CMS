package com.dzhao.simplecms.server.repository.database.model.persist;

import com.dzhao.simplecms.server.repository.database.model.DbFile;
import junit.framework.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class DbFilePersistenceTest extends PersistenceTest<DbFile, String>{

    @Test
    public void can_persist_domain(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        DbFile domain = new DbFile();
        domain.setCreatedBy(testUser);
        domain.setCreationDate(testDate);
        domain.setDescription(testDescription);
        domain.setPath(testFolderPath);
        domain.setName(testName);
        domain.setLastModificationDate(testDate);
        domain.setLastModifiedBy(testUser);
        domain.setTitle(testTitle);
        domain.setLength(testLength);
        domain.setMimeType(testMimetype);
        domain.setAttributes(testAttributes);

        save(domain);

        DbFile actrual = get(domain.getId());
        Assert.assertNotNull(actrual);

        Assert.assertEquals("incorrect Name",testName, actrual.getName());
        Assert.assertEquals("incorrect CreatedBy",testUser, actrual.getCreatedBy());
        Assert.assertEquals("incorrect LastModifiedBy",testUser, actrual.getLastModifiedBy());
        Assert.assertEquals("incorrect CreationDate",sdf.format(testDate), sdf.format(actrual.getCreationDate()));
        Assert.assertEquals("incorrect LastModificationDate",sdf.format(testDate), sdf.format(actrual.getLastModificationDate()));
        Assert.assertEquals("incorrect Description",testDescription, actrual.getDescription());
        Assert.assertEquals("incorrect Title",testTitle, actrual.getTitle());
        Assert.assertEquals("incorrect FolderPath",testFolderPath, actrual.getPath());

        Assert.assertEquals("incorrect Mimetype",testMimetype, actrual.getMimeType());
        Assert.assertEquals("incorrect Length",testLength, actrual.getLength());

        Assert.assertNotNull(actrual.getAttributes());
        for (String key : actrual.getAttributes().keySet()){
            Assert.assertEquals("incorrect value of [" + key  + "]",testAttributes.get(key), actrual.getAttributes().get(key));
        }
    }

}
