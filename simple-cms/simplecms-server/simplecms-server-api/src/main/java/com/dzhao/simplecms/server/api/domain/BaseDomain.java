package com.dzhao.simplecms.server.api.domain;

import java.io.Serializable;

public interface BaseDomain<ID extends Serializable> extends Serializable{

    ID getId();

    //void setId(ID id);

}
