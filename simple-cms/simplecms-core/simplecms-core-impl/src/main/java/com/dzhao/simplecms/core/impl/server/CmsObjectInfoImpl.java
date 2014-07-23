package com.dzhao.simplecms.core.impl.server;

import com.dzhao.simplecms.core.enums.ObjectType;
import com.dzhao.simplecms.core.server.CmsObjectInfo;

import java.util.Map;

public class CmsObjectInfoImpl implements CmsObjectInfo {
    /**
     * An unique uuid of object
     */
    private String objectId;
    private String name;
    private String path;
    private String parentPath;
    private String versionLabel;
    private String createdBy;
    private String creationDate;
    private String lastModificationBy;
    private String lastModificationDate;
    private String description;
    private ObjectType objectType;
    private String objectContentId;
    private Long contentLength;
    private String contentMimeType;
    private Map<String, Object> metaInfos;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getVersionLabel() {
        return versionLabel;
    }

    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModificationBy() {
        return lastModificationBy;
    }

    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }

    public String getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(String lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public String getObjectContentId() {
        return objectContentId;
    }

    public void setObjectContentId(String objectContentId) {
        this.objectContentId = objectContentId;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentMimeType() {
        return contentMimeType;
    }

    public void setContentMimeType(String contentMimeType) {
        this.contentMimeType = contentMimeType;
    }

    public Map<String, Object> getMetaInfos() {
        return metaInfos;
    }

    public void setMetaInfos(Map<String, Object> metaInfos) {
        this.metaInfos = metaInfos;
    }
}
