package com.dzhao.simplecms.core.server;


public interface CmsObjectService {

    <T> T createDocument(T source) throws IllegalAccessException;

    String createFolder(Object obj);

    String createObject(Object obj);

    String updateDocument(Object obj);

    String updateFolder(Object obj);

    String updateObject(Object obj);

}
