package com.dzhao.simplecms.server.database.model;

import com.dzhao.simplecms.server.model.CmsFileContent;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "cms_document_content")
public class DbFileContent extends AbstractDbDomain implements CmsFileContent {
    @Lob
    private byte[] streamContent;

    public byte[] getStreamContent() {
        return streamContent;
    }

    public void setStreamContent(byte[] streamContent) {
        this.streamContent = streamContent;
    }
}
