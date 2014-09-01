package com.dzhao.simplecms.core.api.domain;


import java.io.Serializable;
import java.util.Map;

public interface IsFile extends Serializable {

    String getMimeType();

    void setMimeType(String mimeType);

    Long getLength();

    void setLength(Long length);

    String getVersionLabel();

    void setVersionLabel(String versionLabel);

     Map<String, String> getAttributes();

     void setAttributes(Map<String, String> attributes);

}
