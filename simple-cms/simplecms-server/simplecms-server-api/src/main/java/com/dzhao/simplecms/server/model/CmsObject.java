package com.dzhao.simplecms.server.model;

import java.util.Date;

public interface CmsObject {

    String getName();

    void setName(String name);

    String getTitle();

    void setTitle(String title);

    String getFolderPath();

    void setFolderPath(String path);

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
