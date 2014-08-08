package com.dzhao.simplecms.server.model;

import java.io.Serializable;

public interface BaseDomain<ID extends Serializable> extends Serializable{

    ID getId();

    void setId(ID id);

}
