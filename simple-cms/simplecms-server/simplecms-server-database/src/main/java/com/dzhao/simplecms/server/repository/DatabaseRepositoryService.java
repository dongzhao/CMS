package com.dzhao.simplecms.server.repository;

import com.dzhao.simplecms.core.api.domain.CmsObject;
import com.dzhao.simplecms.core.api.domain.ObjectType;
import com.dzhao.simplecms.core.impl.CmsDocumentObject;
import com.dzhao.simplecms.core.impl.CmsObjectConverter;
import com.dzhao.simplecms.server.api.domain.BaseDomain;
import com.dzhao.simplecms.server.api.domain.RepositoryType;
import com.dzhao.simplecms.server.repository.database.dao.api.Dao;
import com.dzhao.simplecms.server.repository.database.model.DbFile;
import com.dzhao.simplecms.server.repository.database.model.DbFileContent;
import com.dzhao.simplecms.server.repository.database.model.DbFolder;
import com.dzhao.simplecms.server.repository.database.model.DbObject;
import com.google.inject.Inject;

import java.util.Date;

public class DatabaseRepositoryService implements RepositoryService {

    private final Dao<DbFolder, String> dbFolderDao;
    private final Dao<DbFile, String> dbFileDao;
    private final Dao<DbFileContent, String> dbFileContentDao;

    @Inject
    public DatabaseRepositoryService(Dao<DbFolder, String> dbFolderDao, Dao<DbFile, String> dbFileDao,
                                     Dao<DbFileContent, String> dbFileContentDao){
        this.dbFileDao = dbFileDao;
        this.dbFolderDao = dbFolderDao;
        this.dbFileContentDao = dbFileContentDao;
    }

    @Override
    public RepositoryType getRepositoryType() {
        return RepositoryType.DATABASE;
    }

    @Override
    public <T> boolean createObject(T source) throws IllegalAccessException {
        CmsDocumentObject cmsObject = CmsObjectConverter.toCmsObject(source);
        BaseDomain object;
        if(cmsObject.getObjectType().equals(ObjectType.CMS_FOLDER)){
            object = newFolder(cmsObject);
        }else{
            object = newFile(cmsObject);
        }
        return object!=null && object.getId()!=null;
    }

    @Override
    public <T> boolean updateObject(T source) {
        return true;
    }

    private DbFile newFile(CmsDocumentObject cmsObject){
        DbFileContent newFileContent = null;
        if(cmsObject.getStreamContent()!=null){
            DbFileContent dbFileContent = new DbFileContent();
            dbFileContent.setStreamContent(cmsObject.getStreamContent());
            newFileContent = dbFileContentDao.save(dbFileContent);
            if(newFileContent==null || newFileContent.getId()==null)
                throw new RuntimeException("cannot save the file content!");
        }

        DbFile dbFile = newObject(cmsObject, new DbFile());
        dbFile.setMimeType(cmsObject.getMimeType());
        dbFile.setContentStreamId(newFileContent.getId());
        return dbFileDao.save(dbFile);
    }

    private DbFolder newFolder(CmsDocumentObject cmsObject){
        DbFolder folder = newObject(cmsObject, new DbFolder());
        return dbFolderDao.save(folder);
    }

    private static <T> T newObject(CmsDocumentObject cmsObject, T source){
        if( !(source instanceof DbObject) )
            throw new UnsupportedOperationException("unsupported object.");
        DbObject object = (DbObject) source;
        object.setName(cmsObject.getName());
        object.setObjectType(cmsObject.getObjectType());
        object.setPath(cmsObject.getPath());
        object.setTitle(cmsObject.getTitle());
        object.setCreatedBy(cmsObject.getCreatedBy());
        object.setCreationDate(new Date());
        return (T) object;
    }

}
