package com.dzhao.simplecms.server.model;


import java.util.Map;

public interface CmsFile extends CmsObject {

    String getMimeType();

    void setMimeType(String mimeType);

    Long getLength();

    void setLength(Long length);

    String getVersionLabel();

    void setVersionLabel(String versionLabel);

     Map<String, String> getAttributes();

     void setAttributes(Map<String, String> attributes);

}
