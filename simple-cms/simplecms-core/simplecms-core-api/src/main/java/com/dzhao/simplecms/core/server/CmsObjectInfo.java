package com.dzhao.simplecms.core.server;


import com.dzhao.simplecms.core.enums.ObjectType;

import java.util.Map;

public interface CmsObjectInfo {

    String getObjectId();

    String getName();

    String getPath();

    String getParentPath();

    String getVersionLabel();


    String getCreatedBy();

    String getCreationDate();


    String getLastModificationBy();


    public String getLastModificationDate();

    public String getDescription();

    public ObjectType getObjectType();


    public String getObjectContentId();


    public Long getContentLength();


    public String getContentMimeType();

    public Map<String, Object> getMetaInfos();

}
