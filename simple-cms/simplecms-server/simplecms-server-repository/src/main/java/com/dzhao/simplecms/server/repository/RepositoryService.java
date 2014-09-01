package com.dzhao.simplecms.server.repository;

import com.dzhao.simplecms.core.api.CmsObjectService;
import com.dzhao.simplecms.server.api.domain.RepositoryType;

public interface RepositoryService extends CmsObjectService{
    /**
     *
     * @return
     */
    RepositoryType getRepositoryType();
}
