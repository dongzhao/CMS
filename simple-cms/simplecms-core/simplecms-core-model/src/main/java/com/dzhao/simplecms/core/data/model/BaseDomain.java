package com.dzhao.simplecms.core.data.model;


import java.io.Serializable;

public interface BaseDomain<ID> extends Serializable{
    ID getId();
    void setId(ID id);
}
