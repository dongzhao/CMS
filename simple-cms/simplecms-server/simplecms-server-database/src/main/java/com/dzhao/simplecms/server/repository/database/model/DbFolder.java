package com.dzhao.simplecms.server.repository.database.model;

import com.dzhao.simplecms.core.api.domain.ObjectType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = ObjectType.CMS_FOLDER)
public class DbFolder extends DbObject{

    @Override
    public String getObjectType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setObjectType(String objectType) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
