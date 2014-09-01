package com.dzhao.simplecms.server.repository.database.model;

import com.dzhao.simplecms.core.api.domain.HasContent;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "cms_document_content")
public class DbFileContent extends AbstractDbDomain implements HasContent {

    @Lob
    private byte[] streamContent;

    public byte[] getStreamContent() {
        return streamContent;
    }

    public void setStreamContent(byte[] streamContent) {
        this.streamContent = streamContent;
    }
}
