package com.dzhao.simplecms.core.api.domain;


import java.io.Serializable;
import java.util.Date;

public interface CmsObject extends Serializable {

    String getObjectType();

    void setObjectType(String objectType);

    String getName();

    void setName(String name);

    String getTitle();

    void setTitle(String title);

    String getPath();

    void setPath(String path);

    String getDescription();

    void setDescription(String description);

    Date getCreationDate();

    void setCreationDate(Date creationDate);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getLastModificationDate();

    void setLastModificationDate(Date lastModificationDate);

    String getLastModifiedBy();

    void setLastModifiedBy(String lastModifiedBy);
}
