package com.dzhao.simplecms.core.api.domain;

public interface HasContent {

    byte[] getStreamContent();

    void setStreamContent(byte[] streamContent);
}
