package com.dzhao.simplecms.server.repository.database.model;

import com.dzhao.simplecms.core.api.domain.ObjectType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"JpaAttributeTypeInspection", "JpaModelReferenceInspection", "JpaDataSourceORMInspection"})
@Entity
@DiscriminatorValue(value = ObjectType.CMS_FILE)
public class DbFile extends DbObject {

    private String versionLabel;
    @NotNull(message = "IsFile Mime type cannot be null")

    private String mimeType;
    private Long length;

    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="cms_file_attributes", joinColumns=@JoinColumn(name="document_id"))
    private Map<String, String> attributes = new HashMap<String, String>();

    private String contentStreamId;

    public String getVersionLabel() {
        return versionLabel;
    }

    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getObjectType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setObjectType(String objectType) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getContentStreamId() {
        return contentStreamId;
    }

    public void setContentStreamId(String contentStreamId) {
        this.contentStreamId = contentStreamId;
    }
}
