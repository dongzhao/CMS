package com.dzhao.simplecms.server.database.model;

import com.dzhao.simplecms.server.model.CmsConstant;
import com.dzhao.simplecms.server.model.CmsFolder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CmsConstant.FOLDER)
public class DbFolder extends DbObject implements CmsFolder {

}
