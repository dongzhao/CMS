package com.dzhao.simplecms.core.impl;

import com.dzhao.simplecms.core.api.domain.HasContent;
import com.dzhao.simplecms.core.api.domain.IsFile;
import com.dzhao.simplecms.core.api.domain.ObjectType;

import java.util.Map;

public class CmsDocumentObject extends AbstractCmsObject implements IsFile, HasContent {

    private String mimeType;
    private Long length;
    private String versionLabel;
    private Map<String, String> attributes;
    private byte[] streamContent;

    @Override
    public String getObjectType() {
        return ObjectType.CMS_FILE;
    }

    @Override
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String getMimeType() {
        return this.mimeType;
    }

    @Override
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public Long getLength() {
        return this.length;
    }

    @Override
    public void setLength(Long length) {
        this.length = length;
    }

    @Override
    public String getVersionLabel() {
        return this.versionLabel;
    }

    @Override
    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    @Override
    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    @Override
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public byte[] getStreamContent() {
        return this.streamContent;
    }

    @Override
    public void setStreamContent(byte[] streamContent) {
        this.streamContent = streamContent;
    }

}
