package com.dzhao.simplecms.core.impl.server;

import com.dzhao.simplecms.core.ObjectProperties;
import com.dzhao.simplecms.core.annotation.CmsDocument;
import com.dzhao.simplecms.core.annotation.CmsDocumentInfo;
import com.dzhao.simplecms.core.enums.ObjectType;
import com.dzhao.simplecms.core.server.CmsObjectService;

import java.lang.reflect.Field;

public class CmsObjectServiceImpl implements CmsObjectService {

    @Override
    public <T> T createDocument(T source) throws IllegalAccessException {
        Class<?> clazz = source.getClass();
        CmsDocument cms = clazz.getAnnotation(CmsDocument.class);
        if(cms == null)
            throw new UnsupportedOperationException("Unsupported CMS object");

        CmsObjectInfoImpl objectInfo = new CmsObjectInfoImpl();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            CmsDocumentInfo cmsInfo = field.getAnnotation(CmsDocumentInfo.class);
            if(cmsInfo==null || cmsInfo.name().isEmpty())
                continue;

            String name = cmsInfo.name();
            if(name.equals(ObjectProperties.OBJECT_ID)){
                objectInfo.setObjectId(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.OBJECT_NAME)){
                objectInfo.setName(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.OBJECT_TYPE)){
                boolean document = true;
                if(field.get(source)==null || !Boolean.valueOf(String.valueOf(field.get(source)))){
                    document = false;
                }
                objectInfo.setObjectType(document? ObjectType.CMS_FILE : ObjectType.CMS_FOLDER);
            }else if(name.equals(ObjectProperties.PATH)){
                objectInfo.setPath(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.PARENT_PATH)){
                objectInfo.setParentPath(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CREATED_BY)){
                objectInfo.setCreatedBy(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CREATION_DATE)){
                objectInfo.setCreationDate(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.LAST_MODIFIED_BY)){
                objectInfo.setLastModificationBy(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.LAST_MODIFICATION_DATE)){
                objectInfo.setLastModificationDate(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.DESCRIPTION)){
                objectInfo.setDescription(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.VERSION_LABEL)){
                objectInfo.setVersionLabel(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CONTENT_LENGTH)){
                objectInfo.setContentLength(Long.valueOf(String.valueOf(field.get(source))));
            }else if(name.equals(ObjectProperties.CONTENT_MIME_TYPE)){
                objectInfo.setContentMimeType(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.OBJECT_CONTENT_ID)){
                objectInfo.setObjectContentId(String.valueOf(field.get(source)));
            }
        }
        return null;
    }




    @Override
    public String createFolder(Object obj) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String createObject(Object obj) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String updateDocument(Object obj) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String updateFolder(Object obj) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String updateObject(Object obj) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
