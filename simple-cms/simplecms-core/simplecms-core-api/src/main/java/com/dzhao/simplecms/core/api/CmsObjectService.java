package com.dzhao.simplecms.core.api;


import com.dzhao.simplecms.core.api.domain.CmsObject;

public interface CmsObjectService {

    <T> boolean createObject(T source) throws IllegalAccessException;

    <T> boolean updateObject(T source);


}
