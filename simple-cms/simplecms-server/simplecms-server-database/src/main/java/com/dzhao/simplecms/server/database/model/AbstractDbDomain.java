package com.dzhao.simplecms.server.database.model;


import com.dzhao.simplecms.server.model.BaseDomain;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractDbDomain implements BaseDomain<String> {
    @Id
    protected String id;

    @Version
    protected Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected Long getVersion() {
        return version;
    }

    /**
     * Set to protected as it's not supposed to be called externally
     * @param version
     */
    protected void setVersion(Long version) {
        this.version = version;
    }


}
