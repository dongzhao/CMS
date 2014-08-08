package com.dzhao.simplecms.server.database.model;

import com.dzhao.simplecms.server.model.CmsConstant;
import com.dzhao.simplecms.server.model.CmsFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"JpaAttributeTypeInspection", "JpaModelReferenceInspection", "JpaDataSourceORMInspection"})
@Entity
@DiscriminatorValue(value = CmsConstant.FILE)
public class DbFile extends DbObject implements CmsFile {

    private String versionLabel;
    @NotNull(message = "CmsFile Mime type cannot be null")

    private String mimeType;
    private Long length;

    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="cms_file_attributes", joinColumns=@JoinColumn(name="document_id"))
    private Map<String, String> attributes = new HashMap<String, String>();

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
}
