package com.dzhao.simplecms.core.impl;

import com.dzhao.simplecms.core.ObjectProperties;
import com.dzhao.simplecms.core.annotation.CmsDocument;
import com.dzhao.simplecms.core.annotation.CmsDocumentInfo;
import com.dzhao.simplecms.core.api.domain.ObjectType;

import java.lang.reflect.Field;
import java.sql.Date;

public class CmsObjectConverter {

    private CmsObjectConverter(){}

    public static <T> CmsDocumentObject toCmsObject(T source) throws IllegalAccessException {
        Class<?> clazz = source.getClass();
        CmsDocument cms = clazz.getAnnotation(CmsDocument.class);
        if(cms == null)
            throw new UnsupportedOperationException("Unsupported CMS object");

        CmsDocumentObject cmsObject = new CmsDocumentObject();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            CmsDocumentInfo cmsInfo = field.getAnnotation(CmsDocumentInfo.class);
            if(cmsInfo==null || cmsInfo.name().isEmpty())
                continue;
            String name = cmsInfo.name();
            if(name.equals(ObjectProperties.OBJECT_NAME)){
                cmsObject.setName(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.OBJECT_TYPE)){
                cmsObject.setObjectType(field.get(source)==null ? ObjectType.CMS_FILE : String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.PATH)){
                cmsObject.setPath(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CREATED_BY)){
                cmsObject.setCreatedBy(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CREATION_DATE)){
                cmsObject.setCreationDate(Date.valueOf(String.valueOf(field.get(source))));
            }else if(name.equals(ObjectProperties.LAST_MODIFIED_BY)){
                cmsObject.setLastModifiedBy(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.LAST_MODIFICATION_DATE)){
                cmsObject.setLastModificationDate(Date.valueOf(String.valueOf(field.get(source))));
            }else if(name.equals(ObjectProperties.DESCRIPTION)){
                cmsObject.setDescription(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.VERSION_LABEL)){
                cmsObject.setVersionLabel(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CONTENT_LENGTH)){
                cmsObject.setLength(Long.valueOf(String.valueOf(field.get(source))));
            }else if(name.equals(ObjectProperties.CONTENT_MIME_TYPE)){
                cmsObject.setMimeType(String.valueOf(field.get(source)));
            }else if(name.equals(ObjectProperties.CONTENT_STREAM)){
                Object value = field.get(source);
                if(value == null)
                    continue;
                cmsObject.setStreamContent((byte[]) field.get(source));
            }
        }
        return cmsObject;
    }

}
